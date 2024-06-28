package solutions.stage3.D240628_T0939_S11315;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Iterator;

public class S11315 {
    public static void main(String[] args) throws IOException {
        judgeOmok();
    }

    public static void judgeOmok() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int testcase = Integer.parseInt(br.readLine().trim());
        String[] answer = new String[testcase];

        for (int i = 0; i < testcase; ++i) {
            final int mat_size = Integer.parseInt(br.readLine().trim());
            Omok omok = new Omok(mat_size);

            for (int row = 0; row < mat_size; ++row) {
                String s = br.readLine().trim();
                omok.setUpMatrix(row, s);
            }   // 오목판 정보 입력 완료

            if (omok.judgeAll()) {
                answer[i] = "YES";
            } else {
                answer[i] = "NO";
            }
        }

        for (int i = 0; i < testcase; ++i) {
            System.out.printf("#%d %s\n", i + 1, answer[i]);
        }
    }

    public static class Omok {
        private final int mat_size;
        private final String[][] matrix;
        private final int limit;
        private final HashMap<Integer, LinkedList<Integer>> rockPosition;

        public Omok(int mat_size) {
            this.mat_size = mat_size;
            this.matrix = new String[mat_size][mat_size];
            this.limit = 5;
            this.rockPosition = new HashMap<>();
        }

        public void setUpMatrix(int row, String s) {
            LinkedList<Integer> rock = new LinkedList<>();
            for (int col = 0; col < mat_size; ++col) {
                String value = String.valueOf(s.charAt(col));
                matrix[row][col] = value;
                if (isRock(value)) {
                    rock.add(col);
                }
            }
            rockPosition.put(row, rock);
        }

        public boolean isRock(String value) {
            return value.equals("o");
        }

        public boolean judgeAll() {
            boolean isOmok = false;
            if (judgeRow()) {
                isOmok = true;
            } else {
                if (judgeCol()) {
                    isOmok = true;
                } else {
                    if (judgeNegCross()) {
                        isOmok = true;
                    } else {
                        if (judgePosCross()) {
                            isOmok = true;
                        }
                    }
                }
            }
            return isOmok;
        }

        public boolean judgeRow() {
            boolean isOmok = false;

            for (int row = 0; row < mat_size; ++row) {
                int continuous = 0;
                for (int col = 0; col < mat_size; ++col) {
                    String value = matrix[row][col];
                    if (isRock(value)) {
                        ++continuous;
                    } else {
                        continuous = 0;
                    }
                    if (continuous == limit) {
                        isOmok = true;
                        break;
                    }
                }
            }

            return isOmok;
        }

        public boolean judgeCol() {
            boolean isOmok = false;

            for (int row = 0; row < mat_size; ++row) {
                int continuous = 0;
                for (int col = 0; col < mat_size; ++col) {
                    String value = matrix[col][row];
                    if (isRock(value)) {
                        ++continuous;
                    } else {
                        continuous = 0;
                    }
                    if (continuous == limit) {
                        isOmok = true;
                        break;
                    }
                }
            }

            return isOmok;
        }

        public boolean judgeNegCross() {
            boolean isOmok = false;

            for (int row = 0; row < mat_size - 1 && !isOmok; ++row) {
                LinkedList<Integer> currRock = rockPosition.get(row);
                Iterator<Integer> iterator = currRock.iterator();
                while (iterator.hasNext() && !isOmok) {
                    int col = iterator.next();
                    int currRow = row;
                    int currCol = col;
                    int continuous = 1;
                    while (currRow < mat_size - 1 && currCol < mat_size - 1) {
                        String nextRock = matrix[++currRow][++currCol];
                        if (isRock(nextRock)) {
                            ++continuous;
                            if (continuous == limit) {
                                isOmok = true;
                                break;
                            }
                        } else {
                            break;
                        }

                    }
                }
            }

            return isOmok;
        }

        public boolean judgePosCross() {
            boolean isOmok = false;

            for (int row = 0; row < mat_size - 1 && !isOmok; ++row) {
                LinkedList<Integer> currRock = rockPosition.get(row);
                Iterator<Integer> iterator = currRock.iterator();
                while (iterator.hasNext() && !isOmok) {
                    int col = iterator.next();
                    int currRow = row;
                    int currCol = col;
                    int continuous = 1;
                    while (currRow < mat_size - 1 && currCol > 0) {
                        String nextRock = matrix[++currRow][--currCol];
                        if (isRock(nextRock)) {
                            ++continuous;
                            if (continuous == limit) {
                                isOmok = true;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }

            return isOmok;
        }
    }
}
