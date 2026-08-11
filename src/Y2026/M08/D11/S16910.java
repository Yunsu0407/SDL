package Y2026.M08.D11;

import java.io.*;

public class S16910 {
    public static void main(String[] args) throws IOException {
        dotInCircle();
    }

    public static void dotInCircle() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; ++i) {
            int n = Integer.parseInt(br.readLine().trim());
            int count = 0;

            for (int x = 1; x <= n; ++x) {
                int inner = n * n - x * x;
                int y = (int) Math.sqrt(inner) + 1;
                count = count + y;
            }
            count = count * 4 + 1;

            String line = String.format("#%d %d\n", (i + 1), count);
            sb.append(line);
        }

        System.out.print(sb.toString());
    }
}
