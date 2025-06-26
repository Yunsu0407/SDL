package study.Y2025.M06.D18;

import java.util.*;
import java.io.*;

public class B7562 {
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

    public static class Index {
        int row;
        int col;
        int count;

        public Index(String str) {
            StringTokenizer st = new StringTokenizer(str);
            row = Integer.parseInt(st.nextToken());
            col = Integer.parseInt(st.nextToken());
            this.count = 0;
        }

        public Index(String str, int count) {
            this(str);
            this.count = count;
        }

        public boolean isSame(Index other) {
            return this.row == other.row && this.col == other.col;
        }
    }

    public static void KnightMove() throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader(input1));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
        int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};

        for (int i = 0; i < testcase; ++i) {
            int size = Integer.parseInt(br.readLine().trim());
            int[][] board = new int[size][size];
            Index src = new Index(br.readLine().trim());
            Index dst = new Index(br.readLine().trim());

            if (src.isSame(dst)) {
                sb.append("0\n");
                continue;
            }

            for (int j = 0; j < size; ++j) {
                Arrays.fill(board[j], Integer.MAX_VALUE);
            }

            Queue<Index> queue = new ArrayDeque<>();
            queue.add(src);

            while (!queue.isEmpty()) {
                Index curr = queue.poll();

                for (int j = 0; j < dx.length; ++j) {
                    int nextRow = curr.row + dx[j];
                    int nextCol = curr.col + dy[j];
                    if (nextRow < 0 | nextRow >= size || nextCol < 0 || nextCol >= size) {
                        continue;
                    }

                    int nextCount = curr.count + 1;
                    int limitCount = board[dst.row][dst.col];
                    if (nextCount < board[nextRow][nextCol] && nextCount < limitCount) {
                        board[nextRow][nextCol] = nextCount;
                        String str = String.format("%d %d", nextRow, nextCol);
                        Index next = new Index(str, nextCount);

                        if (!next.isSame(dst)) {
                            queue.add(next);
                        }
                    }
                }
            }

            sb.append(board[dst.row][dst.col]).append("\n");
        }

        System.out.print(sb.toString());
    }
}
