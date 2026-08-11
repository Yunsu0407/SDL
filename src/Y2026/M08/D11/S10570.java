package Y2026.M08.D11;

import java.util.*;
import java.io.*;

public class S10570 {
    public static void main(String[] args) throws IOException {
        checkPalindrome();
    }

    public static void checkPalindrome() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int lower = Integer.parseInt(st.nextToken());
            int upper = Integer.parseInt(st.nextToken());
            int count = 0;

            for (int curr = lower; curr < upper + 1; ++curr) {
                if (!isPalindrome(curr)) {
                    continue;
                }

                double dSqrt = Math.sqrt(curr);
                int iSqrt = (int) dSqrt;

                if (dSqrt != iSqrt) {
                    continue;
                }

                if (isPalindrome(iSqrt)) {
                    ++count;
                }
            }

            String line = String.format("#%d %d\n", (i + 1), count);
            sb.append(line);
        }

        System.out.print(sb.toString());
    }

    public static boolean isPalindrome(int curr) {
        boolean res = true;
        String sen = String.valueOf(curr);
        int senLength = sen.length();
        int limit = senLength / 2;

        for (int i = 0; i < limit; ++i) {
            char front = sen.charAt(i);
            char rear = sen.charAt(senLength - (i + 1));

            if (front != rear) {
                res = false;
                break;
            }
        }

        return res;
    }
}
