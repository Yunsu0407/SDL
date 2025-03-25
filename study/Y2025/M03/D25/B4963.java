package study.Y2025.M03.D25;

import java.util.*;
import java.io.*;

public class B4963 {
    public static void main(String[] args) throws IOException {
        countIsland();
    }

    public static int[][] dir = {
            {-1, -1, +0, +1, +1, +1, +0, -1},
            {+0, +1, +1, +1, +0, -1, -1, -1}
    };
    public static final int R = 0, C = 1, STATE = 0, VISIT = 1;

    public static void countIsland() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int colSize = Integer.parseInt(st.nextToken());
            int rowSize = Integer.parseInt(st.nextToken());
            if (rowSize == colSize && rowSize == 0) {
                break;
            }

            boolean[][][] location = new boolean[rowSize][colSize][2];

            for (int i = 0; i < rowSize; ++i) {
                st = new StringTokenizer(br.readLine().trim());
                for (int j = 0; j < colSize; ++j) {
                    if (st.nextToken().equals("1")) {
                        location[i][j][STATE] = true;
                    }
                }
            }

            int count = 0;
            for (int i = 0; i < rowSize; ++i) {
                for (int j = 0; j < colSize; ++j) {
                    if (location[i][j][STATE] && !location[i][j][VISIT]) {
                        ++count;
                        Queue<int[]> queue = new ArrayDeque<>();
                        queue.add(new int[]{i, j});

                        while (!queue.isEmpty()) {
                            int[] curr = queue.remove();
                            location[curr[R]][curr[C]][VISIT] = true;

                            for (int k = 0; k < dir[0].length; ++k) {
                                int nextRow = curr[R] + dir[R][k];
                                int nextCol = curr[C] + dir[C][k];
                                if (nextRow < 0 || nextRow >= rowSize || nextCol < 0 || nextCol >= colSize) {
                                    continue;
                                } else {
                                    if (location[nextRow][nextCol][STATE] && !location[nextRow][nextCol][VISIT]) {
                                        queue.add(new int[]{nextRow, nextCol});
                                    }
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
