package Y2026.M09.D03;

import java.util.*;
import java.io.*;

public class S4299 {
    public static void main(String[] args) throws IOException {
        waiting();
    }

    public static void waiting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int[] base = { 11, 11, 11 };
            int[] end = new int[base.length];
            for (int j = 0; j < end.length; ++j) {
                end[j] = Integer.parseInt(st.nextToken());
            }

            int baseMinute = convert(base);
            int endMinute = convert(end);
            int diff = endMinute - baseMinute;
            int ans = diff >= 0 ? diff : -1;

            String line = String.format("#%d %d\n", (i + 1), ans);
            sb.append(line);
        }

        System.out.print(sb.toString());
    }

    public static int convert(int[] moment) {
        int minute = 0;
        int[] mul = { 24 * 60, 60, 1 };
        for (int i = 0; i < moment.length; ++i) {
            minute = minute + moment[i] * mul[i];
        }

        return minute;
    }
}
