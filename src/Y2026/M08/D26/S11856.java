package Y2026.M08.D26;

import java.util.*;
import java.io.*;

public class S11856 {
    public static void main(String[] args) throws IOException {
        checkString();
    }

    public static void checkString() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; ++i) {
            String given = br.readLine().trim();

            Map<Character, Integer> map = new HashMap<>();
            for (int j = 0; j < given.length(); ++j) {
                char c = given.charAt(j);
                int value = 0;
                if (map.containsKey(c)) {
                    value = map.get(c);
                }
                map.put(c, value + 1);
            }

            boolean isFine = true;
            for (int value : map.values()) {
                if (value != 2) {
                    isFine = false;
                }
            }

            String res = isFine ? "Yes" : "No";
            String line = String.format("#%d %s\n", (i + 1), res);
            sb.append(line);
        }

        System.out.print(sb.toString());
    }
}
