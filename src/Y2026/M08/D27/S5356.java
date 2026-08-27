package Y2026.M08.D27;

import java.io.*;

public class S5356 {
    public static void main(String[] args) throws IOException {
        readString();
    }

    public static void readString() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; ++i) {
            String[] strs = new String[5];
            int max = 0;
            for (int j = 0; j < strs.length; ++j) {
                strs[j] = br.readLine().trim();
                max = Math.max(max, strs[j].length());
            }

            StringBuilder ans = new StringBuilder();
            for (int j = 0; j < max; ++j) {
                for (String str : strs) {
                    if (j < str.length()) {
                        char c = str.charAt(j);
                        ans.append(c);
                    }
                }
            }

            String line = String.format("#%d %s\n", (i + 1), ans.toString());
            sb.append(line);
        }

        System.out.print(sb.toString());
    }
}
