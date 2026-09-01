package Y2026.M09.D01;

import java.util.*;
import java.io.*;

public class S4676 {
    public static void main(String[] args) throws IOException {
        addDash();
    }

    public static void addDash() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; ++i) {
            String given = br.readLine().trim();
            int order = Integer.parseInt(br.readLine().trim());

            List<Character> list = new ArrayList<>();
            for (int j = 0; j < given.length(); ++j) {
                list.add(given.charAt(j));
            }

            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            List<Integer> insert = new ArrayList<>();
            for (int j = 0; j < order; ++j) {
                insert.add(Integer.parseInt(st.nextToken()));
            }
            insert.sort(Collections.reverseOrder());

            for (int val : insert) {
                list.add(val, '-');
            }

            StringBuilder ans = new StringBuilder();
            for (char c : list) {
                ans.append(c);
            }

            String line = String.format("#%d %s\n", (i + 1), ans.toString());
            sb.append(line);
        }

        System.out.print(sb.toString());
    }
}
