package solutions.stage3.D240709_T1013_S7102;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S7102 {
    public static void main(String[] args) throws IOException {
        calculateProbability();
    }

    public static void calculateProbability() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int testcase = Integer.parseInt(br.readLine().trim());
        String[] answer = new String[testcase];

        for (int i = 0; i < testcase; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            final int SET_NUMBER = 2;
            int[] cardSet = new int[SET_NUMBER];

            int totalLimit = -1;
            for (int j = 0; j < SET_NUMBER; ++j) {    // 각 카드 덱의 수를 구하고, 최대 등장 수를 구함
                int limit = Integer.parseInt(st.nextToken());
                cardSet[j] = limit;
                totalLimit = totalLimit + limit;
            }

            // 1, 2 -> 2, 3 // 2, 3 -> 2, 3, 4, 3, 4, 5
            int maxAppearance = 0;  // 최대 등장 횟수
            int[] appearance = new int[totalLimit]; // 출현 가능한 합산 수
            for (int j = 0; j < cardSet[0]; ++j) {
                for (int k = 0; k < cardSet[1]; ++k) {
                    int sum = j + k;
                    ++appearance[sum];  // 등장한 수를 기록
                    if (maxAppearance < appearance[sum]) {
                        maxAppearance = appearance[sum];    // 최대 등장 횟수 갱신
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < totalLimit; ++j) {
                if (appearance[j] == maxAppearance) {   // 최대 등장횟수와 일치하는 원소
                    sb.append(j + 2);   // 그 값을 입력
                    sb.append(" ");
                }
            }

            answer[i] = sb.toString();
        }
        br.close();

        for (int i = 0; i < testcase; ++i) {
            System.out.printf("#%d %s\n", i + 1, answer[i]);
        }
    }
}
