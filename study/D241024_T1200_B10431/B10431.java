package study.D241024_T1200_B10431;

import java.io.*;
import java.util.*;

public class B10431 {
    public static void main(String[] args) throws IOException {
        lineUpStudents();
    }

    public static void lineUpStudents() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int SIZE = 20;
        final int TESTCASE = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < TESTCASE; ++i) {
            ArrayList<Integer> line = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int step = Integer.parseInt(st.nextToken());    // 첫번째 순서를 가져온다
            sb.append(step).append(" ");    // 순서를 제일 처음에 추가

            for (int j = 0; j < SIZE; ++j) {    // 20명 학생의 키를 ArrayList에 입력받는다.
                int height = Integer.parseInt(st.nextToken());
                line.add(height);
            }

            int totalMove = 0;  // 총 이동횟수
            for (int j = 0; j < SIZE - 1; ++j) {    // 2번째 학생부터 20번째 학생까지 확인한다.
                int move = 0;   // 현재 인덱스에서 이동횟수
                int fix = j + 1;    // 고정 인덱스
                int chg = fix;      // 비교 인덱스
                int curr = line.get(fix);   // 현재 값
                int prev;                   // 비교 값

                --chg;  // 값 감소
                while(chg >= 0){ // 비교 인덱스가 0 이상인 경우
                    prev = line.get(chg);   // 비교 값 갱신
                    if(prev > curr){    // 비교 값이 더 크면
                        ++move;
                        --chg;  // 한 번더 진행
                    } else {    // 작으면 종료
                        break;
                    }
                }

                if(move > 0){
                    line.remove(fix);
                    line.add(chg + 1, curr);
                }
                totalMove = totalMove + move;
            }

            sb.append(totalMove).append("\n");
        }

        System.out.print(sb.toString());
    }
}
