package solutions.stage3.D240629_T1004_S1213;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class S1213 {
    public static void main(String[] args) throws IOException {
        countStringMatching();
    }

    public static void countStringMatching() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int TESTCASE = 10;
        int[] answer = new int[TESTCASE];

        for (int i = 0; i < TESTCASE; ++i) {
            br.readLine().trim();
            String pattern = br.readLine().trim();
            String text = br.readLine().trim();

            answer[i] = search(text, pattern);
        }

        for (int i = 0; i < TESTCASE; ++i) {
            System.out.printf("#%d %d\n", i + 1, answer[i]);
        }
    }

    public static int search(String text, String pattern) {
        int appearance = 0;
        int n = text.length();
        int m = pattern.length();

        // 1. 패턴과 접두사-접미사 배열 (pi 배열) 구하기
        int[] pi = computePI(pattern);

        // 2. 텍스트와 패턴 비교
        int i = 0;  // 텍스트 인덱스
        int j = 0;  // 패턴 인덱스

        while (i < n) {
            if (pattern.charAt(j) == text.charAt(i)) {
                ++i;
                ++j;
            }
            if (j == m) {
                // 패턴이 텍스트에서 발견된 경우
                ++appearance;
                j = 0;
            } else if (i < n && pattern.charAt(j) != text.charAt(i)) {
                if(j != 0){
                    // 패턴을 이동할 위치 계산
                    j = pi[--j];
                } else{
                    ++i;
                }
            }
        }

        return appearance;
    }

    public static int[] computePI(String pattern) {
        int m = pattern.length();
        int[] pi = new int[m];
        int len = 0;

        // pi[0]는 항상 0
        pi[0] = 0;
        int i = 1;

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                pi[i++] = ++len;
            } else {
                if (len != 0) {
                    len = pi[--len];
                } else {
                    pi[i++] = 0;
                }
            }
        }

        return pi;
    }
}
