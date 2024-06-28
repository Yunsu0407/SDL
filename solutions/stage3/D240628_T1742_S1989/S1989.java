package solutions.stage3.D240628_T1742_S1989;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class S1989 {
    public static void main(String[] args) throws IOException {
        checkPalindrome();
    }

    public static void checkPalindrome() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int testcase = Integer.parseInt(br.readLine().trim());
        int[] answer = new int[testcase];

        for (int i = 0; i < testcase; ++i) {
            String string = br.readLine().trim();
            int length = string.length();
            int cycle = length / 2;
            int palindrome = 1;
            for (int j = 0; j < cycle; ++j) {
                if (string.charAt(j) != string.charAt(length - (j + 1))) {
                    palindrome = 0;
                    break;
                }
            }
            answer[i] = palindrome;
        }

        for (int i = 0; i < testcase; ++i) {
            System.out.printf("#%d %d\n", i + 1, answer[i]);
        }
    }
}
