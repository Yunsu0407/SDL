package Y2026.M08.D25;

import java.util.*;
import java.io.*;

public class B14178 {
    public static void main(String[] args) throws IOException {
        calcSprinkler();
    }

    public static void calcSprinkler() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int size = Integer.parseInt(st.nextToken());
            int range = Integer.parseInt(st.nextToken());

            int coverage = range * 2 + 1;
            int count = size / coverage;
            if (size % coverage != 0) {
                count = count + 1;
            }

            String line = String.format("#%d %d\n", (i + 1), count);
            sb.append(line);
        }

        System.out.print(sb.toString());
    }
}
