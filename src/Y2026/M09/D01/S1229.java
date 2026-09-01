package Y2026.M09.D01;

import java.util.*;
import java.io.*;

public class S1229 {
    public static void main(String[] args) throws IOException {
        code2();
    }

    public static void code2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = 10;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; ++i) {
            int size = Integer.parseInt(br.readLine().trim());

            List<Integer> list = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            for (int j = 0; j < size; ++j) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            Integer.parseInt(br.readLine().trim());
            st = new StringTokenizer(br.readLine().trim());
            while (st.hasMoreTokens()) {
                String token = st.nextToken();

                if (token.equals("I")) {
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());

                    for (int j = 0; j < y; ++j) {
                        int idx = j + x;
                        list.add(idx, Integer.parseInt(st.nextToken()));
                    }
                } else if (token.equals("D")) {
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());

                    for (int j = 0; j < y; ++j) {
                        list.remove(x);
                    }
                }
            }

            StringBuilder ans = new StringBuilder();
            for (int j = 0; j < 10; ++j) {
                ans.append(list.get(j)).append(" ");
            }
            String line = String.format("#%d %s\n", (i + 1), ans.toString());
            sb.append(line);
        }

        System.out.print(sb.toString());
    }
}
