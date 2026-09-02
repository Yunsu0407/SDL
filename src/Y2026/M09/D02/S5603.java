package Y2026.M09.D02;

import java.io.*;

public class S5603 {
    public static void main(String[] args) throws IOException {
        moveHay();
    }

    public static void moveHay() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; ++i) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] hays = new int[n];
            int sum = 0;

            for (int j = 0; j < n; ++j) {
                int hay = Integer.parseInt(br.readLine().trim());
                hays[j] = hay;
                sum = sum + hay;
            }

            int avg = sum / n;
            int movement = 0;
            for (int hay : hays) {
                if (hay > avg) {
                    movement = movement + (hay - avg);
                }
            }

            String line = String.format("#%d %d\n", (i + 1), movement);
            sb.append(line);
        }

        System.out.print(sb.toString());
    }
}
