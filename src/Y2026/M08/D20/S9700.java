package Y2026.M08.D20;

import java.util.*;
import java.io.*;

public class S9700 {
    public static void main(String[] args) throws IOException {
        mysteryUSB();
    }

    public static void mysteryUSB() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            double p = Double.parseDouble(st.nextToken());
            double q = Double.parseDouble(st.nextToken());

            // 1번 뒤집: 잘못된(불능) (뒤집) 올바른(성공)
            double s1 = (1 - p) * q;
            // 2번 뒤집: 올바른(실패) (뒤집) 잘못된(불능) (뒤집) 올바른(성공)
            double s2 = p * (1 - q) * 1 * q;

            String result = s1 < s2 ? "YES" : "NO";
            String line = String.format("#%d %s\n", (i + 1), result);
            sb.append(line);
        }

        System.out.print(sb.toString());
    }

}
