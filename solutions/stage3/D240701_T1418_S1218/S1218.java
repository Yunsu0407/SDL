package solutions.stage3.D240701_T1418_S1218;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

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

            ArrayDeque<Character> brackets = new ArrayDeque<>();
            answer[i] = 1;
            for (int j = 0; j < length; ++j) {
                char curr = line.charAt(j);
                boolean endLoop = false;
                if (curr == '(' || curr == '{' || curr == '[' || curr == '<') {
                    brackets.addFirst(curr);
                } else {
                    char top = brackets.removeFirst();
                    switch (curr) {
                        case ')':
                            if (top != '(') {
                                endLoop = true;
                            }
                            break;
                        case '}':
                            if (top != '{') {
                                endLoop = true;
                            }
                            break;
                        case ']':
                            if (top != '[') {
                                endLoop = true;
                            }
                            break;
                        case '>':
                            if (top != '<') {
                                endLoop = true;
                            }
                            break;
                    }
                }
                if (endLoop) {
                    answer[i] = 0;
                    break;
                }
            }
        }
        for (int i = 0; i < TESTCASE; ++i) {
            System.out.printf("#%d %d\n", i + 1, answer[i]);
        }
    }
}
