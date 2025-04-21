package study.Y2025.M04.D19;

import java.util.*;
import java.io.*;

public class B2234 {
    public static void main(String[] args) throws IOException {
        checkCastleState();
    }

    public static int ROW = 0, COL = 1;
    public static String input1 = "";

    public static void checkCastleState() throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader(input1));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int roomRow = Integer.parseInt(st.nextToken());
        int roomCol = Integer.parseInt(st.nextToken());
        int virRow = roomRow * 2 + 1;
        int virCol = roomCol * 2 + 1;
        int[][] virSpace = new int[virRow][virCol];

        for (int i = 0; i < roomRow; ++i) {
            st = new StringTokenizer(br.readLine().trim());
            for (int j = 0; j < roomCol; ++j) {
                int roomState = Integer.parseInt(st.nextToken());
                int[] wall = getWall(roomState); // 하 우 상 좌
                setEnv(virSpace, new int[]{i, j}, wall);
            }
        }
    }

    public static void setEnv(int[][] virSpace, int[] room, int[] wall) { // 0 = none, 1 = wall, 2 = room
        int virRow = room[ROW] * 2 + 1;
        int virCol = room[COL] * 2 + 1;
        virSpace[virRow][virCol] = 1;

        int[][] dir = {
                {+1, +0, -1, +0},
                {+0, +1, +0, -1}
        }; // 하 우 상 좌
        for(int i = 0; i < wall.length; ++i) {
            
        }
    }

    public static int[] getWall(int roomState) { // 하 우 상 좌
        int[] wall = new int[4];
        int state = roomState;
        int i = 0;
        while (state > 0) {
            int val = state % 2;
            wall[i] = val;
            state = state / 2;
            ++i;
        }
        return wall;
    }
}
