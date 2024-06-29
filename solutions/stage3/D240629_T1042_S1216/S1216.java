package solutions.stage3.D240629_T1042_S1216;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class S1216 {
    public static void main(String[] args) throws IOException {
        getLengthOfLongestPalindrome();
    }

    public static void getLengthOfLongestPalindrome() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int TESTCASE = 10;
        final int MAT_SIZE = 100;

        for (int i = 0; i < TESTCASE; ++i) {
            int ansIndex = Integer.parseInt(br.readLine().trim());
            WordMatrix matrix = new WordMatrix(MAT_SIZE);

            for (int row = 0; row < MAT_SIZE; ++row) {
                String line = br.readLine().trim();
                matrix.setMatrix(row, line);
            }

            int ans = matrix.checkAll();
            System.out.printf("#%d %d\n", ansIndex, ans);
        }
    }

    public static class WordMatrix {
        private final int MAT_SIZE;
        private final String[][] matrix;
        private int maxLength;

        public WordMatrix(int size) {
            this.MAT_SIZE = size;
            this.matrix = new String[MAT_SIZE][MAT_SIZE];
            this.maxLength = Integer.MIN_VALUE;
        }

        public void setMatrix(int row, String line) {   // 글자판 생성
            for (int col = 0; col < MAT_SIZE; ++col) {
                matrix[row][col] = String.valueOf(line.charAt(col));
            }
        }

        public int checkAll() {
            checkStraight(true);
            checkStraight(false);
            return this.maxLength + 1;
        }

        private void checkStraight(boolean isRow) {
            int size = MAT_SIZE;
            for (int row = 0; row < MAT_SIZE; ++row) {
                int step = size - 1;
                while (step > 0 && step > maxLength) {
                    int movement = size - step;
                    for (int colMove = 0; colMove < movement; ++colMove) {
                        boolean isPal = true;
                        int rear = step + colMove;
                        int front = rear - step;
                        while (front < rear) {
                            if (isSame(row, front, rear, isRow)) {
                                ++front;
                                --rear;
                            } else {
                                isPal = false;
                                break;
                            }
                        }
                        if (isPal) {
                            this.maxLength = Math.max(maxLength, step);
                            break;
                        }
                    }
                    --step;
                }
            }
        }

        public boolean isSame(int row, int front, int rear, boolean isRow) {
            String sFront;
            String sRear;
            if (isRow) {
                sFront = matrix[row][front];
                sRear = matrix[row][rear];
            } else {
                sFront = matrix[front][row];
                sRear = matrix[rear][row];
            }
            return sFront.equals(sRear);
        }
    }
}
