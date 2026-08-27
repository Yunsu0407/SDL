package Y2026.M08.D27;

import java.io.*;
import java.util.*;

public class S1221 {
    public static void main(String[] args) throws IOException {
        convert();
    }

    public static void convert() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        String[] days = new String[] { "ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN" };
        Map<String, Integer> converter = new HashMap<>();
        for (int i = 0; i < days.length; ++i) {
            converter.put(days[i], i);
        }

        for (int i = 0; i < testcase; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            st.nextToken();
            int size = Integer.parseInt(st.nextToken());

            int[] digits = new int[10];
            st = new StringTokenizer(br.readLine().trim());
            for (int j = 0; j < size; ++j) {
                String key = st.nextToken();
                int value = converter.get(key);
                ++digits[value];
            }

            StringBuilder ans = new StringBuilder();
            for (int j = 0; j < digits.length; ++j) {
                int cycle = digits[j];
                String key = days[j];
                for (int k = 0; k < cycle; ++k) {
                    ans.append(key).append(" ");
                }
            }

            String line = String.format("#%d %s\n", (i + 1), ans.toString());
            sb.append(line);
        }

        System.out.print(sb.toString());
    }
}
