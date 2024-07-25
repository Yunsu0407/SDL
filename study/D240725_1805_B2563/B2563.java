package D240725_1805_B2563;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2563 {
    public static void main(String[] args) throws IOException {
        calculateSpace();
    }

    public static void calculateSpace() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int SIZE = 100;
        boolean[][] area = new boolean[SIZE][SIZE];
        final int count = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < SIZE; ++i) {
            Arrays.fill(area[i], false);
        }
        for (int i = 0; i < count; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for (int row = y; row < y + 10; ++row) {
                for (int col = x; col < x + 10; ++col) {
                    area[row][col] = true;
                }
            }
        }

        int totalArea = 0;
        for (int row = 0; row < SIZE; ++row) {
            for (int col = 0; col < SIZE; ++col) {
                if (area[row][col]) {
                    ++totalArea;
                }
            }
        }

        System.out.printf("%d", totalArea);
    }
}
