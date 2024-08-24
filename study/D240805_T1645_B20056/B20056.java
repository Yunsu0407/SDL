package study.D240805_T1645_B20056;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B20056 {
    public static void main(String[] args) throws IOException {
        fireball();
    }

    public static void fireball() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        final int SIZE = Integer.parseInt(st.nextToken());
        final int QUANTITY = Integer.parseInt(st.nextToken());
        final int ORDER = Integer.parseInt(st.nextToken());
        final int DIRECTION = 8;
        final int ROW = 0;
        final int COL = 0;
        int[][] board = new int[SIZE][SIZE];
        int[][] move = {
                {1, 1, 0, -1, -1, -1, 0, 1},
                {0, 1, 1, 1, 0, -1, -1, -1}
        };
        for (int i = 0; i < ORDER; ++i) {
            st = new StringTokenizer(br.readLine().trim());
            int cRow = Integer.parseInt(st.nextToken());
            int cCol = Integer.parseInt(st.nextToken());
            int mass = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());

            int nextRow = (cRow + move[ROW][direction] * speed) % SIZE;
            int nextCol = (cCol + move[direction][COL] * speed) % SIZE;
            board[nextRow][nextCol] = board[nextRow][nextCol] + mass;


        }

        for(int row = 0; row < SIZE; ++row){
            for(int col = 0; col < SIZE; ++col){
                if(board[row][col] >= 2){

                }
            }
        }
    }
    /*
    입력
    N M K
    r c m s d

    N: 판의 크기
    M: 파이어볼 개수
    K: 명령의 개수
    r,c: 위치
    m: 질량
    s: 속력
    d: 방향

    질량: 반올림(질량의 합/5)
    속력: 반올림(속력의 합/파이어볼의 총합)
    7 0 1
    6   2
    5 4 3

    출력
    > 남아있는 파이어볼 질량의 합
     */
}
