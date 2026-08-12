package Y2026.M08.D12;

import java.util.*;
import java.io.*;

public class S6958 {
    public static void main(String[] args) throws IOException {
        findFirst();
    }

    public static void findFirst() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int n = Integer.parseInt(st.nextToken()); // person
            int m = Integer.parseInt(st.nextToken()); // problem

            int max = 0;
            int[] scores = new int[n];
            for (int j = 0; j < n; ++j) {
                st = new StringTokenizer(br.readLine().trim());

                for (int k = 0; k < m; ++k) {
                    scores[j] = scores[j] + Integer.parseInt(st.nextToken());
                }
                max = Math.max(max, scores[j]);
            }

            int count = 0;
            for (int j = 0; j < n; ++j) {
                if (max == scores[j]) {
                    ++count;
                }
            }

            String line = String.format("#%d %d %d\n", (i + 1), count, max);
            sb.append(line);
        }

        System.out.print(sb.toString());
    }
}
