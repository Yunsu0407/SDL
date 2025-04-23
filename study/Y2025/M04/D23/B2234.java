package Y2025.M04.D23;

import java.util.*;
import java.io.*;

public class B2234 {
    public static void main(String[] args) throws IOException {
        func();
    }

    public static String input1 = "7 4\n" +
            "11 6 11 6 3 10 6\n" +
            "7 9 6 13 5 15 5\n" +
            "1 10 12 7 13 7 5\n" +
            "13 11 10 8 10 12 13";

    public static final int ROW = 0, COL = 1;

    /*
    1. 방의 개수
    2. 가장 넓은 방의 넓이
    3. 하나의 벽을 제거하여 얻을 수 있는 가장 넓은 방의 크기
     */

    public static void func() throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader(input1));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int orgColSize = Integer.parseInt(st.nextToken());
        int orgRowSize = Integer.parseInt(st.nextToken());
        int mapRowSize = orgRowSize * 2 + 1;
        int mapColSize = orgColSize * 2 + 1;
        int[][] map = new int[mapRowSize][mapColSize]; // empty = 0, wall = 1, room = 2

        for (int i = 0; i < orgRowSize; ++i) {
            st = new StringTokenizer(br.readLine().trim());

            for (int j = 0; j < orgColSize; ++j) {
                int currData = Integer.parseInt(st.nextToken());
                setMap(map, currData, i, j);

            }
        }

        boolean[][] visit = new boolean[mapRowSize][mapColSize];
        int roomCount = 0;
        int maxRoomSize = 0;
        for (int i = 0; i < mapRowSize; ++i) {
            for (int j = 0; j < mapColSize; ++j) {
                if (!visit[i][j] && map[i][j] == 2) { // 방문하지 않은 방이라면
                    ++roomCount;
                    int roomSize = getRoomSize(map, visit, i, j);
                    maxRoomSize = Math.max(maxRoomSize, roomSize);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(roomCount).append("\n");
        sb.append(maxRoomSize).append("\n");
        System.out.println(sb.toString());
    }

    public static int getRoomSize(int[][] map, boolean[][] visit, int row, int col) {
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] dir = {
                {-1, +0, +1, +0},
                {+0, +1, +0, -1}
        }; // 12 3 6 9
        int roomSize = 0;

        visit[row][col] = true;
        queue.add(new int[]{row, col});
        ++roomSize;

        while (!queue.isEmpty()) {
            int[] curr = queue.remove();

            for (int i = 0; i < dir[0].length; ++i) {
                int nextRow = curr[ROW] + dir[ROW][i];
                int nextCol = curr[COL] + dir[COL][i];

                if (map[nextRow][nextCol] != 1) { // 벽이 아니면
                    int nextNextRow = curr[ROW] + dir[ROW][i] * 2;
                    int nextNextCol = curr[COL] + dir[COL][i] * 2;
                    if (nextNextRow < 0 || nextNextRow >= map.length || nextNextCol < 0 || nextNextCol >= map.length) {
                        continue;
                    } // 다음 다음 영역이 배열 범위를 벗어나면 스킵
                    if(!visit[nextNextRow][nextNextCol]){ // 방문하지 않은 곳이면 추가
                        visit[nextNextRow][nextNextCol] = true;
                        queue.add(new int[]{nextNextRow, nextNextCol});
                        ++roomSize;
                    }
                }
            }
        }
        return roomSize;
    }

    /*
    0 1 0 1 0
    1 2 0 2 1
    0 1 0 1 0
    1 2 1 2 1
    0 1 0 1 0

    만약 값이 2라면
      사방이 1이라면
        크기가 1인 방
      하나라도 0이 있으면
        그 방향 옆 방이 2라면
          큐에 넣음
        큐가 비어있지 않은 동안 반복

     */

    // 좌 1, 상 2, 우 4, 하 8
    public static void setMap(int[][] map, int currData, int row, int col) {
        int[][] dir = {
                {+0, -1, +0, +1},
                {-1, +0, +1, +0}
        };
        int[] wall = getWall(currData); // 1 2 4 8

        int mapRow = row * 2 + 1;
        int mapCol = col * 2 + 1;
        map[mapRow][mapCol] = 2;

        for (int i = 0; i < wall.length; ++i) {
            if (wall[i] > 0) {
                int wallRow = mapRow + dir[ROW][i];
                int wallCol = mapCol + dir[COL][i];
                map[wallRow][wallCol] = 1;
            }
        }
    }

    public static int[] getWall(int currData) {
        final int WALL = 4;
        int[] wall = new int[WALL];
        int data = currData;

        for (int i = 0; i < WALL; ++i) {
            wall[i] = data % 2;
            data = data / 2;
        }
        return wall;
    }
}

















