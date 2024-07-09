package solutions.stage3.D240709_T0924_S1225;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;

public class S1225 {
    public static void main(String[] args) throws IOException {
        encoding();
    }

    public static void encoding() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int TESTCASE = 10;
        String[] answer = new String[TESTCASE];

        for (int i = 0; i < TESTCASE; ++i) {
            br.readLine();   // 입력 번호 수령
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            LinkedList<Integer> list = new LinkedList<>(); // 암호 배열
            final int EIGHT = 8;    // 암호 개수

            for (int j = 0; j < EIGHT; ++j) { // 암호 입력
                int input = Integer.parseInt(st.nextToken());
                list.add(input);  // 리스트에 푸쉬
            }

            int diminution = 0; // 감소량
            while (true) {
                diminution = diminution % 5;    // 감소량이 5를 벗어나지 않게 유지
                ++diminution;
                int curr = list.pop(); // 조정할 값을 수령
                curr = curr - diminution;   // 값을 조정

                boolean endLoop = false;
                if (curr <= 0) {    // 음수값 조정 및 종료조건 확인
                    curr = 0;   // 음수값 조정
                    endLoop = true; // 종료조건 설정
                }
                list.add(curr);    // 값 조정 후 다시 삽입

                if (endLoop) {  // 종료조건
                    break;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int curr : list) {
                sb.append(curr);
                sb.append(" ");
            }

            answer[i] = sb.toString();
        }

        br.close();
        for (int i = 0; i < TESTCASE; ++i) {
            System.out.printf("#%d %s\n", i + 1, answer[i]);
        }
    }
}
