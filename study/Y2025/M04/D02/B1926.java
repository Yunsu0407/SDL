package Y2025.M04.D02;

import java.util.*;
import java.io.*;

public class B1926 {
    public static void main(String[] args) throws IOException {
        countPaint();
    }

    public static void countPaint() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int rowSize = Integer.parseInt(st.nextToken());
        int colSize = Integer.parseInt(st.nextToken());
        int[][] paper = new int[rowSize][colSize];
        boolean[][] visited = new boolean[rowSize][colSize];
        int count = 0;
        int maxArea = 0;

        for (int i = 0; i < rowSize; ++i) {
            st = new StringTokenizer(br.readLine().trim());
            for (int j = 0; j < colSize; ++j) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < rowSize; ++i) {
            for (int j = 0; j < colSize; ++j) {
                if (paper[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;

                    int area = findNear(paper, visited, i, j, rowSize, colSize);
                    maxArea = Math.max(maxArea, area);

                    ++count;
                }
            }
        }

        System.out.println(count);
        System.out.println(maxArea);
    }

    public static int findNear(int[][] paper, boolean[][] visited, int row, int col, int rowSize, int colSize) {
        final int ROW = 0, COL = 1;
        int[][] dir = {
                {-1, +0, +1, +0},
                {+0, +1, +0, -1}
        };

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{row, col});
        int area = 1;

        while (!queue.isEmpty()) {
            int[] curr = queue.remove();

            for (int i = 0; i < dir[0].length; ++i) {
                int nextRow = curr[ROW] + dir[ROW][i];
                int nextCol = curr[COL] + dir[COL][i];

                if (nextRow < 0 || nextRow >= rowSize || nextCol < 0 || nextCol >= colSize) {
                    continue;
                } else {
                    if (paper[nextRow][nextCol] == 1 && !visited[nextRow][nextCol]) {
                        visited[nextRow][nextCol] = true;

                        queue.add(new int[]{nextRow, nextCol});
                        ++area;
                    }
                }
            }
        }

        return area;
    }
}
