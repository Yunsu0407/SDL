package study.Y2025.M05.D12;

import java.util.*;
import java.io.*;

public class B28075 {
    public static void main(String[] args) throws IOException {
        spying();
    }

    public static void spying() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] src = new int[2][3];

        // 1. 근무일과 제한 점수 수령
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int day = Integer.parseInt(st.nextToken());
        int limit = Integer.parseInt(st.nextToken());

        // 2. 진척도 수령
        for (int row = 0; row < src.length; ++row) {
            st = new StringTokenizer(br.readLine().trim());

            for (int col = 0; col < src[0].length; ++col) {
                int value = Integer.parseInt(st.nextToken());
                src[row][col] = value;
            }
        }

        // 3. 재귀적으로 누적합 계산
        for (int row = 0; row < src.length; ++row) {
            for (int col = 0; col < src[0].length; ++col) {
                recursive(src, day - 1, col, src[row][col], limit);
            }
        }

        // 4. 정답 출력
        System.out.println(ans);
    }

    public static int ans = 0;

    public static void recursive(int[][] src, int day, int prevIdx, int prevSum, int limit) {
        if (day > 0) {
            for (int row = 0; row < src.length; ++row) {
                for (int col = 0; col < src[0].length; ++col) {
                    int value = src[row][col];
                    if (prevIdx == col) {
                        value = value / 2;
                    }
                    recursive(src, day - 1, col, prevSum + value, limit);
                }
            }
        } else {
            if (prevSum >= limit) {
                ++ans;
            }
        }
    }
}
