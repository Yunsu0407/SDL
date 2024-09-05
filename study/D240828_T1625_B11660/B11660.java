package study.D240828_T1625_B11660;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Objects;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.LinkedList;

public class B11660 {
    public static void main(String[] args) throws IOException {
        areaSum();
    }

    public static void areaSum() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        int[][] board = new int[N][N + 1];  // 구간 합 추가
        Ordinates[] ords = new Ordinates[M];

        for (int r = 0; r < N; ++r) {
            st = new StringTokenizer(br.readLine().trim());
            int sum = 0;
            for (int c = 0; c < N; ++c) {
                int value = Integer.parseInt(st.nextToken());
                sum = sum + value;
                board[r][c] = value;
            }
            board[r][N] = sum;
        }   // 구간 합 포함 판 수령 완료

        // 1. 구간을 입력받는다.
        for (int r = 0; r < M; ++r) {
            st = new StringTokenizer(br.readLine().trim());
            int[] temp = new int[4];
            for (int c = 0; c < 4; ++c) {
                temp[c] = Integer.parseInt(st.nextToken());
            }
            ords[r] = new Ordinates(temp[0], temp[1], temp[2], temp[3]);
        }   // 좌표 수령 완료

        // 2. 각 구간에 따른 영역의 크기에 대해서 오름차순으로 재정렬한다.
        Arrays.sort(ords);

        // 3. 구간에 대한 값을 저장하는 자료구조를 만든다.
        HashMap<Ordinates, Integer> storeMap = new HashMap<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; ++i) {
            LinkedList<Ordinates> contained = new LinkedList<>();
            if(!storeMap.isEmpty()){
                Set<Ordinates> keySet = storeMap.keySet();
                for(Ordinates ord : keySet){
                    if(ord.isContain(ords[i])){
                        contained.add(ord);
                    }
                }
            }

            LinkedList<Ordinates> purified = new LinkedList<>();
            while(!contained.isEmpty()){
                Ordinates current = contained.remove(0);
                boolean isContained = false;
                for(Ordinates target : contained){
                    if(target.isContain(current)){
                        isContained = true;
                        break;
                    }
                }
                if(!isContained){
                    purified.add(current);
                }
            }
        }
    }

    public static class Ordinates implements Comparable<Ordinates> {
        private int r1, c1, r2, c2, area;

        public Ordinates(int r1, int c1, int r2, int c2) {
            this.r1 = r1;
            this.c1 = c1;
            this.r2 = r2;
            this.c2 = c2;
            this.area = (r2 - r1) * (c2 - c1);
        }

        @Override
        public int compareTo(Ordinates other) {
            return Integer.compare(this.area, other.area);
        }

        @Override
        public int hashCode() {
            return Objects.hash(r1, c1, r2, c2);
        }   // 고유한 해시코드를 계싼하여 반환

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Ordinates ord = (Ordinates) o;
            return this.r1 == ord.r1 && this.c1 == ord.c1 && this.r2 == ord.r2 && this.c2 == ord.c2;
        }   // 두 객체가 동일한지 비교

        public boolean isContain(Ordinates current){
            return current.r1 >= this.r1 && current.c1 >= this.c1 && current.r2 <= this.r2 && current.c2 <= this.c2;
        }
    }
}
