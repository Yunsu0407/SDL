package Y2026.M08.D18;

import java.io.*;

public class S5549 {
    public static void main(String[] args) throws IOException {
        judgeNumber();
    }

    public static void judgeNumber() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; ++i) {
            String number = br.readLine().trim();
            int len = number.length();
            int digit = number.charAt(len - 1) - '0';
            System.out.println("? " + digit);
            String result = digit % 2 == 0 ? "Even" : "Odd";
            String line = String.format("#%d %s\n", (i + 1), result);
            sb.append(line);
        }

        System.out.print(sb.toString());
    }
}
