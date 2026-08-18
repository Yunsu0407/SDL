package Y2026.M08.D18;

import java.io.*;

public class S9997 {
    public static void main(String[] args) throws IOException {
        simpleWatch();
    }

    public static void simpleWatch() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; ++i) {
            int degree = Integer.parseInt(br.readLine().trim());
            int coef = 12 * 60 / 360;
            int totalMinute = coef * degree;

            int hour = totalMinute / 60;
            int minute = totalMinute % 60;

            String line = String.format("#%d %d %d\n", (i + 1), hour, minute);
            sb.append(line);
        }

        System.out.print(sb.toString());
    }
}
