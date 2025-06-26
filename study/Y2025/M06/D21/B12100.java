package study.Y2025.M06.D21;

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

    public static String input2 = "5\n" +
            "2 0 2 0 0\n" +
            "2 2 2 2 2\n" +
            "2 0 2 0 0\n" +
            "2 2 2 2 2\n" +
            "2 2 2 2 2\n"; // 16

    public static String input3 = "5\n" +
            "2 0 0 0 0\n" +
            "2 0 0 0 0\n" +
            "4 0 0 0 0\n" +
            "2 0 0 0 0\n" +
            "2 0 0 0 0";

    public static class Frame {
        int[][] board;
        int count;

        public Frame(int[][] board, int count) {
            int size = board.length;
            this.board = new int[size][size];
            for(int i = 0; i < size; ++i) {
                this.board[i] = board[i].clone();
            }
            this.count = count;
        }

        public int getMax() {
            int max = 0;
            for (int[] row : board) {
                for (int curr : row) {
                    max = Math.max(max, curr);
                }
            }
            return max;
        }
    }

    public static void game2048() throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader(input3));
        int size = Integer.parseInt(br.readLine().trim());
        int[][] board = new int[size][size];

        for (int r = 0; r < size; ++r) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            for (int c = 0; c < size; ++c) {
                board[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        Frame frame = new Frame(board, 5);
        Queue<Frame> queue = new ArrayDeque<>();
        queue.add(frame);
        int max = 0;

        // 0 3 6 9
        int[] dirR = {+1, +0, -1, +0};
        int[] dirC = {+0, -1, +0, +1};
        while (!queue.isEmpty()) {
            Frame curr = queue.poll();
            int count = curr.count;

            if (count > 0) {
                for (int i = 0; i < dirR.length; ++i) {
                    Frame next = getFrame(curr, dirR[i], dirC[i]);
                    queue.offer(next);
                }
            } else {
                max = Math.max(max, curr.getMax());
            }
        }

        System.out.println(max);
    }

    public static Frame getFrame(Frame frame, int dirR, int dirC) {
        int size = frame.board.length;
        int[][] board = new int[size][size];
        for (int i = 0; i < size; ++i) {
            board[i] = frame.board[i].clone();
        }
        int count = frame.count;
        boolean[][] visit = new boolean[size][size];
        int rowStart = (dirR == 0) ? 0 : ((dirR > 0) ? 1 : size - 2);
        int rowEnd = (dirR >= 0) ? size : -1;
        int colStart = (dirC == 0) ? 0 : ((dirC > 0) ? 1 : size - 2);
        int colEnd = (dirC >= 0) ? size : -1;
        int dr = dirR * -1;
        int dc = dirC * -1;
        int ir = (dirR == 0) ? 1 : dirR;
        int ic = (dirC == 0) ? 1 : dirC;

        for (int r = rowStart; r != rowEnd; r = r + ir) {
            for (int c = colStart; c != colEnd; c = c + ic) {
                int pR = r + dr, pC = c + dc; // pR = prevRow, pC = prevCol
                int cR = r, cC = c; // cR = currRow, cC = currCol

                while ((pR >= 0 && pR < size) && (pC >= 0 && pC < size)) {
                    int pVal = board[pR][pC];
                    int cVal = board[cR][cC];
                    if (pVal == cVal) {
                        if (!visit[pR][pC] && !visit[cR][cC]) {
                            board[pR][pC] = board[pR][pC] * 2;
                            board[cR][cC] = 0;
                            visit[pR][pC] = true;
                        }
                    } else if (board[pR][pC] == 0) {
                        board[pR][pC] = board[cR][cC];
                        visit[pR][pC] = visit[cR][cC];
                        board[cR][cC] = 0;
                        visit[cR][cC] = false;
                    } else {
                        break;
                    }
                    pR = pR + dr;
                    pC = pC + dc;
                    cR = cR + dr;
                    cC = cC + dc;
                }
            }
        }

        return new Frame(board, count - 1);
    }
}
