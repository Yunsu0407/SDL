package Y2026.M08.D10;

import java.io.*;

public class S13218 {
    public static void main(String[] args) throws IOException {
        groupAssign();
    }

    public static void groupAssign() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < testcase; ++i) {
            int n = Integer.parseInt(br.readLine().trim());
            int count = n / 3;
            String line = String.format("#%d %d\n", (i + 1), count);
            sb.append(line);
        }

        System.out.print(sb.toString());
    }
}
