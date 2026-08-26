package Y2026.M08.D26;

import java.util.*;
import java.io.*;

public class S5162 {
    public static void main(String[] args) throws IOException {
        maxBread();
    }

    public static void maxBread() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int rice = Integer.parseInt(st.nextToken());
            int pumpkin = Integer.parseInt(st.nextToken());
            int asset = Integer.parseInt(st.nextToken());

            int min = Math.min(rice, pumpkin);
            int count = asset / min;

            String line = String.format("#%d %d\n", (i + 1), count);
            sb.append(line);
        }

        System.out.print(sb.toString());
    }
}
