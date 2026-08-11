package Y2026.M08.D11;

import java.io.*;

public class S7728 {
    public static void main(String[] args) throws IOException {
        numberDiversity();
    }

    public static void numberDiversity() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; ++i) {
            String given = br.readLine().trim();
            boolean[] isAppear = new boolean[10];

            for (int j = 0; j < given.length(); ++j) {
                int digit = given.charAt(j) - '0';
                isAppear[digit] = true;
            }

            int diversity = 0;
            for (boolean b : isAppear) {
                if (b) {
                    ++diversity;
                }
            }

            String line = String.format("#%d %d\n", (i + 1), diversity);
            sb.append(line);
        }

        System.out.print(sb.toString());
    }
}
