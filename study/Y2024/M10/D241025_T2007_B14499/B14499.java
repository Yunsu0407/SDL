package D241025_T2007_B14499;

import java.io.*;
import java.util.*;

public class B14499 {
    public static void main(String[] args) throws IOException {
        rollDice();
    }

    public static void rollDice() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        final int N = Integer.parseInt(st.nextToken()); // 행
        final int M = Integer.parseInt(st.nextToken()); // 열
        final int X = Integer.parseInt(st.nextToken()); // x 좌표
        final int Y = Integer.parseInt(st.nextToken()); // y 좌표
        final int K = Integer.parseInt(st.nextToken()); // 명령의 개수

        int[][] map = new int[N][M];
        for (int r = 0; r < N; ++r) {
            st = new StringTokenizer(br.readLine().trim());
            for (int c = 0; c < M; ++c) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }   // 지도 설정

        int[] order = new int[K];
        st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < K; ++i) {
            order[i] = Integer.parseInt(st.nextToken()) - 1;
        }   // 명령어 설정

        StringBuilder sb = new StringBuilder();
        int[] dice = new int[6];
        int row = 0, col = 1, x = X, y = Y;
        int[][] move = { //동서북남
                {+0, +0, -1, +1},   // row
                {+1, -1, +0, +0}    // col
        };
        for (int i = 0; i < K; ++i) {
            int dir = order[i];
            x = x + move[row][dir];
            y = y + move[col][dir];
            // 다음 좌표 계산
            if (x < 0 || x >= N || y < 0 || y >= M) {   // 범위를 벗어난 경우
                x = x - move[row][dir];
                y = y - move[col][dir];
                continue;   // 원상복구하고 단계 건너뛰기
            }

            switch (dir) {
                case 0:
                    east(dice);
                    break;
                case 1:
                    west(dice);
                    break;
                case 2:
                    north(dice);
                    break;
                case 3:
                    south(dice);
                    break;
            }   // 주사위 이동

            int mapValue = map[x][y];
            if (mapValue == 0) {  // 현재 주사위가 위치한 지도의 값이 0인 경우
                map[x][y] = dice[1]; // 주사위 밑을 지도에 업데이트한다.
            } else {    // 현재 주사위가 위치한 지도의 값이 0이 아닌 경우
                dice[1] = map[x][y];
                map[x][y] = 0;
            }

            sb.append(dice[3]).append("\n");
        }
        System.out.println(sb.toString());
    }

    // 동서북남
    public static void east(int[] dice) {
        int[] copy = dice;
        dice[1] = copy[5];
        dice[3] = copy[4];
        dice[4] = copy[1];
        dice[5] = copy[3];
    }

    public static void west(int[] dice) {
        int[] copy = dice;
        dice[1] = copy[4];
        dice[3] = copy[5];
        dice[4] = copy[3];
        dice[5] = copy[1];
    }

    public static void north(int[] dice) {
        int[] copy = dice;
        dice[0] = copy[3];
        dice[1] = copy[0];
        dice[2] = copy[1];
        dice[3] = copy[2];
    }

    public static void south(int[] dice) {
        int[] copy = dice;
        dice[0] = copy[1];
        dice[1] = copy[2];
        dice[2] = copy[3];
        dice[3] = copy[0];
    }
}
