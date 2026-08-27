package Y2026.M08.D27;

import java.io.*;

public class S13547 {
    public static void main(String[] args) throws IOException {
        armWrestling();
    }

    public static void armWrestling() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        final int TOTAL = 15, WIN = 8;

        for (int i = 0; i < testcase; ++i) {
            String given = br.readLine().trim();
            int progressedRound = given.length();
            int winRound = 0;

            for (int j = 0; j < progressedRound; ++j) {
                char c = given.charAt(j);
                if (c == 'o') {
                    ++winRound;
                }
            }

            int leftRound = TOTAL - progressedRound;
            String res = winRound + leftRound >= WIN ? "YES" : "NO";
            String line = String.format("#%d %s\n", (i + 1), res);
            sb.append(line);
        }

        System.out.print(sb.toString());
    }
}
