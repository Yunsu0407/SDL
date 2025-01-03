package D240814_T2138_B20057;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B20057 {
    public static void main(String[] args) throws IOException {
        calculateAmountOfLostSand();
    }

    public static final int LEFT = 0;
    public static final int DOWN = 1;
    public static final int RIGHT = 2;
    public static final int UP = 3;
    public static final int ROW = 0, COL = 1;
    public static int lostSand = 0;
    public static int[][] sand;
    public static int SIZE;

    public static void calculateAmountOfLostSand() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        SIZE = Integer.parseInt(br.readLine().trim());
        sand = new int[SIZE][SIZE];

        for (int row = 0; row < SIZE; ++row) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            for (int col = 0; col < SIZE; ++col) {
                sand[row][col] = Integer.parseInt(st.nextToken());
            }
        }   // 이차원 배열에 모래량 수령
        br.close();

        getLostSand();
        System.out.printf("%d", lostSand);
    }

    public static void getLostSand() {
        int cDir = 0;
        int movement = 0;
        int count = 2;
        int cRow, cCol;

        cRow = cCol = SIZE / 2;
        while (!(cRow == 0 && cCol == 0)) {
            if (count == 2) {
                ++movement;
                if (movement == SIZE) {
                    movement = movement - 1;
                }
            }
            cDir = cDir % 4;
            count = count % 2;
            int[] renew = moveTornado(cDir, movement, cRow, cCol);
            cRow = renew[ROW];
            cCol = renew[COL];
            ++cDir;
            ++count;
        }
    }

    public static int[] moveTornado(int cDir, int movement, int cRow, int cCol) {
        int[] dirRow = {0, 1, 0, -1};
        int[] dirCol = {-1, 0, 1, 0};
        final int DIMENSION = 2;
        int[] ord = new int[DIMENSION];

        ord[ROW] = cRow;
        ord[COL] = cCol;
        switch (cDir) {
            case LEFT, RIGHT:
                for (int i = 0; i < movement; ++i) {
                    ord[COL] = ord[COL] + dirCol[cDir];
                    moveSand(ord, cDir);
                }
                break;
            case DOWN, UP:
                for (int i = 0; i < movement; ++i) {
                    ord[ROW] = ord[ROW] + dirRow[cDir];
                    moveSand(ord, cDir);
                }
                break;
        }

        return ord;
    }

    public static void moveSand(int[] ord, int cDir) {
        int base = sand[ord[ROW]][ord[COL]];
        int[] ratios = {1, 7, 2, 10, 5};
        int size = ratios.length;
        int[] values = new int[size];
        int residue = 0;
        int[][] posRow = {{1, 1, 2, 1, 0, 0}, {-1, 0, 0, 1, 2, 1}, {1, 1, 2, 1, 0, 0}, {1, 0, 0, -1, -2, -1}};
        int[][] posCol = {{1, 0, 0, -1, -2, -1}, {1, 1, 2, 1, 0, 0}, {-1, 0, 0, 1, 2, 1}, {1, 1, 2, 1, 0, 0}};

        for (int i = 0; i < size; ++i) {
            values[i] = base * ratios[i] / 100;
            if (i < size - 1) {
                residue = residue + values[i] * 2;
            } else {
                residue = residue + values[i];
            }
        }

        switch (cDir) {
            case LEFT, RIGHT:
                for (int i = 0; i < size; ++i) {
                    if (values[i] > 0) {
                        if (i < size - 1) {
                            moveEachSand(values[i], ord[ROW] + posRow[cDir][i], ord[COL] + posCol[cDir][i]);
                            moveEachSand(values[i], ord[ROW] - posRow[cDir][i], ord[COL] + posCol[cDir][i]);
                        } else {
                            moveEachSand(values[i], ord[ROW] + posRow[cDir][i], ord[COL] + posCol[cDir][i]);
                        }
                    }
                }
                break;
            case DOWN, UP:
                for (int i = 0; i < size; ++i) {
                    if (values[i] > 0) {
                        if (i < size - 1) {
                            moveEachSand(values[i], ord[ROW] + posRow[cDir][i], ord[COL] + posCol[cDir][i]);
                            moveEachSand(values[i], ord[ROW] + posRow[cDir][i], ord[COL] - posCol[cDir][i]);
                        } else {
                            moveEachSand(values[i], ord[ROW] + posRow[cDir][i], ord[COL] + posCol[cDir][i]);
                        }
                    }
                }
                break;
        }
        residue = base - residue;
        sand[ord[ROW]][ord[COL]] = 0;
        moveEachSand(residue, ord[ROW] + posRow[cDir][size], ord[COL] + posCol[cDir][size]);
    }

    public static void moveEachSand(int value, int nRow, int nCol) {
        try {
            sand[nRow][nCol] = sand[nRow][nCol] + value;
        } catch (ArrayIndexOutOfBoundsException e) {
            lostSand = lostSand + value;
        }
    }
}
