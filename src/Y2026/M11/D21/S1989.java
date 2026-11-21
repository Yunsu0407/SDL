package Y2026.M11.D21;

import java.io.*;

public class S1989 {
    public static void main(String[] args) throws IOException {
        checkPalindrome();
    }

    public static String input1 = "3\r\n" + //
            "level     \r\n" + //
            "samsung\r\n" + //
            "eye";

    public static void checkPalindrome() throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader(input1));
        int tc = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < tc; ++i) {
            String str = br.readLine().trim();
            int len = str.length();
            int limit = len / 2;
            boolean isPalin = true;

            for (int j = 0; j < limit; ++j) {
                char front = str.charAt(j);
                char rear = str.charAt(len - (j + 1));

                if (front != rear) {
                    isPalin = false;
                }
            }

            int res = isPalin ? 1 : 0;
            String line = String.format("#%d %d\n", (i + 1), res);
            sb.append(line);
        }

        System.out.print(sb.toString());
    }
}
