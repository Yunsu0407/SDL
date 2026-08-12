package Y2026.M08.D12;

import java.io.*;

public class S5601 {
    public static void main(String[] args) throws IOException {
        divideJuice();
    }

    public static void divideJuice() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; ++i) {
            int size = Integer.parseInt(br.readLine().trim());

            StringBuilder ans = new StringBuilder();
            for (int j = 0; j < size; ++j) {
                String unit = String.format("1/%d ", size);
                ans.append(unit);
            }

            String line = String.format("#%d %s\n", (i + 1), ans.toString());
            sb.append(line);
        }

        System.out.print(sb.toString());
    }
}
