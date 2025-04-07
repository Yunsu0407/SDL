package study.Y2025.M04.D06;

import java.util.*;
import java.io.*;

public class B1012 {
    public static void main(String[] args) throws IOException {
        countSegment();
    }

    public static final int ROW = 0, COL = 1;

    public static void countSegment() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int rowSize = Integer.parseInt(st.nextToken());
            int colSize = Integer.parseInt(st.nextToken());
            int cabbage = Integer.parseInt(st.nextToken());
            boolean[][] farm = new boolean[rowSize][colSize];

            for (int j = 0; j < cabbage; ++j) {
                st = new StringTokenizer(br.readLine().trim());
                int row = Integer.parseInt(st.nextToken());
                int col = Integer.parseInt(st.nextToken());
                farm[row][col] = true;
            }

            Queue<int[]> queue = new ArrayDeque<>();
            boolean[][] visit = new boolean[rowSize][colSize];
            int[][] dir = { // 상하좌우
                    {-1, +0, +1, +0},
                    {+0, +1, +0, -1}
            };
            int count = 0;
            for (int j = 0; j < rowSize; ++j) {
                for (int k = 0; k < colSize; ++k) {
                    if (farm[j][k] && !visit[j][k]) {
                        ++count;
                        queue.add(new int[]{j, k});
                        while (!queue.isEmpty()) {
                            int[] curr = queue.remove();

                            for (int x = 0; x < dir[0].length; ++x) {
                                int nextRow = curr[ROW] + dir[ROW][x];
                                int nextCol = curr[COL] + dir[COL][x];
                                if (nextRow < 0 || nextRow >= rowSize || nextCol < 0 || nextCol >= colSize) {
                                    continue;
                                }
                                if (farm[nextRow][nextCol] && !visit[nextRow][nextCol]) {
                                    visit[nextRow][nextCol] = true;
                                    queue.add(new int[]{nextRow, nextCol});
                                }
                            }
                        }
                    }
                }
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb.toString());
    }
}
