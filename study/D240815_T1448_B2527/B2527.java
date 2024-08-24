package D240815_T1448_B2527;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2527 {
    public static void main(String[] args) throws IOException {
        judgeArea();
    }

    public static void judgeArea() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int CASE = 4;
        final int SIZE = 4;
        int[][] rectA = new int[CASE][SIZE];
        int[][] rectB = new int[CASE][SIZE];

        for (int i = 0; i < CASE; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            for (int j = 0; j < SIZE * 2; ++j) {
                if (j < SIZE) {
                    rectA[i][j] = Integer.parseInt(st.nextToken());
                } else {
                    rectB[i][j - SIZE] = Integer.parseInt(st.nextToken());
                }
            }
        }

        System.out.printf("%s", makeJudgement(rectA, rectB, CASE));
    }

    public static String makeJudgement(int[][] rectA, int[][] rectB, int CASE) {
        final String RECT = "a";
        final String LINE = "b";
        final String DOT = "c";
        final String NONE = "d";
        final int X1 = 0;
        final int Y1 = 1;
        final int X2 = 2;
        final int Y2 = 3;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < CASE; ++i) {
            if (rectB[i][Y1] > rectA[i][Y2] || rectB[i][Y2] < rectA[i][Y1]) {
                sb.append(String.format("%s\n", NONE));
            } else if (rectB[i][Y1] == rectA[i][Y2] || rectB[i][Y2] == rectA[i][Y1]) {
                if (rectB[i][X1] > rectA[i][X2] || rectB[i][X2] < rectA[i][X1]) {
                    sb.append(String.format("%s\n", NONE));
                } else if (rectB[i][X1] == rectA[i][X2] || rectB[i][X2] == rectA[i][X1]) {
                    sb.append(String.format("%s\n", DOT));
                } else {
                    sb.append(String.format("%s\n", LINE));
                }
            } else {
                if (rectB[i][X1] > rectA[i][X2] || rectB[i][X2] < rectA[i][X1]) {
                    sb.append(String.format("%s\n", NONE));
                } else if (rectB[i][X1] == rectA[i][X2] || rectB[i][X2] == rectA[i][X1]) {
                    sb.append(String.format("%s\n", LINE));
                } else {
                    sb.append(String.format("%s\n", RECT));
                }
            }
        }

        return sb.toString();
    }
}
