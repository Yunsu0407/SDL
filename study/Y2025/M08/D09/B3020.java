package study.Y2025.M08.D09;

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
            "1"; // 2 3

    public static String input2 = "14 5\n" +
            "1\n" +
            "3\n" +
            "4\n" +
            "2\n" +
            "2\n" +
            "4\n" +
            "3\n" +
            "4\n" +
            "3\n" +
            "3\n" +
            "3\n" +
            "2\n" +
            "3\n" +
            "3"; // 7 2

    public static void firefly() throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader(input2));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int colSize = Integer.parseInt(st.nextToken());
        int rowSize = Integer.parseInt(st.nextToken());
        boolean[][] cave = new boolean[rowSize][colSize];

        // 아래(짝), 위(홀) 반복
        boolean even = true;
        for (int c = 0; c < colSize; ++c) {
            int len = Integer.parseInt(br.readLine().trim());
            makeCave(cave, even, len, c);
            even = !even;
        }

        for (int r = 0; r < rowSize; ++r) {
            getSmash(cave, r);
        }

        int count = map.get(min);
        System.out.println(min + " " + count);
    }

    public static int min = Integer.MAX_VALUE;
    public static Map<Integer, Integer> map = new TreeMap<>();

    public static void getSmash(boolean[][] cave, int r) {
        int smash = 0;
        for (int c = 0; c < cave[0].length; ++c) {
            if (cave[r][c]) {
                ++smash;
            }

            if (smash > min) {
                break;
            }
        }

        if (smash < min) {
            min = smash;
            map.put(min, 1);
        } else {
            int count = map.getOrDefault(smash, 0) + 1;
            map.put(smash, count);
        }
    }

    public static void makeCave(boolean[][] cave, boolean even, int len, int c) {
        int rowStart = even ? cave.length - len : 0;
        int rowEnd = rowStart + len;
        for (int r = rowStart; r < rowEnd; ++r) {
            cave[r][c] = true;
        }
    }
}
