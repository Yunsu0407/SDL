package study.Y2024.M09.D240903_T1605_B2839;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2839 {
    public static void main(String[] args) throws IOException {
        deliverSugar();
    }

    public static void deliverSugar() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine().trim());
        br.close();
        int ans = calculating(N);
        System.out.println(ans);
    }

    // N = 3^(i) + 5^(j)
    public static int calculating(int N) {
        final int THREE = 3;
        final int FIVE = 5;
        int limitT = N / THREE;
        int limitF = N / FIVE;
        int min = Integer.MAX_VALUE;
        int quotient;
        boolean possibility = false;

        if (N % THREE == 0) {
            possibility = true;
            quotient = N / THREE;
            if (min > quotient) {
                min = quotient;
            }
        }

        if (N % FIVE == 0) {
            possibility = true;
            quotient = N / FIVE;
            if (min > quotient) {
                min = quotient;
            }
        }

        for (int i = 0; i < limitT; ++i) {
            for (int j = 0; j < limitF; ++j) {
                int comp = THREE * (i + 1) + FIVE * (j + 1);
                if (N == comp) {
                    possibility = true;
                    if (min > i + j + 2) {
                        min = i + j + 2;
                    }
                }
            }
        }

        if (!possibility) {
            min = -1;
        }

        return min;
    }
}
