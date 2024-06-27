package Solutions.Stage3.D240627_T1147_S1954;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class S1954 {
    public static void main(String[] args) throws IOException {
        printSnail();
    }

    public static void printSnail() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());
        Matrix[] answer = new Matrix[testcase];

        for (int i = 0; i < testcase; ++i) {
            final int SIZE = Integer.parseInt(br.readLine().trim());
            int[][] matrix = new int[SIZE][SIZE];
            int number = 0;
            int row, col;
            boolean isReduce = true;
            int indexSize = SIZE;
            int cycle = 0;
            int direction = 0;
            while (indexSize > 0) {
                if (direction == 4) {
                    ++cycle;
                }
                direction = direction % 4;
                switch (direction) {
                    case 0:
                        row = cycle;
                        for (int j = 0; j < indexSize; ++j) {
                            col = cycle + j;
                            matrix[row][col] = ++number;
                        }
                        break;
                    case 1:
                        col = SIZE - (cycle + 1);
                        for (int j = 0; j < indexSize; ++j) {
                            row = cycle + j + 1;
                            matrix[row][col] = ++number;
                        }
                        break;
                    case 2:
                        row = SIZE - (cycle + 1);
                        for (int j = 0; j < indexSize; ++j) {
                            col = SIZE - (cycle + 2) - j;
                            matrix[row][col] = ++number;
                        }
                        break;
                    case 3:
                        col = cycle;
                        for (int j = 0; j < indexSize; ++j) {
                            row = SIZE - (cycle + 2) - j;
                            matrix[row][col] = ++number;
                        }
                        break;
                }
                ++direction;
                if (isReduce) {
                    --indexSize;
                }
                isReduce = !isReduce;
            }
            answer[i] = new Matrix(matrix, SIZE);
        }

        for (int i = 0; i < testcase; ++i) {
            System.out.printf("#%d\n", i + 1);
            answer[i].printMatrix();
        }
    }

    public static class Matrix {
        private int[][] matrix;
        private int size;

        public Matrix(int[][] matrix, int size) {
            this.matrix = matrix;
            this.size = size;
        }

        public void printMatrix() {
            for (int row = 0; row < size; ++row) {
                for (int col = 0; col < size; ++col) {
                    System.out.printf("%d ", matrix[row][col]);
                }
                System.out.println();
            }
        }
    }
}
