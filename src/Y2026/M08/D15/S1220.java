package Y2026.M08.D15;

import java.util.*;
import java.io.*;

public class S1220 {
    public static void main(String[] args) throws IOException {
        magneticProcess();
    }

    public static final int R = 0, C = 1;
    public static final int E = 0, N = 1, S = 2;

    public static void magneticProcess() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = 1;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; ++i) {
            int side = Integer.parseInt(br.readLine().trim());
            int[][] table = new int[side][side];

            Queue<int[]> posQueue = new ArrayDeque<>();
            for (int r = 0; r < side; ++r) {
                StringTokenizer st = new StringTokenizer(br.readLine().trim());
                for (int c = 0; c < side; ++c) {
                    int state = Integer.parseInt(st.nextToken());
                    table[r][c] = state;
                    if (state != E) {
                        posQueue.add(new int[] { r, c });
                    }
                }
            }

            int deadlock = 0;
            int[] dr = { 0, +1, -1 };
            while (!posQueue.isEmpty()) {
                int[] currPos = posQueue.remove();
                int currRow = currPos[R]; // curr row
                int currCol = currPos[C]; // curr col
                int currProp = table[currRow][currCol];

                int nextRow = currRow + dr[currProp];
                int nextCol = currCol;
                int[] nextPos = new int[] { nextRow, nextCol };

                if (nextRow < 0 || nextRow >= side) { // 자성체 탈출
                    table[currRow][currCol] = E; // 테이블에서 자성체 지우고 다음 루프로 이동
                    continue;
                }

                int nextState = table[nextRow][nextCol];

                if (nextState == E) { // 다음 공간이 비어있는 경우
                    table[currRow][currCol] = E; // 현재 위치의 자성체를 지우고
                    table[nextRow][nextCol] = currProp; // 다음 위치에 자성체를 이동시키고
                    posQueue.add(nextPos);
                } else if (nextState == currProp) {
                    // posQueue.add(currPos);
                } else { // nextState != currProp
                    ++deadlock;
                }
            }
            deadlock = deadlock / 2;

            String line = String.format("#%d %d\n", (i + 1), deadlock);
            sb.append(line);
        }

        System.out.print(sb.toString());
    }
}