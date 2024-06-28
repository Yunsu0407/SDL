package solutions.stage3.D240626_T0921_S1979;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1979 {
    public static void main(String[] args) throws IOException {
        countPossibleSpace();
    }

    public static void countPossibleSpace() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());
        int[] answer = new int[testcase];

        for (int i = 0; i < testcase; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            final int matrixSize = Integer.parseInt(st.nextToken());
            final int wordSize = Integer.parseInt(st.nextToken());
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int row = 0; row < matrixSize; ++row) {  // 행렬 설정
                st = new StringTokenizer(br.readLine().trim());
                for (int col = 0; col < matrixSize; ++col) {
                    matrix[row][col] = Integer.parseInt(st.nextToken());
                }
            }

            int availableSpace = 0;
            availableSpace = availableSpace + countAvailableSpace(matrix, matrixSize, wordSize, true);
            availableSpace = availableSpace + countAvailableSpace(matrix, matrixSize, wordSize, false);
            answer[i] = availableSpace;
        }

        for (int i = 0; i < testcase; ++i) {
            System.out.printf("#%d %d\n", i + 1, answer[i]);
        }
    }

    public static int countAvailableSpace(int[][] matrix, int matrixSize, int wordSize, boolean isOrdinary) {
        int availableSpace = 0;

        for (int row = 0; row < matrixSize; ++row) {    // 가로
            int spaceCount = 0;
            for (int col = 0; col < matrixSize; ++col) {
                int criteria;
                if (isOrdinary) {   // 정방
                    criteria = matrix[row][col];
                } else {    // 전치
                    criteria = matrix[col][row];
                }
                if (criteria == 1) {
                    ++spaceCount;
                } else {
                    if (spaceCount == wordSize) {
                        ++availableSpace;
                    }
                    spaceCount = 0;
                }
            }
            if (spaceCount == wordSize) {
                ++availableSpace;
            }
        }
        return availableSpace;
    }
}
