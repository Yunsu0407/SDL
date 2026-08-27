package Y2026.M08.D27;

import java.io.*;

public class S7510 {
    public static void main(String[] args) throws IOException {
        straightSum();
    }

    public static void straightSum() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; ++i) {
            int target = Integer.parseInt(br.readLine().trim());
            int count = 0;

            for (int j = 1; j <= target; ++j) {
                int vari = target;
                int weight = j;
                while (vari > 0) {
                    vari = vari - weight;

                    if (vari == 0) {
                        ++count;
                    }
                    ++weight;
                }
            }

            String line = String.format("#%d %d\n", (i + 1), count);
            sb.append(line);
        }

        System.out.print(sb.toString());
    }
}
