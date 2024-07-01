package solutions.stage3.D240701_T1418_S1218;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class S1218 {
    public static void main(String[] args) throws IOException {
        checkBracket();
    }

    public static void checkBracket() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int TESTCASE = 10;
        int[] answer = new int[TESTCASE];

        // (:small {:middle [:large <:special
        for (int i = 0; i < TESTCASE; ++i) {
            final int length = Integer.parseInt(br.readLine().trim());
            String line = br.readLine().trim();
            if (length % 2 != 0) {
                answer[i] = 0;
                continue;
            }
            int small = 0;
            int middle = 0;
            int large = 0;
            int special = 0;
            for (int j = 0; j < length; ++j) {
                char curr = line.charAt(j);
                switch (curr) {
                    case '(':
                        ++small;
                        break;
                    case '{':
                        ++middle;
                        break;
                    case '[':
                        ++large;
                        break;
                    case '<':
                        ++special;
                        break;
                    case ')':
                        --small;
                        break;
                    case '}':
                        --middle;
                        break;
                    case ']':
                        --large;
                        break;
                    case '>':
                        --special;
                        break;
                }
            }
            if (small == 0 && middle == 0 && large == 0 && special == 0) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }
        for (int i = 0; i < TESTCASE; ++i) {
            System.out.printf("#%d %d\n", i + 1, answer[i]);
        }
    }
}
