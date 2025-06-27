package study.Y2025.M06.D27;

import java.util.*;
import java.io.*;

public class B14890 {
    public static void main(String[] args) throws IOException {
        slope();
    }

    public static String input1 = "6 2\n" +
            "3 3 3 3 3 3\n" +
            "2 3 3 3 3 3\n" +
            "2 2 2 3 2 3\n" +
            "1 1 1 2 2 2\n" +
            "1 1 1 3 3 1\n" +
            "1 1 2 3 3 2"; // 3

    public static void slope() throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader(input1));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int size = Integer.parseInt(st.nextToken());
        int limit = Integer.parseInt(st.nextToken());
        int[][] map = new int[size][size];

        for (int r = 0; r < size; ++r) {
            st = new StringTokenizer(br.readLine().trim());
            for (int c = 0; c < size; ++c) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        for (int i = 0; i < size; ++i) {
            if (checkLine(map, i, limit, true)) {
                ++count;
            }
            if (checkLine(map, i, limit, false)) {
                ++count;
            }
        }

        System.out.println(count);
    }

    public static boolean checkLine(int[][] map, int value, int limit, boolean isRow) {
        boolean possible = true;
        int size = map.length;
        int base = value;
        int[] acc = new int[size];
        int dr = isRow ? 0 : 1;
        int dc = isRow ? 1 : 0;
        int pRow, cRow, nRow, pCol, cCol, nCol, pVal, cVal, nVal;

        for (int vary = 0; vary < size; ++vary) {
            cRow = isRow ? base : vary;
            cCol = isRow ? vary : base;
            cVal = map[cRow][cCol];

            pRow = cRow - dr;
            pCol = cCol - dc;
            if (pRow >= 0 && pCol >= 0) {
                pVal = map[pRow][pCol];
                if(pVal == cVal) {
                    for(int i = 1; i <= limit; ++i) {

                    }
                }
            }


        }


        return possible;
    }
}
