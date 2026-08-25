package Y2026.M08.D25;

import java.util.*;
import java.io.*;

public class S6692 {
    public static void main(String[] args) throws IOException {
        moneyBox();
    }

    public static void moneyBox() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; ++i) {
            int n = Integer.parseInt(br.readLine().trim());
            double average = 0.0;
            for (int j = 0; j < n; ++j) {
                StringTokenizer st = new StringTokenizer(br.readLine().trim());
                double pos = Double.parseDouble(st.nextToken());
                int pay = Integer.parseInt(st.nextToken());
                average = average + pos * pay;
            }

            String line = String.format("#%d %f", (i + 1), average);
            sb.append(line);
        }

        System.out.print(sb.toString());
    }
}
