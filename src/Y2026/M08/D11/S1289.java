package Y2026.M08.D10;

import java.io.*;

public class S1289 {
    public static void main(String[] args) throws IOException {
        fixMemory();
    }

    public static void fixMemory() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; ++i) {
            String given = br.readLine().trim();
            int prev = 0;

            int count = 0;
            for (int j = 0; j < given.length(); ++j) {
                int curr = given.charAt(j) - '0';

                if (prev != curr) {
                    ++count;
                    prev = curr;
                }
            }

            String line = String.format("#%d %d\n", (i + 1), count);
            sb.append(line);
        }

        System.out.println(sb.toString());
    }
}