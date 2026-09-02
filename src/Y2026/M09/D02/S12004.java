package Y2026.M09.D02;

import java.util.*;
import java.io.*;

public class S12004 {
    public static void main(String[] args) throws IOException {
        multiTable();
    }

    public static void multiTable() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; ++i) {
            int val = Integer.parseInt(br.readLine().trim());
            Set<Integer> set = new HashSet<>();
            for (int j = 1; j < 10; ++j) {
                set.add(j);
            }

            boolean isPos = false;
            for (int div : set) {
                if (val % div == 0) {
                    int quot = val / div;
                    if (set.contains(quot)) {
                        isPos = true;
                    }
                }
            }

            String res = isPos ? "Yes" : "No";
            String line = String.format("#%d %s\n", (i + 1), res);
            sb.append(line);
        }

        System.out.print(sb.toString());
    }
}
