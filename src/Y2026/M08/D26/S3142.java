package Y2026.M08.D26;

import java.util.*;
import java.io.*;

public class S3142 {
    public static void main(String[] args) throws IOException {
        guessCount();
    }

    public static void guessCount() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int horn = Integer.parseInt(st.nextToken());
            int animal = Integer.parseInt(st.nextToken());

            int uni = 0;
            int twin = 0;
            for (int j = 0; j <= animal; ++j) {
                int rest = animal - j;
                int total = horn - j * 2 - rest;
                if (total == 0) {
                    uni = rest;
                    twin = j;
                    break;
                }
            }

            String line = String.format("#%d %d %d\n", (i + 1), uni, twin);
            sb.append(line);
        }

        System.out.print(sb.toString());
    }
}
