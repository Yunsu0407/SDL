package Y2026.M09.D01;

import java.util.*;
import java.io.*;

public class S2806 {
    public static void main(String[] args) throws IOException {
        nQueen();
    }

    public static void nQueen() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; ++i) {
            n = Integer.parseInt(br.readLine().trim());
            board = new int[n][n];
            count = 0;

            recursiveCall(0);

            String line = String.format("#%d %d\n", (i + 1), count);
            sb.append(line);
        }

        System.out.print(sb.toString());
    }

    public static final int E = 0, Q = 1, B = 2;
    public static int n;
    public static int[][] board;
    public static int count;

    public static void recursiveCall(int r) {
        if (r < n) {
            for (int c = 0; c < n; ++c) {
                if (board[r][c] == E) {
                    int[] emptyPoint = { r, c };

                    List<int[]> blocked = new ArrayList<>();
                    placeQueen(emptyPoint, blocked);
                    blockBoard(emptyPoint, blocked);

                    recursiveCall(r + 1);

                    releaseBlock(blocked);
                }
            }
        } else {
            ++count;
        }
    }

    public static void placeQueen(int[] emptyPoint, List<int[]> blocked) {
        board[emptyPoint[0]][emptyPoint[1]] = Q;
        blocked.add(emptyPoint);
    }

    public static void blockBoard(int[] emptyPoint, List<int[]> blocked) {
        int[] dr = { +1, +1, +1 };
        int[] dc = { +1, +0, -1 };

        for (int i = 0; i < dr.length; ++i) {
            int nr = emptyPoint[0] + dr[i];
            int nc = emptyPoint[1] + dc[i];

            while (!(nr < 0 || nr >= n || nc < 0 || nc >= n)) {
                if (board[nr][nc] == E) {
                    board[nr][nc] = B;
                    blocked.add(new int[] { nr, nc });
                }
                nr = nr + dr[i];
                nc = nc + dc[i];
            }
        }
    }

    public static void releaseBlock(List<int[]> blocked) {
        for (int[] point : blocked) {
            board[point[0]][point[1]] = E;
        }
    }

}
