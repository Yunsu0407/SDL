package Y2026.M08.D07;

import java.util.*;
import java.io.*;

public class S12368 {
    public static void main(String[] args) throws IOException {
        hour24();
    }

    public static String input = "3\r\n" +
            "1 9\r\n" +
            "7 17\r\n" +
            "23 23";

    public static void hour24() throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader(input));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int src = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            int dst = (src + cost) % 24;
            String line = String.format("#%d %d\n", (i + 1), dst);
            sb.append(line);
        }

        System.out.print(sb.toString());
    }
}
