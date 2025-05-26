package study.Y2025.M05.D19;

import java.util.*;
import java.io.*;

public class B1002 {
    public static void main(String[] args) throws IOException {
        findTarget();
    }

    public static String input1 = "3\n" +
            "0 0 13 40 0 37\n" +
            "0 0 3 0 7 4\n" +
            "1 1 1 1 1 5";
    // ans = 2 1 0

    public static String input2 = "1\n" +
            "0 -1 8 7 -9 7\n";
    // ans = 2

    public static String input3 = "2\n" +
            "1 1 6 1 1 3\n" +
            "0 6 4 -7 -1 4";

    public static void findTarget() throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader(input3));

        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < testcase; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int[][] turret = new int[2][3]; // x, y, r

            // 1. 터렛의 정보 수령
            receiveData(st, turret);

            // 2. 터렛 사이의 접점 검사
            int ans = checkRange(turret);

            // 3. 정답 기록
            sb.append(ans).append("\n");
        }

        // 4. 정답 출력
        System.out.println(sb.toString());
    }

    // 1. 터렛의 정보 수령
    public static void receiveData(StringTokenizer st, int[][] turret) {
        for (int j = 0; j < turret.length; ++j) {
            for (int k = 0; k < turret[0].length; ++k) {
                turret[j][k] = Integer.parseInt(st.nextToken());
            }
        }
    }

    // 2. 터렛 사이의 접점 검사
    public static int checkRange(int[][] turret) {
        final int T1 = 0, T2 = 1, X = 0, Y = 1, R = 2;
        int ans;
        double d = Math.pow((double) (turret[0][X] - turret[1][X]), 2) + Math.pow((double) (turret[0][Y] - turret[1][Y]), 2);
        int r1 = turret[T1][R], r2 = turret[T2][R];
        double dss = Math.pow(r1 + r2, d);

        if (r1 == r2) {
            if (d == 0) {
                ans = -1;
            } else {
                if (dss < d) {
                    ans = 2;
                } else if (dss == d) {
                    ans = 1;
                } else {
                    ans = 0;
                }
            }

        } else {
            if (d > dss) {
                ans = 0;
            } else if (d == dss) {
                ans = 1;
            } else {
                double diff = Math.abs(r1 - r2);
                if (diff < d) {
                    ans = 2;
                } else if (diff == d) {
                    ans = 1;
                } else {
                    ans = 0;
                }
            }
        }

        return ans;
    }
}
