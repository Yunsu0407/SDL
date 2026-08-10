package Y2026.M08.D10;

import java.util.*;
import java.io.*;

public class S12221 {
    public static void main(String[] args) throws IOException {
        checkNumbers();
    }

    public static void checkNumbers() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < testcase; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            int result = num1 < 10 && num2 < 10 ? num1 * num2 : -1;
            String line = String.format("#%d %d\n", (i + 1), result);
            sb.append(line);
        }

        System.out.print(sb.toString());
    }
}
