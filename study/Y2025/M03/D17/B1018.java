package study.Y2025.M03.D17;

import java.util.*;
import java.io.*;

/*
MxN 체스판, 임의의 부분들이 검정색과 흰색으로 칠해져있다.
MxN 보드를 잘라 8x8 체스판을 만들 때, 최소한 색칠해야 하는 정사각형의 개수를 구하여라.

N과 M은 8 이상 50 이하인 자연수이다.

50 * 50
8 * 8 * 2
 */

public class B1018 {
    public static void main(String[] args) throws IOException {
        paintChessBoard();
    }

    public static String input1 = "8 8\n" +
            "WBWBWBWB\n" +
            "BWBWBWBW\n" +
            "WBWBWBWB\n" +
            "BWBBBWBW\n" +
            "WBWBWBWB\n" +
            "BWBWBWBW\n" +
            "WBWBWBWB\n" +
            "BWBWBWBW"; // ans = 1

    public static String input2 = "10 13\n" +
            "BBBBBBBBWBWBW\n" +
            "BBBBBBBBBWBWB\n" +
            "BBBBBBBBWBWBW\n" +
            "BBBBBBBBBWBWB\n" +
            "BBBBBBBBWBWBW\n" +
            "BBBBBBBBBWBWB\n" +
            "BBBBBBBBWBWBW\n" +
            "BBBBBBBBBWBWB\n" +
            "WWWWWWWWWWBWB\n" +
            "WWWWWWWWWWBWB"; // ans = 12

    public static String input3 = "9 23\n" +
            "BBBBBBBBBBBBBBBBBBBBBBB\n" +
            "BBBBBBBBBBBBBBBBBBBBBBB\n" +
            "BBBBBBBBBBBBBBBBBBBBBBB\n" +
            "BBBBBBBBBBBBBBBBBBBBBBB\n" +
            "BBBBBBBBBBBBBBBBBBBBBBB\n" +
            "BBBBBBBBBBBBBBBBBBBBBBB\n" +
            "BBBBBBBBBBBBBBBBBBBBBBB\n" +
            "BBBBBBBBBBBBBBBBBBBBBBB\n" +
            "BBBBBBBBBBBBBBBBBBBBBBW";

    public static String input4 = "10 10\n" +
            "BBBBBBBBBB\n" +
            "BBWBWBWBWB\n" +
            "BWBWBWBWBB\n" +
            "BBWBWBWBWB\n" +
            "BWBWBWBWBB\n" +
            "BBWBWBWBWB\n" +
            "BWBWBWBWBB\n" +
            "BBWBWBWBWB\n" +
            "BWBWBWBWBB\n" +
            "BBBBBBBBBB";

    public static String input5 = "8 8\n" +
            "BBBBBBBB\n" +
            "BBBBBBBB\n" +
            "BBBBBBBB\n" +
            "BBBBBBBB\n" +
            "BBBBBBBB\n" +
            "BBBBBBBB\n" +
            "BBBBBBBB\n" +
            "BBBBBBBW";

    public static void paintChessBoard() throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader(input3));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int org_row = Integer.parseInt(st.nextToken());
        int org_col = Integer.parseInt(st.nextToken());
        org_board = new boolean[org_row][org_col];

        // 원본 판 정보 입력
        for (int i = 0; i < org_row; ++i) {
            String line = br.readLine().trim();

            for (int j = 0; j < org_col; ++j) {
                char curr = line.charAt(j);
                org_board[i][j] = curr == 'W';
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= org_row - limit; ++i) {
            for (int j = 0; j <= org_col - limit; ++j) {
                min = Math.min(min, getRepaintFactor(i, j));
            }
        }
        System.out.println(min);
    }

    public static boolean[][] org_board;
    public static int limit = 8;

    public static int getRepaintFactor(int s_row, int s_col) {
        int ret = 0;
        boolean std = org_board[s_row][s_col];

        for (int i = s_row; i < s_row + limit; ++i) {
            for (int j = s_col; j < s_col + limit; ++j) {
                if (org_board[i][j] != std) {
                    ++ret;
                }
                std = !std;
            }
            std = !std;
        }
        ret = Math.min(ret, 64 - ret);
        return ret;
    }
}
