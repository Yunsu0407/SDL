package D240830_T2352_B20058;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B20058 {
    public static void main(String[] args) throws IOException {
        useFireStorm();
    }

    public static void useFireStorm() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        final int N = Integer.parseInt(st.nextToken());
        final int Q = Integer.parseInt(st.nextToken());
        final int SIZE = (int) Math.pow(2, N);
        int[][] board = new int[SIZE][SIZE];
        int[] limit = new int[Q];

        for (int r = 0; r < SIZE; ++r) {
            st = new StringTokenizer(br.readLine().trim());
            for (int c = 0; c < SIZE; ++c) {
                board[r][c] = Integer.parseInt(st.nextToken());
            }
        }   // 판 수령 완료

        st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < Q; ++i) {
            limit[i] = Integer.parseInt(st.nextToken());
        }   // 명령 수령 완료

        for (int i = 0; i < Q; ++i) {
            rotateBoard(board, SIZE, limit[i]);
        }

        prnBoard(board, SIZE);
    }

    public static void rotateBoard(int[][] board, int SIZE, int L) {
        int limit = (int) Math.pow(2, L);   // L = 1, limit = 2
        if (L == 0) {
            // diminish
        } else if (L == 1) {
            for (int r = 0; r < SIZE / limit; ++r) {
                int row = 2 * r;
                for (int c = 0; c < SIZE / limit; ++c) {
                    int col = 2 * c;
                    int temp = board[row][col];
                    board[row][col] = board[row + 1][col];
                    board[row + 1][col] = board[row + 1][col + 1];
                    board[row + 1][col + 1] = board[row][col + 1];
                    board[row][col + 1] = temp;
                }
            }
        } else {
            int[][] temp = new int[L][L];
            int row = 0;
            int col = 0;
            temp[row][col] = board[row][col];
            temp[row][col + 1] = board[row][col + 1];
            temp[row][col + 2] = board[row][col + 2];
            temp[row + 1][col] = board[row + 1][col];
            temp[row + 1][col + 1] = board[row + 1][col + 1];
            temp[row + 1][col + 2] = board[row + 1][col + 2];
            temp[row + 2][col] = board[row + 2][col];
            temp[row + 2][col + 1] = board[row + 2][col + 1];
            temp[row + 2][col + 2] = board[row + 2][col + 2];

            int STH = 1;

            for (int r = 0; r < L; ++r) {
                row = r * STH;
                for (int c = 0; c < L; ++c) {
                    col = c * STH;
                    temp[r][c] = board[row][col];
                }
            }

        }
    }

    public static void prnBoard(int[][] board, int SIZE) {
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < SIZE; ++r) {
            for (int c = 0; c < SIZE; ++c) {
                sb.append(String.format("%d ", board[r][c]));
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
