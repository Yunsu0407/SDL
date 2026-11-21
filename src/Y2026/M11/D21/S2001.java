package Y2026.M11.D21;

import java.util.*;
import java.io.*;

public class S2001 {
    public static void main(String[] args) throws IOException {
        catchFly();
    }

    public static void catchFly() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < tc; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] arr = new int[n][n];
            for (int r = 0; r < n; ++r) {
                st = new StringTokenizer(br.readLine().trim());
                for (int c = 0; c < n; ++c) {
                    arr[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            int range = n - m + 1;
            int max = 0;
            for (int r = 0; r < range; ++r) {
                for (int c = 0; c < range; ++c) {
                    int sum = 0;
                    for (int sr = r; sr < r + m; ++sr) {
                        for (int sc = c; sc < c + m; ++sc) {
                            sum = sum + arr[sr][sc];
                        }
                    }

                    max = Math.max(max, sum);
                }
            }

            String line = String.format("#%d %d\n", (i + 1), max);
            sb.append(line);
        }

        System.out.print(sb.toString());
    }
}
