package Solutions.D240623_T0826_S1204;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1204 {
    public static void main(String[] args) throws IOException {
        findMode();
    }

    public static void findMode() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        final int SCORE_RANGE = 101;   // 101
        final int STUDENT_NUMBER = 1000; // 1000, STUDENT_NUMBER = number of student
        int testcase;
        int[] counts;
        int[] answer;
        int score;

        testcase = Integer.parseInt(br.readLine().trim());  // 테스트케이스 입력
        answer = new int[testcase]; // 정답배열 생성

        for (int i = 0; i < testcase; ++i) {  // 테스트케이스만큼 반복
            counts = new int[SCORE_RANGE];
            br.readLine().trim();
            st = new StringTokenizer(br.readLine().trim());

            for (int j = 0; j < STUDENT_NUMBER; ++j) {
                score = Integer.parseInt(st.nextToken());
                ++counts[score];  // 0부터 100까지 증가
            }

            int currCount, modeCount, modeIndex, currIndex;
            modeCount = Integer.MIN_VALUE;
            modeIndex = 0;
            for (int j = 0; j < SCORE_RANGE; ++j) {
                currIndex = SCORE_RANGE - (j + 1);
                currCount = counts[currIndex];
                if (modeCount < currCount) {    // 최빈수가 갱신되는 경우
                    modeCount = currCount;
                    modeIndex = currIndex;
                }
            }
            answer[i] = modeIndex;
        }

        for (int i = 0; i < testcase; ++i) {
            System.out.println("#" + (i + 1) + " " + answer[i]);
        }
    }
}