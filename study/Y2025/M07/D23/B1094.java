package study.Y2025.M07.D23;

import java.io.*;

public class B1094 {
    public static void main(String[] args) throws IOException {
        stick();
    }

    public static String input1 = "23"; // 4
    public static String input2 = "32"; // 1
    public static String input3 = "64"; // 1
    public static String input4 = "48"; // 2

    public static void stick() throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader(input4));
        int value = Integer.parseInt(br.readLine().trim());

        int count = 0;
        while (value != 0) {
            if (value % 2 != 0) {
                ++count;
            }
            value = value / 2;
        }

        System.out.println(count);
    }
}
