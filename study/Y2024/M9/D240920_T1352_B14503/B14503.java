package D240920_T1352_B14503;

import java.io.*;
import java.util.*;

public class B14503 {
    public static void main(String[] args) throws IOException {
        cleanRoom();
    }

    public static int[][] room;
    public static int N;
    public static int M;

    public static void cleanRoom() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        room = new int[N][M];

        st = new StringTokenizer(br.readLine().trim());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int direction = Integer.parseInt(st.nextToken());
        Robot robot = new Robot(row, col, direction);

        for (int r = 0; r < N; ++r) {
            st = new StringTokenizer(br.readLine().trim());
            for (int c = 0; c < M; ++c) {
                room[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();
        robot.cleaning();
        System.out.println(robot.done);
    }

    public static class Robot {
        int row, col, direction;
        int done;
        boolean[][] visited;
        final int ROW = 0;
        final int COL = 1;
        int[] cardinal = {0, 1, 2, 3};    // 북 동 남 서
        int[][] next = {
                {+0, +1, +0, -1},
                {-1, +0, +1, +0}
        };  // 좌 하 우 상

        public Robot(int row, int col, int direction) {
            this.row = row;
            this.col = col;
            this.direction = cardinal[direction];
            done = 0;
            visited = new boolean[N][M];
        }

        public void cleaning() {
            int stop = 0;

            while (true) {
                if (room[row][col] == 0 && !visited[row][col]) {    // 현재 칸이 아직 청소되지 않은 경우
                    visited[row][col] = !visited[row][col]; // 현재 칸을 청소한다.
                    ++done;
                    if (checkNext()) {    // 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
                        continue;
                    } else {    // 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
                        if (moveBack()) {
                            continue;
                        } else {
                            break;
                        }
                    }
                }
            }
        }

        public boolean checkNext() {
            for (int i = 0; i < 4; ++i) {
                int index = (i + direction) % 4;
                int nextRow = row + next[ROW][index];
                int nextCol = col + next[COL][index];
                if (nextRow > -1 && nextRow < N && nextCol > -1 && nextCol < M) {
                    // 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
                    if (room[nextRow][nextCol] == 0 && visited[nextRow][nextCol]) {
                        row = nextRow;
                        col = nextCol;
                        direction = index;
                        return true;
                    }
                }
            }
            return false;
        }

        public boolean moveBack() {
            int index = (direction + 2) % 4;
            int nextRow = row + next[ROW][index];
            int nextCol = col + next[COL][index];
            if ((room[nextRow][nextCol] == 0) && (nextRow > -1 && nextRow < N && nextCol > -1 && nextCol < M)) {
                row = nextRow;
                col = nextCol;
                return true;
            } else {
                return false;
            }
        }
    }
}
