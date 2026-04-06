package Y2026.M04.D06;

import java.util.*;
import java.io.*;

public class B9012 {
    public static void main(String[] args) throws IOException {
        bracket();
    }

    public static void bracket() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tc; ++i) {
            String line = br.readLine().trim();

            int cnt = 0;
            for (int j = 0; j < line.length(); ++j) {
                char c = line.charAt(j);
                if (c == '(') {
                    cnt = cnt + 1;
                } else {
                    cnt = cnt - 1;
                }

                if (cnt < 0) {
                    break;
                }
            }

            String res;
            if (cnt == 0) {
                res = "YES\n";
            } else {
                res = "NO\n";
            }
            sb.append(res);
        }

        System.out.println(sb.toString());
    }
}
