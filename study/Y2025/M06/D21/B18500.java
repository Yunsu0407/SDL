package study.Y2025.M06.D21;

import java.util.*;
import java.io.*;

public class B18500 {
    public static void main(String[] args) throws IOException {
        mineral2();
    }

    public static String input1 = "5 6\n" +
            "......\n" +
            "..xx..\n" +
            "..x...\n" +
            "..xx..\n" +
            ".xxxx.\n" +
            "1\n" +
            "3";

    public static void mineral2() throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader(input1));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int rowSize = Integer.parseInt(st.nextToken());
        int colSize = Integer.parseInt(st.nextToken());
        boolean[][] cave = new boolean[rowSize][colSize];

        for (int r = 0; r < rowSize; ++r) {
            String str = br.readLine().trim();
            for (int c = 0; c < colSize; ++c) {
                char curr = str.charAt(c);
                if (c == '.') {
                    cave[r][c] = false;
                } else { // == 'x'
                    cave[r][c] = true;
                }
            }
        }

        int spear = Integer.parseInt(br.readLine().trim());
        boolean isLeft = true;
        for (int i = 0; i < spear; ++i) {
            int r = rowSize - Integer.parseInt(st.nextToken());
            int colStart, colEnd, dc;

            if (isLeft) {
                colStart = 0;
                colEnd = colSize;
                dc = 1;
            } else {
                colStart = colSize - 1;
                colEnd = -1;
                dc = -1;
            }

            for (int c = colStart; c != colEnd; c = c + dc) {
                if(cave[r][c]) {
                    cave[r][c] = !cave[r][c];
                    break;
                }
            }

            handleCave(cave);
        }
    }

    public static void handleCave(boolean[][] cave) {
        int rowSize = cave.length;
        int colSize = cave[0].length;

    }
}
