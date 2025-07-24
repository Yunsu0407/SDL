package study.Y2025.M07.D23;

import java.io.*;

public class B10610 {
    public static void main(String[] args) throws IOException {
        multiple30();
    }

    public static String input1 = "102"; // 210
    public static String input2 = "2931"; // -1
    public static String input3 = "80875542"; // 88755420

    public static void multiple30() throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader(input3));
        String str = br.readLine().trim();

        int[] digit = new int[10];
        int sum = 0;
        for (int i = 0; i < str.length(); ++i) {
            int value = str.charAt(i) - '0';
            sum = sum + value;
            ++digit[value];
        }

        StringBuilder sb = new StringBuilder();
        if (sum % 3 != 0 || digit[0] == 0) {
            sb.append("-1");
        } else {
            for (int i = digit.length - 1; i >= 0; --i) {
                for (int j = 0; j < digit[i]; ++j) {
                    sb.append(i);
                }
            }
        }

        System.out.println(sb.toString());
    }
}
