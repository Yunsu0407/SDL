package study.Y2025.M07.D24;

import java.util.*;
import java.io.*;

public class B2749 {
    public static void main(String[] args) throws IOException {
        fibonacci3();
    }

    public static String input1 = "1000"; // 228875
    public static String input2 = "17"; // 1597
    public static String input3 = "1000000000000000000"; // 1597

    public static void fibonacci3() throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader(input3));
        final int DIV = 1000000;
        long end = Long.parseLong(br.readLine().trim());
        long first = 0, second = 1;
        long count = 1;

        while(count != end) {
            long temp = second;
            second = (second + first) % DIV;
            first = temp;
            ++count;
        }

        System.out.println(second);
    }
}
