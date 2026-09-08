package Y2026.M09.D08;

import java.io.*;

public class S4047 {
    public static void main(String[] args) throws IOException {
        checkCard();
    }

    public static void checkCard() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; ++i) {
            String given = br.readLine().trim();
            boolean[][] cards = new boolean[4][13];
            String shape = "SDHC";

            boolean isError = false;
            for (int j = 0; j <= given.length() - 3; j = j + 3) {
                String sub = given.substring(j, j + 3);
                int row = shape.indexOf(sub.charAt(0));
                int col = Integer.parseInt(sub.substring(1, 3)) - 1;

                if (cards[row][col]) {
                    isError = true;
                    break;
                }
                cards[row][col] = true;
            }

            StringBuilder ans = new StringBuilder();
            if (isError) {
                ans.append("ERROR");
            } else {
                for (int r = 0; r < cards.length; ++r) {
                    int need = 0;
                    for (int c = 0; c < cards[r].length; ++c) {
                        if (!cards[r][c]) {
                            ++need;
                        }
                    }

                    ans.append(need).append(" ");
                }
            }

            String line = String.format("#%d %s\n", (i + 1), ans.toString());
            sb.append(line);
        }

        System.out.print(sb.toString());
    }

    public static int getRow(char c) {
        int ret;
        if (c == 'S') {
            ret = 0;
        } else if (c == 'D') {
            ret = 1;
        } else if (c == 'H') {
            ret = 2;
        } else {
            ret = 3;
        }

        return ret;
    }
}
