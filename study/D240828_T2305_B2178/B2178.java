package D240828_T2305_B2178;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class B2178 {
    public static void main(String[] args) throws IOException {
        getMinWay();
    }

    public static void getMinWay() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        int[][] board = new int[N][M];

        for (int r = 0; r < N; ++r) {
            String values = br.readLine().trim();
            for (int c = 0; c < M; ++c) {
                board[r][c] = values.charAt(c) - '0';
            }
        }   // 보드 설정 완료
        br.close();

        Queue<Ordinate> queue = new LinkedList<>();
        int row = 0;
        int col = 0;
        int count = 1;
        boolean[][] isVisited = new boolean[N][M];
        isVisited[row][col] = true;
        queue.add(new Ordinate(row, col, count, isVisited));
        final int ROW = 0;
        final int COL = 1;
        int[][] direction = {
                {-1, +0, +1, +0},
                {+0, +1, +0, -1}
        };
        while (!queue.isEmpty()) {
            Ordinate curr = queue.remove();
            row = curr.getRow();
            col = curr.getCol();
            count = curr.getCount();
            if (row == N - 1 && col == M - 1) {
                break;
            }
            for (int i = 0; i < 4; ++i) {
                try {
                    int currRow = row + direction[ROW][i];
                    int currCol = col + direction[COL][i];
                    int check = board[currRow][currCol];
                    boolean notVisited = !curr.checkVisited(currRow, currCol);
                    if (check == 1 && notVisited) {
                        boolean[][] newIsVisited = curr.getIsVisited();
                        newIsVisited[currRow][currCol] = true;
                        queue.add(new Ordinate(currRow, currCol, count + 1, newIsVisited));
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                }
            }
        }

        System.out.print(count);
    }

    public static class Ordinate {
        private int row, col, count;
        private boolean[][] isVisited;

        public Ordinate(int row, int col, int count, boolean[][] isVisited) {
            this.row = row;
            this.col = col;
            this.count = count;
            this.isVisited = isVisited;
        }

        public int getRow() {
            return this.row;
        }

        public int getCol() {
            return this.col;
        }

        public int getCount() {
            return this.count;
        }

        public boolean[][] getIsVisited() {
            return this.isVisited;
        }

        public boolean checkVisited(int cRow, int cCol) {
            return this.isVisited[cRow][cCol];
        }
    }
}
