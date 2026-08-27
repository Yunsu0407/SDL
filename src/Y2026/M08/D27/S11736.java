package Y2026.M08.D27;

import java.util.*;
import java.io.*;

public class S11736 {
    public static void main(String[] args) throws IOException {
        normalNumber();
    }

    public static void normalNumber() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; ++i) {
            int size = Integer.parseInt(br.readLine().trim());
            int[] series = new int[size];
            StringTokenizer st = new StringTokenizer(br.readLine().trim());

            for (int j = 0; j < size; ++j) {
                series[j] = Integer.parseInt(st.nextToken());
            }

            int normal = 0;
            for (int j = 1; j < size - 1; ++j) {
                int prev = series[j - 1];
                int curr = series[j];
                int next = series[j + 1];

                int max = Math.max(prev, next);
                int min = Math.min(prev, next);

                if (curr > min && curr < max) {
                    ++normal;
                }
            }

            String line = String.format("#%d %d\n", (i + 1), normal);
            sb.append(line);
        }

        System.out.print(sb.toString());
    }
}
