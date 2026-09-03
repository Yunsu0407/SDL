package Y2026.M09.D03;

import java.util.*;
import java.io.*;

public class S246969 {
    public static void main(String[] args) throws IOException {
        sliceRect();
    }

    public static void sliceRect() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int n = a * b * c - 1;

            String res = n % 2 == 0 ? "2" : "1";
            sb.append(res).append("\n");
        }

        System.out.print(sb.toString());
    }
}
