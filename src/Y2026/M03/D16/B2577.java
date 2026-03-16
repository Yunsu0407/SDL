package Y2026.M03.D16;

import java.util.*;
import java.io.*;

public class B2577 {
    public static void main(String[] args) throws IOException {
        countDigit();
    }

    public static String input1 = "150\r\n" + //
            "266\r\n" + //
            "427";

    public static void countDigit() throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader(input1));
        int num1 = Integer.parseInt(br.readLine().trim());
        int num2 = Integer.parseInt(br.readLine().trim());
        int num3 = Integer.parseInt(br.readLine().trim());
        int res = num1 * num2 * num3;

        int[] count = new int[10]; // 1 ~ 9

        while (res > 0) {
            int digit = res % 10;
            count[digit] = count[digit] + 1;
            res = res / 10;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count.length; ++i) {
            sb.append(count[i]).append("\n");
        }

        System.out.println(sb.toString());
    }
}
