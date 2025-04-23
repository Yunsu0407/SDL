package study.Y2025.M04.D23;

import java.util.*;
import java.io.*;

public class B1929 {
    public static void main(String[] args) throws IOException {
        getPrime();
    }

    public static void getPrime() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int lowBound = Integer.parseInt(st.nextToken());
        int highBound = Integer.parseInt(st.nextToken());
        boolean[] isPrime = new boolean[highBound + 1];

        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i <= highBound; ++i) {
            if (isPrime[i]) {
                int cycle = highBound / i;

                for (int j = 2; j <= cycle; ++j) {
                    isPrime[i * j] = false;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = lowBound; i <= highBound; ++i) {
            if (isPrime[i]) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}
