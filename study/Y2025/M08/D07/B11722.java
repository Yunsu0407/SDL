package study.Y2025.M08.D07;

import java.util.*;
import java.io.*;

public class B11722 {
    public static void main(String[] args) throws IOException {
        LDS();
    }

    public static void LDS() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine().trim());

        int[] list = new int[size];
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        for (int i = size - 1; i >= 0; --i) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> lis = new ArrayList<>();
        for (int num : list) { // 수열의 각 숫자 하나씩 순회
            // 현재 숫자 num이 lis 리스트 안에서 어디에 들어갈 수 있는지 이진 탐색
            int idx = Collections.binarySearch(lis, num);

            if (idx < 0) {
                // binarySearch는 찾는 값이 없으면 (삽입 위치 + 1) * -1을 반환하므로
                // 다시 원래의 삽입 위치로 복원
                idx = -(idx + 1);
            }

            if (idx == lis.size()) {
                // 만약 삽입 위치가 lis의 맨 끝이라면, 증가하는 부분 수열이 연장 가능하다는 의미이므로 추가
                lis.add(num);
            } else {
                // 그렇지 않으면, 해당 위치의 값을 num으로 갱신해서
                // 같은 길이의 수열 중 끝나는 수가 더 적은 쪽으로 유지
                lis.set(idx, num);
            }
        }

        System.out.println(lis.size());
    }
}
