package Y2025.M08.D08;

import java.util.*;
import java.io.*;

public class B1748 {
    public static void main(String[] args) throws IOException {
        wrightNumber();
    }

    public static String input1 = "5"; // 5
    public static String input2 = "15"; // 21
    public static String input3 = "120"; // 252
    public static String input4 = "100000000";

    // 15 = 9 * 1 + 6
    // 120 = 9 * 10 + 9 * 1 + 21, 180 + 9 + 63 = 252
    // 120 - 9 = 111, 111 - 90 = 21, 21 - 999 = 음수

    public static void wrightNumber() throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader(input3));
        int target = Integer.parseInt(br.readLine().trim());
        long len = 0;
        long cycle = 0;
        final int NINE = 9;

        while (true) {
            int sub = NINE * (int) Math.pow(10, cycle);
            int rest = target - sub;

            ++cycle;

            if (rest > 0) {
                len = len + sub * cycle;
                target = rest;
            } else {
                len = len + target * cycle;
                break;
            }
        }

        System.out.println(len);
    }
}
