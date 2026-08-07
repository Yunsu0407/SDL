package Y2026.M08.D07;

import java.io.*;

public class S15941 {
    public static void main(String[] args) throws IOException {
        maxParallelogram();
    }

    public static void maxParallelogram() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; ++i) {
            int length = Integer.parseInt(br.readLine().trim());
            int area = length * length;
            String line = String.format("#%d %d\n", (i + 1), area);
            sb.append(line);
        }

        System.out.print(sb.toString());
    }
}
