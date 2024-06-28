package solutions.stage3.D240627_T1025_S2001;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2001 {
    public static void main(String[] args) throws IOException {
        countingFlies();
    }

    public static void countingFlies() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int testcase = Integer.parseInt(br.readLine().trim());
        int[] answer = new int[testcase];

        for (int i = 0; i < testcase; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            final int mat_size = Integer.parseInt(st.nextToken());
            final int hit_size = Integer.parseInt(st.nextToken());
            int[][] matrix = new int[mat_size][mat_size];

            for (int row = 0; row < mat_size; ++row) {  // 파리테이블 입력
                st = new StringTokenizer(br.readLine().trim());
                for (int col = 0; col < mat_size; ++col) {
                    matrix[row][col] = Integer.parseInt(st.nextToken());
                }
            }

            int maxHit = Integer.MIN_VALUE;
            int currHit;
            int range = mat_size - hit_size + 1;

            for (int row = 0; row < range; ++row) {
                for (int col = 0; col < range; ++col) {
                    currHit = getHit(matrix, row, col, hit_size);
                    if (maxHit < currHit) {
                        maxHit = currHit;
                    }
                }
            }

            answer[i] = maxHit;
        }

        for (int i = 0; i < testcase; ++i) {
            System.out.printf("#%d %d\n ", i + 1, answer[i]);
        }
    }

    public static int getHit(int[][] matrix, int row, int col, int hit_size) {
        int sum = 0;
        for (int i = row; i < row + hit_size; ++i) {
            for (int j = col; j < col + hit_size; ++j) {
                sum = sum + matrix[i][j];
            }
        }
        return sum;
    }
}
