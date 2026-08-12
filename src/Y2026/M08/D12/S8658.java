package Y2026.M08.D12;

import java.util.*;
import java.io.*;

public class S8658 {
    public static void main(String[] args) throws IOException {
        findExtremum();
    }

    public static void findExtremum() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;

            while (st.hasMoreTokens()) {
                String word = st.nextToken();
                int sum = getSum(word);
                max = Math.max(max, sum);
                min = Math.min(min, sum);
            }

            String line = String.format("#%d %d %d\n", (i + 1), max, min);
            sb.append(line);
        }

        System.out.print(sb.toString());
    }

    public static int getSum(String str) {
        int res = 0;

        for (int i = 0; i < str.length(); ++i) {
            int digit = str.charAt(i) - '0';
            res = res + digit;
        }

        return res;
    }
}
