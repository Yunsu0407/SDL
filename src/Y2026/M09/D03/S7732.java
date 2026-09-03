package Y2026.M09.D03;

import java.util.*;
import java.io.*;

public class S7732 {
    public static void main(String[] args) throws IOException {
        timeConcept();
    }

    public static void timeConcept() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; ++i) {
            int[][] time = new int[2][3];
            for (int j = 0; j < time.length; ++j) {
                StringTokenizer st = new StringTokenizer(br.readLine().trim(), ":");
                for (int k = 0; k < time[0].length; ++k) {
                    time[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            int curr = convert(time[0]);
            int appo = convert(time[1]);
            if (appo < curr) {
                time[1][0] = time[1][0] + 24;
                appo = convert(time[1]);
            }

            int diff = convert(time[1]) - convert(time[0]);
            int[] res = new int[3];
            int[] div = { 60 * 60, 60, 1 };
            int[] mod = { 24, 60, 60 };
            for (int j = 0; j < res.length; ++j) {
                res[j] = (diff / div[j]) % mod[j];
            }

            String result = String.format("%2d:%2d:%2d", res[0], res[1], res[2]).replace(" ", "0");
            String line = String.format("#%d %s\n", (i + 1), result);
            sb.append(line);
        }

        System.out.print(sb.toString());
    }

    public static int convert(int[] time) {
        int second = 0;
        int[] mul = { 60 * 60, 60, 1 };
        for (int i = 0; i < time.length; ++i) {
            second = second + time[i] * mul[i];
        }

        return second;
    }
}
