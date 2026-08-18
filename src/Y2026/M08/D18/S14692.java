package Y2026.M08.D18;

import java.io.*;

public class S14692 {
    public static void main(String[] args) throws IOException {
        cutLog();
    }

    public static void cutLog() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; ++i) {
            String value = br.readLine().trim();
            int digit = value.charAt(value.length() - 1);
            String winner = digit % 2 == 0 ? "Alice" : "Bob";

            String line = String.format("#%d %s\n", (i + 1), winner);
            sb.append(line);
        }

        System.out.print(sb.toString());
    }
}
