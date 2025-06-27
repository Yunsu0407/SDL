package Y2025.M06.D20;

import java.util.*;
import java.io.*;

public class B12100 {
    public static void main(String[] args) throws IOException {
        game2048();
    }

    public static String input1 = "3\n" +
            "2 2 2\n" +
            "4 4 4\n" +
            "8 8 8"; // 16

    public static String input2 = "3\n" +
            "2 0 0\n" +
            "2 2 2\n" +
            "2 2 2\n";

    public static class Frame {
        int[][] board;
        int count;

        public Frame(int[][] board, int count) {
            this.board = board;
            this.count = count;
        }

        public int getMax() {
            int max = 0;
            for (int[] row : board) {
                for (int element : row) {
                    max = Math.max(max, element);
                }
            }
            return max;
        }
    }

    public static void game2048() throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader(input2));
        int size = Integer.parseInt(br.readLine().trim());
        int[][] board = new int[size][size];

        StringTokenizer st;
        for (int r = 0; r < size; ++r) {
            st = new StringTokenizer(br.readLine().trim());
            for (int c = 0; c < size; ++c) {
                board[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Frame> queue = new ArrayDeque<>();
        Frame frame = new Frame(board, 5);
        queue.offer(frame);
        int max = 0;

        while (!queue.isEmpty()) {
            frame = queue.poll();
            boolean bUp = true, bLeft = true;

            if (frame.count > 0) {
                for (int i = 0; i < 4; ++i) {
                    if (i % 2 == 0) {
                        queue.offer(rowJoin(frame, bUp));
                        bUp = !bUp;
                    } else {
                        queue.offer(colJoin(frame, bLeft));
                        bLeft = !bLeft;
                    }
                }
            } else {
                max = Math.max(max, frame.getMax());
            }
        }

        System.out.println(max);
    }

    public static Frame rowJoin(Frame frame, boolean isUp) {
        int sRow;
        int[][] board = frame.board.clone();
        int size = board.length;
        if (isUp) {
            sRow = 1;
            for (int r = sRow; r < size; ++r) {
                for (int c = 0; c < size; ++c) {
                    int pRow = r - 1;   // prevRow
                    int cRow = r;       // currRow

                    if(r % 2 != 0) {
                        int pVal = board[pRow][c];
                        int cVal = board[cRow][c];
                        if (pVal == cVal) {
                            board[pRow][c] = pVal * 2;
                            board[cRow][c] = 0;
                            --pRow;
                            --cRow;
                        }
                    }

                    while(pRow >= 0 && board[pRow][c] == 0){
                        board[pRow][c] = board[cRow][c];
                        board[cRow][c] = 0;
                        --pRow;
                        --cRow;
                    }
                }
            }
        } else {
            sRow = size - 2;
            for (int r = sRow; r >= 0; r = r - 2) {
                for (int c = 0; c < size; ++c) {
                    int pRow = r + 1;   // prevRow
                    int cRow = r;       // currRow
                    int pVal = board[pRow][c];
                    int cVal = board[cRow][c];
                    if (pVal == cVal) {
                        board[pRow][c] = pVal * 2;
                        board[cRow][c] = 0;
                        ++pRow;
                        ++cRow;
                    }

                    while(pRow < size && board[pRow][c] == 0){
                        board[pRow][c] = board[cRow][c];
                        board[cRow][c] = 0;
                        ++pRow;
                        ++cRow;
                    }
                }
            }
        }
        return new Frame(board, frame.count - 1);
    }

    public static Frame colJoin(Frame frame, boolean isLeft) {
        int sCol;
        int[][] board = frame.board.clone();
        int size = board.length;
        if (isLeft) {
            sCol = 1;
            for (int c = sCol; c < size; c = c + 2) {
                for (int r = 0; r < size; ++r) {
                    int pCol = c - 1;   // prevCol
                    int cCol = c;       // currCol
                    int pVal = board[r][pCol];
                    int cVal = board[r][cCol];
                    if (pVal == cVal) {
                        board[r][pCol] = pVal * 2;
                        board[r][cCol] = 0;
                        --pCol;
                        --cCol;
                    }

                    while(pCol >= 0 && board[pCol][c] == 0){
                        board[pCol][c] = board[pCol][c];
                        board[cCol][c] = 0;
                        --pCol;
                        --cCol;
                    }
                }
            }
        } else {
            sCol = size - 2;
            for (int c = sCol; c >= 0; c = c - 2) {
                for (int r = 0; r < size; ++r) {
                    int pCol = c + 1;   // prevCol
                    int cCol = c;       // currCol
                    int pVal = board[r][pCol];
                    int cVal = board[r][cCol];
                    if (pVal == cVal) {
                        board[r][pCol] = pVal * 2;
                        board[r][cCol] = 0;
                        ++pCol;
                        ++cCol;
                    }

                    while(pCol < size && board[pCol][c] == 0){
                        board[pCol][c] = board[pCol][c];
                        board[cCol][c] = 0;
                        ++pCol;
                        ++cCol;
                    }
                }
            }
        }
        return new Frame(board, frame.count - 1);
    }
}
