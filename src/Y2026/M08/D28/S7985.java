package Y2026.M08.D28;

import java.util.*;
import java.io.*;

public class S7985 {
    public static void main(String[] args) throws IOException {
        treeRestruct();
    }

    public static void treeRestruct() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; ++i) {
            int depth = Integer.parseInt(br.readLine().trim());
            int size = (int) Math.pow(2, depth) - 1;
            int[] org = new int[size];

            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            for (int j = 0; j < size; ++j) {
                int val = Integer.parseInt(st.nextToken());
                org[j] = val;
            }

            List<Integer> sorted = new ArrayList<>();
            int start = size;
            for (int d = 0; d < depth; ++d) {
                start = start / 2;
                int jump = (int) Math.pow(2, depth - d);
                for (int r = start; r <= size; r = r + jump) {
                    sorted.add(org[r]);
                }
            }

            StringBuilder ans = new StringBuilder();
            for (int d = 0; d < depth; ++d) {
                int end = (int) Math.pow(2, d);
                for (int r = 0; r < end; ++r) {
                    int val = sorted.remove(0);
                    ans.append(val).append(" ");
                }
                ans.append("\n");
            }

            String line = String.format("#%d %s", (i + 1), ans.toString());
            sb.append(line);
        }

        System.out.print(sb.toString());
    }
}
