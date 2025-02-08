package Y2025.M02.D07;

import java.util.*;
import java.io.*;

public class B3254 {
    public static void main(String[] args) throws IOException {
        throwGimbap();
    }

    public static String input1 = "2 2\n" +
            "5 2\n" +
            "3 7\n" +
            "6 1\n" +
            "4 6\n" +
            "3 1\n" +
            "3 5\n" +
            "3 3\n" +
            "6 3\n" +
            "2 5\n" +
            "4 1\n" +
            "6 2\n" +
            "2 5\n" +
            "7 5\n" +
            "1 7\n" +
            "4 4\n" +
            "4 1\n" +
            "7 6\n" +
            "1 7\n" +
            "7 5\n" +
            "6 4";

    public static String input2 = "1 1\n" +
            "2 4\n" +
            "6 4\n" +
            "5 1\n" +
            "1 2\n" +
            "7 4\n" +
            "3 4\n" +
            "7 7\n" +
            "4 6\n" +
            "3 5\n" +
            "2 4\n" +
            "6 1\n" +
            "7 3\n" +
            "6 3\n" +
            "6 1\n" +
            "6 3\n" +
            "2 5\n" +
            "7 3\n" +
            "2 7\n" +
            "2 5\n" +
            "5 5";

    public static String input3 = "1 2\n" +
            "1 2\n" +
            "1 2\n" +
            "2 1\n" +
            "2 1\n" +
            "2 1\n" +
            "3 4\n" +
            "3 4\n" +
            "3 4\n" +
            "4 3\n" +
            "4 3\n" +
            "4 3\n" +
            "5 6\n" +
            "5 6\n" +
            "5 6\n" +
            "6 5\n" +
            "6 5\n" +
            "6 5\n" +
            "7 7\n" +
            "7 7\n" +
            "7 7";

    /*
    각각 김밥 21개 총 42개를 던진다.
    가로, 세로, 대각선 중 김밥이 일렬로 4개 이어진 사람이 승리
    불리언 배열을 이용해서 공용판에 김밥의 상태를 저장하고, 이때 각각의 개인판에 순서와 함께 저장한다.
    김밥 던지기를 모두 마친 후 각각의 판에서 각 김밥에 대한 4개 연속 이어짐 여부를 확인한다.
    이 과정에서 김밥이 이어진 경우 가장 큰 순서를 알아내고, 최소값과 비교하여 더 작은 경우 저장한다.
    4개 연속이 없는 경우 -1로 저장한다.
     */

    public static final int SK = 0, JI = 1, ROW_SIZE = 6, COL_SIZE = 7;
    public static boolean[][] commonBoard;
    public static int[][] board_SK;
    public static int[][] board_JI;

    public static void throwGimbap() throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader(input3));

        int[][] history = new int[21][2];
        for (int i = 0; i < 21; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            history[i][SK] = Integer.parseInt(st.nextToken()) - 1; // 인덱스 값으로 저장
            history[i][JI] = Integer.parseInt(st.nextToken()) - 1; // 인덱스 값으로 저장
        }

        commonBoard = new boolean[ROW_SIZE][COL_SIZE]; // 공용판
        board_SK = new int[ROW_SIZE][COL_SIZE]; // 상근이의 개인판
        board_JI = new int[ROW_SIZE][COL_SIZE]; // 정인이의 개인판

        int step = 0;
        for (int[] state : history) {
            ++step;
            insertGimbap(SK, step, state[SK]); // 상근이 먼저 넣고
            insertGimbap(JI, step, state[JI]); // 정인이 진행
        }

        int score_SK = checkBoard(SK);
        int score_JI = checkBoard(JI);

        String ans;
        if(score_SK < score_JI) { // 상근 승
            ans = String.format("sk %d", score_SK);
        } else if(score_SK > score_JI) { // 정인 승
            ans = String.format("ji %d", score_JI);
        } else {
            if(score_SK == 0) { // 둘 다 연속을 만들지 못하면
                ans = "ss"; // 무승부
            } else { // 동시에 둘 다 먼저 연속을 만들면
                ans = String.format("sk %d", score_SK); // 선턴인 상근이의 승리
            }
        }

        System.out.println(ans);
    }

    public static int checkBoard(int person) {
        int[][] board;
        if (person == SK) {
            board = board_SK;
        } else {
            board = board_JI;
        }

        boolean seriesSuccess = false;
        int minScore = 22;
        for (int row = 0; row < ROW_SIZE; ++row) {
            for (int col = 0; col < COL_SIZE; ++col) {
                int currGimbap = board[row][col]; // 현재 판에 가르키는 곳의 상태

                if (currGimbap > 0) { // 김밥이 들어가 있다면
                    int currScore = checkEightDir(row, col, board);
                    if ( currScore > 0) { // 8방 검사
                        // 최소 갱신
                        minScore = Math.min(minScore, currScore);
                        seriesSuccess = true;
                    }
                }
            }
        }

        if(seriesSuccess) {
            return minScore;
        } else {
            return 0;
        }
    }

    // 단일칸에 대한 8방 검사 함수
    public static int checkEightDir(int row, int col, int[][] board) {
        final int ROW = 0, COL = 1;
        int[][] dir = { // 0(180) 15 30 45 ... 155
                {-1, -1, +0, +1, +1, +1, +0, -1},
                {+0, +1, +1, +1, +0, -1, -1, -1}
        };

        boolean seriesSuccess = false;
        int finalState = 22;
        for (int i = 0; i < dir[0].length; ++i) {
            boolean skipFlag = false;
            int checkRate = 3;
            int nextRow = row;
            int nextCol = col;

            int currState = board[row][col];
            while (checkRate > 0) {
                nextRow = nextRow + dir[ROW][i];
                nextCol = nextCol + dir[COL][i];

                if (nextRow < 0 || nextRow >= ROW_SIZE || nextCol < 0 || nextCol >= COL_SIZE || board[nextRow][nextCol] == 0) {
                    skipFlag = true;
                    break;
                }

                currState = Math.max(currState, board[nextRow][nextCol]);
                --checkRate;
            }

            if (skipFlag) {
                continue;
            } else {
                finalState = Math.min(finalState, currState);
                seriesSuccess = true;
            }
        }

        if (seriesSuccess) {
            return finalState;
        } else {
            return 0;
        }
    }

    // 공용판과 개인판에 김밥을 추가
    public static void insertGimbap(int person, int step, int col) {
        int[][] board;
        if (person == SK) {
            board = board_SK;
        } else {
            board = board_JI;
        }

        for (int row = ROW_SIZE - 1; row >= 0; --row) {
            if (!commonBoard[row][col]) {
                commonBoard[row][col] = true;
                board[row][col] = step;
                break;
            }
        }
    }
}
