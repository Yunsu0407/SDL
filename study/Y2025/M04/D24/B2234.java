package study.Y2025.M04.D24;

import java.util.*;
import java.io.*;

public class B2234 {
    public static void main(String[] args) throws IOException {
        checkCastle();
    }

    public static final int ROW = 0, COL = 1;

    public static void checkCastle() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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

        ArrayList<Room> rooms = new ArrayList<>();
        boolean[][] visit = new boolean[mapRowSize][mapColSize];
        int roomCount = 0;
        int maxRoomSize = 0;
        for (int i = 0; i < mapRowSize; ++i) {
            for (int j = 0; j < mapColSize; ++j) {
                if (!visit[i][j] && map[i][j] == 2) { // 방문하지 않은 방이라면
                    ++roomCount; // 방의 개수 증가
                    Room room = getRoomSize(map, visit, i, j); // 방 정보 가져옴
                    maxRoomSize = Math.max(maxRoomSize, room.roomSize); // 최대 방 넓이 갱신
                    rooms.add(room);
                }
            }
        }

        int idealRoomSize = getIdealRoomSize(rooms);

        StringBuilder sb = new StringBuilder();
        sb.append(roomCount).append("\n");
        sb.append(maxRoomSize).append("\n");
        sb.append(idealRoomSize);
        System.out.println(sb.toString());
    }

    public static class Room {
        int roomSize;
        Set<List<Integer>> walls;

        public Room() {
            roomSize = 0;
            walls = new HashSet<>();
        }

        public void addWall(int row, int col) {
            walls.add(Arrays.asList(row, col));
        }
    }

    public static int getIdealRoomSize(ArrayList<Room> rooms) {
        int idealRoomSize = 0;
        while (!rooms.isEmpty()) {
            Room prevRoom = rooms.remove(0);
            Set<List<Integer>> prevWalls = prevRoom.walls;

            for (Room currRoom : rooms) {
                Set<List<Integer>> currWalls = currRoom.walls;
                int roomSize = prevRoom.roomSize;

                for (List<Integer> prevWall : prevWalls) {
                    if (currWalls.contains(prevWall)) {
                        roomSize = roomSize + currRoom.roomSize;
                        idealRoomSize = Math.max(idealRoomSize, roomSize);
                        break;
                    }
                }
            }
        }
        return idealRoomSize;
    }

    public static Room getRoomSize(int[][] map, boolean[][] visit, int row, int col) {
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] dir = {
                {-1, +0, +1, +0},
                {+0, +1, +0, -1}
        }; // 12 3 6 9
        Room room = new Room();

        visit[row][col] = true;
        queue.add(new int[]{row, col});
        ++room.roomSize;

        while (!queue.isEmpty()) {
            int[] curr = queue.remove();

            for (int i = 0; i < dir[0].length; ++i) { // 사방을 확인
                int nextRow = curr[ROW] + dir[ROW][i];
                int nextCol = curr[COL] + dir[COL][i];

                if (map[nextRow][nextCol] != 1) { // 벽이 아니면
                    int nextNextRow = curr[ROW] + dir[ROW][i] * 2;
                    int nextNextCol = curr[COL] + dir[COL][i] * 2;
                    if (nextNextRow < 0 || nextNextRow >= map.length || nextNextCol < 0 || nextNextCol >= map[0].length) {
                        continue;
                    } // 다음 다음 영역이 배열 범위를 벗어나면 스킵
                    if (!visit[nextNextRow][nextNextCol]) { // 방문하지 않은 곳이면 추가
                        visit[nextNextRow][nextNextCol] = true;
                        queue.add(new int[]{nextNextRow, nextNextCol});
                        ++room.roomSize;
                    }
                } else { // 벽이면
                    room.addWall(nextRow, nextCol);
                }
            }
        }
        return room;
    }
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