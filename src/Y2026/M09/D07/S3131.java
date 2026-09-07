package Y2026.M09.D07;

import java.util.*;

public class S3131 {
    public static void main(String[] args) {
        primeNumber();
    }

    public static void primeNumber() {
        int range = (int) Math.pow(10, 6) + 1;
        boolean[] isPrime = new boolean[range];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < range; ++i) {
            if (isPrime[i]) {
                sb.append(i).append(" ");

                int idx = i + i;
                while (idx < range) {
                    isPrime[idx] = false;
                    idx = idx + i;
                }
            }
        }

        System.out.print(sb.toString());
    }
}
