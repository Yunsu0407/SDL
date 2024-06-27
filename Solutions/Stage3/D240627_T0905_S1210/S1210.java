package Solutions.Stage3.D240627_T0905_S1210;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;

public class S1210 {
    public static void main(String[] args) throws IOException {
        getPunished();
    }

    public static void getPunished() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int TESTCASE = 10;
        final int MATRIX_SIZE = 100;
        int[] answer = new int[TESTCASE];

        for (int i = 0; i < TESTCASE; ++i) {
            Ladder ladder = new Ladder(MATRIX_SIZE);

            br.readLine().trim();
            StringTokenizer st;
            for (int row = 0; row < MATRIX_SIZE; ++row) {
                st = new StringTokenizer(br.readLine().trim());
                ladder.setMatrix(row, st);
            }

            answer[i] = ladder.findPenaltyRecipient();
        }

        for (int i = 0; i < TESTCASE; ++i) {
            System.out.printf("#%d %d\n", i + 1, answer[i]);
        }
    }

    public static class Ladder {
        private final int MATRIX_SIZE;
        private final int[][] matrix;
        private final LinkedList<Integer> startingPoint;  // 사다리 시작점

        public Ladder(int matrix_size) {
            this.MATRIX_SIZE = matrix_size;
            this.matrix = new int[MATRIX_SIZE][MATRIX_SIZE];
            this.startingPoint = new LinkedList<>();
        }

        public void setMatrix(int row, StringTokenizer st) { // 사다리 설정, 참가자 확인, 시작지점 확인
            for (int col = 0; col < MATRIX_SIZE; ++col) {
                int value = Integer.parseInt(st.nextToken());
                matrix[row][col] = value;
                if (row == 0 && value == 1) {
                    this.startingPoint.add(col);
                }
            }
        }

        public Integer findPenaltyRecipient() {
            Integer point;

            while ((point = startingPoint.poll()) != null) {
                if (findPath(point)) {
                    break;
                }
            }

            return point;
        }

        public boolean findPath(int point) {
            int row = 0;
            int col = point;
            int veryLastIndex = MATRIX_SIZE - 1;
            int left, right;
            boolean goingLeft = false;
            boolean goingRight = false;

            while (row < veryLastIndex) {
                if (col > 0 && col < veryLastIndex) {   // 열이 0초과 99미만인 경우
                    left = matrix[row][col - 1];
                    right = matrix[row][col + 1];
                    if (left == 0 && right == 0) {
                        ++row;
                        goingLeft = goingRight = false;
                        continue;
                    }
                    if (left > 0 && right == 0) {
                        if (goingRight) {
                            ++row;
                            goingRight = false;
                        } else {
                            --col;
                            goingLeft = true;
                        }
                        continue;
                    }
                    if (left == 0 && right > 0) {
                        if (goingLeft) {
                            ++row;
                            goingLeft = false;
                        } else {
                            ++col;
                            goingRight = true;
                        }
                        continue;
                    }
                    if (left > 0 && right > 0) {
                        if (goingLeft) {
                            --col;
                        }
                        if (goingRight) {
                            ++col;
                        }
                        continue;
                    }
                } else if (col == 0) {  // 열이 0인 경우
                    right = matrix[row][col + 1];
                    if (right == 0) {
                        ++row;
                    } else {
                        if (goingLeft) {
                            ++row;
                            goingLeft = false;
                        } else {
                            ++col;
                            goingRight = true;
                        }
                    }
                } else {    // 열이 99인 경우
                    left = matrix[row][col - 1];
                    if (left == 0) {
                        ++row;
                    } else {
                        if (goingRight) {
                            ++row;
                            goingRight = false;
                        } else {
                            --col;
                            goingLeft = true;
                        }
                    }
                }
            }

            return matrix[row][col] == 2;
        }
    }
}
