package Y2026.M08.D25;

import java.io.*;

public class S8821 {
    public static void main(String[] args) throws IOException {
        writeErase();
    }

    public static void writeErase() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; ++i) {
            String call = br.readLine().trim();
            boolean[] isCalled = new boolean[10];

            for (int j = 0; j < call.length(); ++j) {
                int curr = call.charAt(j) - '0';
                isCalled[curr] = !isCalled[curr];
            }

            int count = 0;
            for (boolean called : isCalled) {
                if (called) {
                    ++count;
                }
            }

            String line = String.format("#%d %d\n", (i + 1), count);
            sb.append(line);
        }

        System.out.print(sb.toString());
    }
}
