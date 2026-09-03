package Y2026.M09.D03;

import java.io.*;

public class S15230 {
    public static void main(String[] args) throws IOException {
        studyAlphabet();
    }

    public static void studyAlphabet() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; ++i) {
            String given = br.readLine().trim();
            int correct = 0;

            for (int j = 0; j < given.length(); ++j) {
                char c = given.charAt(j);
                if (c - ('a' + j) == 0) {
                    ++correct;
                } else {
                    break;
                }
            }

            String line = String.format("#%d %d\n", (i + 1), correct);
            sb.append(line);
        }

        System.out.print(sb.toString());
    }
}
