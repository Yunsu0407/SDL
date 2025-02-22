package Y2025.M02.D22;

import java.util.*;
import java.io.*;

public class B1890 {
    public static void main(String[] args) throws IOException {
        jump();
    }

    public static String input1 = "4\n" +
            "2 3 3 1\n" +
            "1 2 1 3\n" +
            "1 2 3 1\n" +
            "3 1 1 0";

    public static void jump() throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader(input1));

        final int SIZE = Integer.parseInt(br.readLine().trim());
        int[][] board = new int[SIZE][SIZE];

        for (int row = 0; row < SIZE; ++row) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            for (int col = 0; col < SIZE; ++col) {
                board[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        long[][] count = new long[SIZE][SIZE];
        count[0][0] = 1;

        for (int row = 0; row < SIZE; ++row) {
            for (int col = 0; col < SIZE; ++col) {
                if (count[row][col] > 0) {
                    int jump = board[row][col];
                    if (jump == 0) {
                        continue;
                    }
                    int nextRow = row + jump;
                    int nextCol = col + jump;

                    if (!(nextCol < 0 || nextCol >= SIZE)) {
                        count[row][nextCol] = count[row][nextCol] + count[row][col];
                    }

                    if (!(nextRow < 0 || nextRow >= SIZE)) {
                        count[nextRow][col] = count[nextRow][col] + count[row][col];
                    }

                }
            }
        }

        System.out.println(count[SIZE - 1][SIZE - 1]);
    }
}
