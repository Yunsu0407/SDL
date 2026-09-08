package Y2026.M09.D08;

import java.util.*;
import java.io.*;

public class S10032 {
    public static void main(String[] args) throws IOException {
        divideSnack();
    }

    public static void divideSnack() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int snack = Integer.parseInt(st.nextToken());
            int people = Integer.parseInt(st.nextToken());

            int res = snack % people == 0 ? 0 : 1;

            String line = String.format("#%d %d\n", (i + 1), res);
            sb.append(line);
        }

        System.out.print(sb.toString());
    }
}
