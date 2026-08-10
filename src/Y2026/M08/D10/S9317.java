package Y2026.M08.D10;

import java.io.*;

public class S9317 {
    public static void main(String[] args) throws IOException {
        dictation();
    }

    public static void dictation() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; ++i) {
            int length = Integer.parseInt(br.readLine().trim());
            String target = br.readLine().trim();
            String result = br.readLine().trim();
            int count = 0;

            for (int j = 0; j < length; ++j) {
                char tc = target.charAt(j);
                char rc = result.charAt(j);

                if (tc == rc) {
                    ++count;
                }
            }

            String line = String.format("#%d %d\n", (i + 1), count);
            sb.append(line);
        }

        System.out.println(sb.toString());
    }
}
