package Y2026.M03.D22;

import java.util.*;
import java.io.*;

public class B2775 {
    public static void main(String[] args) throws IOException {
        accCount();
    }

    public static String input1 = "2\r\n" + //
            "1\r\n" + //
            "3\r\n" + //
            "2\r\n" + //
            "3";

    public static void accCount() throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader(input1));
        int testcase = Integer.parseInt(br.readLine().trim());

        int[][] acc = new int[15][14];
        for (int col = 0; col < acc[0].length; ++col) {
            acc[0][col] = col + 1;
        }

        for (int row = 1; row < acc.length; ++row) {
            for (int col = 0; col < acc[0].length; ++col) {
                if (col == 0) {
                    acc[row][col] = 1;
                } else {
                    acc[row][col] = acc[row][col - 1] + acc[row - 1][col];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < testcase; ++i) {
            int row = Integer.parseInt(br.readLine().trim());
            int col = Integer.parseInt(br.readLine().trim());
            sb.append(acc[row][col - 1]).append("\n");
        }

        System.out.println(sb.toString());
    }
}
