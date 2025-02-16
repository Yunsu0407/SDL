package Y2025.M02.D14;

import java.util.*;
import java.io.*;

public class B16956 {
    public static void main(String[] args) throws IOException {
        protectSheep();
    }

    public static String input1 = "6 6\n" +
            "..S...\n" +
            "..S.W.\n" +
            ".S....\n" +
            "..W...\n" +
            "...W..\n" +
            "......";

    public static String input2 = "1 2\n" +
            "SW";

    public static String input3 = "5 5\n" +
            ".S...\n" +
            "...S.\n" +
            "S....\n" +
            "...S.\n" +
            ".S...";


    public static void protectSheep() throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader(input3));

        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        final int ROW_SIZE = Integer.parseInt(st.nextToken());
        final int COL_SIZE = Integer.parseInt(st.nextToken());

        String[][] state = new String[ROW_SIZE][COL_SIZE];
        for (int row = 0; row < ROW_SIZE; ++row) {
            String oneLine = br.readLine().trim();
            for (int col = 0; col < COL_SIZE; ++col) {
                state[row][col] = String.valueOf(oneLine.charAt(col));
            }
        }

        final int ROW = 0, COL = 1;
        int[][] dir = { // 12, 3, 6, 9
                {-1, +0, +1, +0},
                {+0, +1, +0, -1}
        };

        int ans = 1;
        for (int row = 0; row < ROW_SIZE; ++row) {
            for (int col = 0; col < COL_SIZE; ++col) {
                if (state[row][col].equals("S")) {
                    for (int i = 0; i < dir[0].length; ++i) {
                        int nextRow = row + dir[ROW][i];
                        int nextCol = col + dir[COL][i];
                        if (nextRow < 0 || nextRow >= ROW_SIZE || nextCol < 0 || nextCol >= COL_SIZE) {
                            continue;
                        }
                        if (state[nextRow][nextCol].equals("W")) {
                            ans = 0;
                        } else {
                            if (state[nextRow][nextCol].equals(".")) {
                                state[nextRow][nextCol] = "D";
                            }
                        }
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(ans).append("\n");
        for (int row = 0; row < ROW_SIZE; ++row) {
            for (int col = 0; col < COL_SIZE; ++col) {
                sb.append(state[row][col]);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
