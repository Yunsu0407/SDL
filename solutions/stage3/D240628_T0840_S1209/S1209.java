package solutions.stage3.D240628_T0840_S1209;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class S1209 {
    public static void main(String[] args) throws IOException {
        getMax();
    }

    public static void getMax() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        final int SIZE = 100;
        final int TESTCASE = 10;
        int[] answer = new int[TESTCASE];

        for (int i = 0; i < TESTCASE; ++i) {
            br.readLine().trim();

            int[] colSum = new int[SIZE];
            Arrays.fill(colSum, 0);
            int rowMax = Integer.MIN_VALUE;
            int posCrossSum = 0;
            int negCrossSum = 0;
            for (int row = 0; row < SIZE; ++row) {    // 입력과 동시에 행의 최댓값과 대각선의 합을 구함
                StringTokenizer st = new StringTokenizer(br.readLine().trim());
                int rowSum = 0;
                for (int col = 0; col < SIZE; ++col) {
                    int matrixValue = Integer.parseInt(st.nextToken());
                    rowSum = rowSum + matrixValue;
                    colSum[col] = colSum[col] + matrixValue;
                    if (row == col) { // 기울기 음수 대각선의 합
                        negCrossSum = negCrossSum + matrixValue;
                    }
                    if (Math.abs(row - col) == (SIZE - 1)) {  // 기울기 양수 대각선의 합
                        posCrossSum = posCrossSum + matrixValue;
                    }
                }
                rowMax = Math.max(rowMax, rowSum);
            }

            int index = 0;
            int colMax = colSum[index];
            for (index = 1; index < SIZE; ++index) {
                colMax = Math.max(colMax, colSum[index]);
            }

            answer[i] = Math.max(Math.max(rowMax, colMax), Math.max(posCrossSum, negCrossSum));
        }

        for (int i = 0; i < TESTCASE; ++i) {
            System.out.printf("#%d %d\n", i + 1, answer[i]);
        }
    }
}
