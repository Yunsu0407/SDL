package solutions.stage3.D240701_T0903_S5432;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class S5432 {
    public static void main(String[] args) throws IOException {
        getPoles();
    }

    public static void getPoles() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());
        int[] answer = new int[testcase];

        for (int i = 0; i < testcase; ++i) {
            String line = br.readLine().trim();
            int length = line.length();
            int pole = 0;
            int sum = 0;
            boolean isOpen = true;

            for (int j = 0; j < length; ++j) {
                char curr = line.charAt(j);
                if (curr == '(') {
                    ++pole;
                } else {
                    char prev = line.charAt(j - 1);
                    --pole;
                    if (prev == '(') {    // laser
                        sum = sum + pole;
                    } else { // pole
                        ++sum;
                    }
                }

            }
            answer[i] = sum;
        }

        for (int i = 0; i < testcase; ++i) {
            System.out.printf("#%d %d\n", i + 1, answer[i]);
        }
    }
}
