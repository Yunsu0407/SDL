package Y2026.M08.D27;

import java.util.*;
import java.io.*;

public class S7532 {
    public static void main(String[] args) throws IOException {
        guessYear();
    }

    public static void guessYear() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            final int S = 365, E = 24, M = 29;
            int s = Integer.parseInt(st.nextToken()) % S;
            int e = Integer.parseInt(st.nextToken()) % E;
            int m = Integer.parseInt(st.nextToken()) % M;

            int value = 1;
            while (true) {
                int restS = value % S;
                int restE = value % E;
                int restM = value % M;

                if (restS == s && restE == e && restM == m) {
                    break;
                }

                ++value;
            }

            String line = String.format("#%d %d\n", (i + 1), value);
            sb.append(line);
        }

        System.out.print(sb.toString());
    }
}