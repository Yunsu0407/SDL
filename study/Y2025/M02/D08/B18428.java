package study.Y2025.M02.D08;

import java.util.*;
import java.io.*;

public class B18428 {
    public static void main(String[] args) throws IOException {
        dodgeObserve();
    }

    public static int SIZE;

    public static void dodgeObserve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        SIZE = Integer.parseInt(br.readLine().trim());
        int[][] state = new int[SIZE][SIZE];
        boolean[][] dodge = new boolean[SIZE][SIZE];
        final String Student = "S", Teacher = "T";

        for (int row = 0; row < SIZE; ++row) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            for (int col = 0; col < SIZE; ++col) {
                String curr = st.nextToken();
                if (curr.equals(Student)) {
                    state[row][col] = 1; // 학생 = 1
                } else if (curr.equals(Teacher)) {
                    state[row][col] = 2; // 선생 = 2;
                }
            }
        }

        for (int row = 0; row < SIZE; ++row) {
            for (int col = 0; col < SIZE; ++col) {
                if (state[row][col] == 1) { // 학생이면
                    checkFourDir(row, col, state, dodge);
                }
            }
        }

        int dodgeLimit = 0;
        for (int row = 0; row < SIZE; ++row) {
            for (int col = 0; col < SIZE; ++col) {
                if(dodge[row][col]){
                    ++dodgeLimit;
                }
            }
        }

        String ans;
        if(dodgeLimit <= 3) {
            ans = "YES";
        } else {
            ans = "NO";
        }

        System.out.println(ans);
    }

    public static void checkFourDir(int row, int col, int[][] state, boolean[][] dodge) {
        final int ROW = 0, COL = 1;
        int[][] dir = {
                {-1, +0, +1, +0},
                {+0, +1, +0, -1}
        };

        for (int i = 0; i < dir[0].length; ++i) {
            int initRow = row + dir[ROW][i];
            int initCol = col + dir[COL][i];

            int nextRow = initRow;
            int nextCol = initCol;

            while (!(nextRow < 0 || nextRow >= SIZE || nextCol < 0 || nextCol >= SIZE)) {
                int nextState = state[nextRow][nextCol];

                if (nextState == 2) {
                    dodge[initRow][initCol] = true;
                    break;
                }
                nextRow = nextRow + dir[ROW][i];
                nextCol = nextCol + dir[COL][i];
            }
        }
    }
}
