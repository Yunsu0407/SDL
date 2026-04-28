package Y2026.M04.D28;

import java.util.*;
import java.io.*;

public class S21425 {
    public static void main(String[] args) throws IOException {
        overN();
    }

    public static void overN() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tc; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            int cnt = 1;
            while (a + b <= n) {
                if (a >= b) {
                    b = a + b;
                } else {
                    a = a + b;
                }
                cnt = cnt + 1;
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb.toString());
    }
}
