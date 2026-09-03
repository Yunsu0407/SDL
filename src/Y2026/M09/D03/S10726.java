package Y2026.M09.D03;

import java.util.*;
import java.io.*;

public class S10726 {

    public static void main(String[] args) throws IOException {
        biExpress();
    }

    public static void biExpress() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int bound = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            boolean isOn = true;
            int divisor = 2;
            int cycle = 0;
            while (cycle < bound) {
                int quotient = value / divisor;
                int rest = value % divisor;

                if (rest == 0) {
                    isOn = false;
                    break;
                }

                value = quotient;
                ++cycle;
            }

            String res = isOn ? "ON" : "OFF";
            String line = String.format("#%d %s\n", (i + 1), res);
            sb.append(line);
        }

        System.out.print(sb.toString());
    }
}
