package study.Y2025.M05.D01;

import java.util.*;
import java.io.*;

public class B3020 {
    public static void main(String[] args) throws IOException {
        firefly();
    }

    public static String input1 = "6 7\n" +
            "1\n" +
            "5\n" +
            "3\n" +
            "3\n" +
            "5\n" +
            "1";
    // ans 2 3

    // 동굴의 길이(열) N, 높이(행) H, N은 2 ~ 200_000, H는 2 ~ 500_000
    // 첫번째 장애물은 석순 이후 석순과 종유석이 번갈아 등장
    // 개똥벌레는 장애물을 파괴함
    public static void firefly() throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader(input1));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int colSize = Integer.parseInt(st.nextToken());
        int rowSize = Integer.parseInt(st.nextToken());
        int[][] cave = new int[rowSize][colSize];

        System.out.println(cave.length);

        for (int row = 0; row < colSize; ++row) {
            int length = Integer.parseInt(br.readLine().trim());
            setCave(cave, row, length);
        }

        List<Integer> lastObs = new ArrayList<>();
        for (int i = 0; i < colSize; ++i) {
            lastObs.add(cave[rowSize - 1][i]);
        }

        Collections.sort(lastObs);
        int min = lastObs.remove(0);
        int count = 0;
        for (int curr : lastObs) {
            if (curr == min) {
                ++count;
            } else {
                break;
            }
        }

        System.out.println(min + " " + count);
    }

    public static void setCave(int[][] cave, int row, int length) {
        boolean isBottom = row % 2 == 0;
        int start, end;
        if (isBottom) { // start = 0, end = length
            start = 0;
            end = length;
        } else { // start = size - length, end = size
            start = cave.length - length;
            end = cave.length;
        }

        for (int col = start; col < end; ++col) {
            if (row == 0) {
                cave[row][col] = 1;
            } else {
                cave[row][col] = cave[row - 1][col] + 1;
            }
        }
    }
}
