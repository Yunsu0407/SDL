package solutions.stage3.D240701_T1455_S8931;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class S8931 {
    public static void main(String[] args) throws IOException {
        manageExpense();
    }

    public static void manageExpense() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int testcase = Integer.parseInt(br.readLine().trim());
        int[] answer = new int[testcase];

        for (int i = 0; i < testcase; ++i) {
            final int count = Integer.parseInt(br.readLine().trim());
            ArrayDeque<Integer> totalExpense = new ArrayDeque<>();

            for (int j = 0; j < count; ++j) {
                int expense = Integer.parseInt(br.readLine().trim());
                if (expense == 0) {
                    totalExpense.removeFirst();
                } else {
                    totalExpense.addFirst(expense);
                }
            }

            answer[i] = 0;
            for (int expense : totalExpense) {
                answer[i] = answer[i] + expense;
            }
        }

        for (int i = 0; i < testcase; ++i) {
            System.out.printf("#%d %d\n", i + 1, answer[i]);
        }
    }
}
