package Y2026.M08.D27;

import java.util.*;
import java.io.*;

public class S5515 {
    public static void main(String[] args) throws IOException {
        guess2016();
    }

    public static void guess2016() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        int[] months = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int[] days = { 4, 5, 6, 0, 1, 2, 3 }; // 금 토 일 왈 화 수 목

        for (int i = 0; i < testcase; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int month = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());
            int accure = 0;

            for (int j = 1; j < month; ++j) {
                accure = accure + months[j];
            }

            accure = accure + day;

            int specDay = days[(accure - 1) % 7];
            String line = String.format("#%d %d\n", (i + 1), specDay);
            sb.append(line);
        }

        System.out.print(sb.toString());
    }
}
