package study.Y2025.M05.D31;

import java.util.*;
import java.io.*;

public class B2665 {
    public static void main(String[] args) throws IOException {
        makeMaze();
    }

    public static void makeMaze() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine().trim());
        boolean[][] maze = new boolean[size][size];

        for (int row = 0; row < size; ++row) {
            String rowInfo = br.readLine().trim();
            for (int col = 0; col < size; ++col) {
                int curr = rowInfo.charAt(col) - '0';
                if (curr == 1) { // 흰방
                    maze[row][col] = true;
                }
            }
        }

        int ans = checkMaze(maze);

        System.out.println(ans);
    }

    public static int checkMaze(boolean[][] maze) {
        int[][] cnt = new int[maze.length][maze.length];
        for (int[] row : cnt) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        cnt[0][0] = 0;

        final int ROW = 0, COL = 1;
        int[][] dir = {
                {-1, +0, +1, +0},
                {+0, +1, +0, -1}
        }; // 0, 3, 6, 9

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] curr = queue.remove();

            for (int i = 0; i < dir[0].length; ++i) {
                int nxtRow = curr[ROW] + dir[ROW][i];
                int nxtCol = curr[COL] + dir[COL][i];

                if (nxtRow < 0 || nxtRow >= maze.length || nxtCol < 0 || nxtCol >= maze.length) {
                    continue;
                }

                int nxtCnt = cnt[curr[ROW]][curr[COL]];
                if (!maze[nxtRow][nxtCol]) { // 다음이 벽인 경우
                    nxtCnt = nxtCnt + 1;
                }

                int baseCnt = cnt[nxtRow][nxtCol];
                if (nxtCnt < baseCnt) {
                    cnt[nxtRow][nxtCol] = nxtCnt;
                    queue.add(new int[]{nxtRow, nxtCol});
                }
            }
        }

        return cnt[cnt.length - 1][cnt.length - 1];
    }
}
