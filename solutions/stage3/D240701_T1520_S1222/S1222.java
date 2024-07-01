package solutions.stage3.D240701_T1520_S1222;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class S1222 {
    public static void main(String[] args) throws IOException {
        postfixCalculator();
    }

    public static void postfixCalculator() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int TESTCASE = 10;
        int[] answer = new int[TESTCASE];

        for (int i = 0; i < TESTCASE; ++i) {
            final int length = Integer.parseInt(br.readLine().trim());
            String infix = br.readLine().trim();
            ArrayDeque<String> queue = new ArrayDeque<>();

            for (int j = 0; j < (length / 2) + 1; ++j) {
                String curr = String.valueOf(infix.charAt(2 * j));
                queue.add(curr);
                if(j > 0){
                    queue.add("+");
                }
            }

            ArrayDeque<Integer> stack = new ArrayDeque<>();
            for (String curr : queue) {
                if (!curr.equals("+")) {
                    stack.addFirst(Integer.parseInt(curr));
                } else {
                    int top = stack.removeFirst();
                    int second = stack.removeFirst();
                    stack.addFirst(top + second);
                }
            }
            answer[i] = stack.removeFirst();
        }

        for (int i = 0; i < TESTCASE; ++i) {
            System.out.printf("#%d %d\n", i + 1, answer[i]);
        }
    }
}
