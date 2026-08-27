package Y2026.M08.D27;

import java.util.*;
import java.io.*;

public class S10200 {
    public static void main(String[] args) throws IOException {
        subWar();
    }

    public static void subWar() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int n = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int max = Math.min(a, b);
            int min = a + b <= n ? 0 : a + b - n;

            String line = String.format("#%d %d %d\n", (i + 1), max, min);
            sb.append(line);
        }

        System.out.print(sb.toString());
    }
}
