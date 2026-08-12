package Y2026.M08.D12;

import java.util.*;
import java.io.*;

public class S7102 {
    public static void main(String[] args) throws IOException {
        appearancePossibility();
    }

    public static void appearancePossibility() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int n = Integer.parseInt(st.nextToken()) + 1;
            int m = Integer.parseInt(st.nextToken()) + 1;
            int[] freq = new int[m + n];

            int max = 0;
            for (int j = 1; j < n; ++j) {
                for (int k = 1; k < m; ++k) {
                    ++freq[j + k];
                    max = Math.max(max, freq[j + k]);
                }
            }

            StringBuilder ans = new StringBuilder();
            for (int j = 0; j < freq.length; ++j) {
                if (freq[j] == max) {
                    String unit = String.format("%d ", j);
                    ans.append(unit);
                }
            }

            String line = String.format("#%d %s\n", (i + 1), ans.toString());
            sb.append(line);
        }

        System.out.print(sb.toString());
    }
}
