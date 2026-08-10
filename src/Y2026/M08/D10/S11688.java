package Y2026.M08.D10;

import java.io.*;

public class S11688 {
    public static void main(String[] args) throws IOException {
        cwTree();
    }

    public static void cwTree() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; ++i) {
            String given = br.readLine().trim();

            int[] node = new int[] { 1, 1 };
            for (int j = 0; j < given.length(); ++j) {
                char c = given.charAt(j);
                int idx = c == 'L' ? 1 : 0;
                node[idx] = node[0] + node[1];
            }

            String line = String.format("#%d %d %d\n", (i + 1), node[0], node[1]);
            sb.append(line);
        }

        System.out.print(sb.toString());
    }
}
