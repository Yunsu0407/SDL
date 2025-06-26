package study.Y2025.M06.D18;

import java.util.*;
import java.io.*;

public class B7562_2 {
    public static void main(String[] args) throws IOException {
        KnightMove();
    }

    public static String input1 = "3\n" +
            "8\n" +
            "0 0\n" +
            "7 0\n" +
            "100\n" +
            "0 0\n" +
            "30 50\n" +
            "10\n" +
            "1 1\n" +
            "1 1";

    public static void KnightMove() throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader(input1));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
        int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};

        for (int i = 0; i < testcase; ++i) {
            int size = Integer.parseInt(br.readLine().trim());
            boolean[][] board = new boolean[size][size];
            int R = 0, C = 1, CNT = 2;

            int[] src = new int[2];
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            src[R] = Integer.parseInt(st.nextToken());
            src[C] = Integer.parseInt(st.nextToken());

            int[] dst = new int[2];
            st = new StringTokenizer(br.readLine().trim());
            dst[R] = Integer.parseInt(st.nextToken());
            dst[C] = Integer.parseInt(st.nextToken());

            if (src[R] == dst[R] && src[C] == dst[C]) {
                sb.append("0\n");
                continue;
            }

            Queue<int[]> queue = new ArrayDeque<>();
            queue.add(new int[]{src[R], src[C], 0});
            board[src[R]][src[C]] = true;
            int min = Integer.MAX_VALUE;

            while (!queue.isEmpty()) {
                int[] curr = queue.poll();

                for (int j = 0; j < dx.length; ++j) {
                    int nextRow = curr[R] + dx[j];
                    int nextCol = curr[C] + dy[j];

                    if (nextRow < 0 || nextRow >= size || nextCol < 0 || nextCol >= size) {
                        continue;
                    }

                    if (nextRow == dst[R] && nextCol == dst[C]) {
                        min = Math.min(min, curr[CNT] + 1);
                        continue;
                    }

                    if (!board[nextRow][nextCol]) {
                        queue.add(new int[]{nextRow, nextCol, curr[CNT] + 1});
                        board[nextRow][nextCol] = true;
                    }
                }
            }

            sb.append(min).append("\n");
        }

        System.out.print(sb.toString());
    }
}
