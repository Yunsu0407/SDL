package Y2026.M08.D12;

import java.io.*;

public class S5601 {
    public static void main(String[] args) throws IOException {
        divideJuice();
    }

    public static String input1 = "2\r\n" + //
            "1\r\n" + //
            "2";

    public static String input2 = "1\r\n" + //
            "5";

    public static void divideJuice() throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader(input2));
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
