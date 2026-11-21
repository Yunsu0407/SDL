package Y2026.M11.D21;

import java.io.*;

public class S1289 {
    public static void main(String[] args) throws IOException {
        recoverMemory();
    }

    public static void recoverMemory() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < tc; ++i) {
            String str = br.readLine().trim();
            char prev = '0';
            int count = 0;

            for (int j = 0; j < str.length(); ++j) {
                char curr = str.charAt(j);
                count = prev == curr ? count : count + 1;
                prev = curr;
            }

            String line = String.format("#%d %d\n", (i + 1), count);
            sb.append(line);
        }

        System.out.print(sb.toString());
    }
}
