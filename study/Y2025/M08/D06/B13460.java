package study.Y2025.M08.D06;

import java.util.*;
import java.io.*;

public class B13460 {
    public static void main(String[] args) throws IOException {
        marbleEscape();
    }

    public static class Position {
        int[][] pos;

        public Position(int[][] pos) {
            this.pos = new int[pos.length][];
            for (int i = 0; i < pos.length; ++i) {
                this.pos[i] = pos[i].clone();
            }
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;

            Position other = (Position) obj;
            int[][] oPos = other.pos;
            boolean red = pos[RED][ROW] == oPos[RED][ROW] && pos[RED][COL] == oPos[RED][COL];
            boolean blue = pos[BLUE][ROW] == oPos[BLUE][ROW] && pos[BLUE][COL] == oPos[BLUE][COL];

            return red && blue;
        }

        @Override
        public int hashCode() {
            int result = 17;
            result = 31 * result + pos[RED][ROW];
            result = 31 * result + pos[RED][COL];
            result = 31 * result + pos[BLUE][ROW];
            result = 31 * result + pos[BLUE][COL];
            return result;
        }
    }

    public static final int ROW = 0, COL = 1;
    public static Set<Position> set = new HashSet<>();

    public static void marbleEscape() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int rowSize = Integer.parseInt(st.nextToken());
        int colSize = Integer.parseInt(st.nextToken());
        int[][] board = new int[rowSize][colSize];
        int[][] pos = new int[2][2];
        int[] hole = new int[2];

        for (int r = 0; r < rowSize; ++r) {
            String[] line = br.readLine().trim().split("");
            for (int c = 0; c < colSize; ++c) {
                int state = classifyState(line[c]);
                board[r][c] = state;
                if (state == RED || state == BLUE) {
                    pos[state][ROW] = r;
                    pos[state][COL] = c;
                } else if (state == HOLE) {
                    hole[ROW] = r;
                    hole[COL] = c;
                }
            }
        }
        Position position = new Position(pos);
        set.add(position);

        checkBoard(board, position, hole, 0);

        if (min == LIMIT + 1) {
            min = -1;
        }

        System.out.println(min);
    }

    public static final int DR = 0, DC = 1;
    public static final int UP = 0, RIGHT = 1, DOWN = 2, LEFT = 3;
    public static final int KIND = 2, LIMIT = 10;
    public static int min = LIMIT + 1;

    public static void checkBoard(int[][] board, Position position, int[] hole, int count) {
        boolean possible = count < LIMIT;
        if (!possible) {
            return;
        }

        int[][] data = { // DR, RC
                {-1, 0}, // UP
                {0, 1}, // RIGHT
                {1, 0}, // DOWN
                {0, -1} // LEFT
        };
        int nCount = count + 1;

        for (int i = 0; i < data.length; ++i) {
            int[][] nBoard = new int[board.length][];
            int[][] pos = position.pos;
            int[][] nPos = new int[pos.length][pos[0].length];
            int[] order = getOrder(pos, i);
            boolean[] goal = new boolean[KIND];

            for (int j = 0; j < board.length; ++j) {
                nBoard[j] = board[j].clone();
            }

            for (int j : order) {
                int[] onePos = moveMarble(nBoard, pos[j], data[i], goal, j);
                nPos[j][ROW] = onePos[ROW];
                nPos[j][COL] = onePos[COL];
            }

            if (!goal[BLUE]) {
                if (goal[RED]) { // success
                    min = Math.min(min, nCount);
                } else { // keep
                    Position nPosition = new Position(nPos);
                    if (!set.contains(nPosition)) {
                        checkBoard(nBoard, nPosition, hole, nCount);
                    }
                }
            }
        }
    }

    public static int[] moveMarble(int[][] board, int[] pos, int[] data, boolean[] goal, int order) {
        int[] onePos = new int[2];
        int ir = pos[ROW];
        int ic = pos[COL];
        int cr = ir;
        int cc = ic;

        while (true) {
            int nr = cr + data[DR];
            int nc = cc + data[DC];
            int nState = board[nr][nc];

            if (nState == EMPTY) {
                cr = nr;
                cc = nc;
            } else if (nState == HOLE) {
                cr = nr;
                cc = nc;
                goal[order] = true;
                break;
            } else { // nState == WALL || MARBLE
                break;
            }
        }

        board[ir][ic] = EMPTY;
        if (!goal[order]) {
            board[cr][cc] = order;
        }

        onePos[ROW] = cr;
        onePos[COL] = cc;
        return onePos;
    }

    // UP = lowRow, RIGHT = highCol, DOWN = highRow, LEFT = lowCol
    public static int[] getOrder(int[][] pos, int order) {
        int[] red = {0, 1};
        int[] blue = {1, 0};

        if (order == UP) {
            return pos[RED][ROW] < pos[BLUE][ROW] ? red : blue;
        } else if (order == RIGHT) {
            return pos[RED][COL] > pos[BLUE][COL] ? red : blue;
        } else if (order == DOWN) {
            return pos[RED][ROW] > pos[BLUE][ROW] ? red : blue;
        } else { // order == LEFT
            return pos[RED][COL] < pos[BLUE][COL] ? red : blue;
        }
    }

    public static final int RED = 0, BLUE = 1, HOLE = 2, WALL = 3, EMPTY = 4;

    public static int classifyState(String str) {
        int state;
        if (str.equals("R")) {
            state = RED;
        } else if (str.equals("B")) {
            state = BLUE;
        } else if (str.equals("O")) {
            state = HOLE;
        } else if (str.equals("#")) {
            state = WALL;
        } else {
            state = EMPTY;
        }
        return state;
    }
}
