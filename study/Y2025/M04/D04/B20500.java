package study.Y2025.M04.D04;

import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class B20500 {
    public static void main(String[] args) throws IOException {
        countMultiple();
    }

    public static void countMultiple() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int limit = Integer.parseInt(br.readLine().trim());
        BigInteger mod = BigInteger.valueOf(1_000_000_007); // 10억7

        BigInteger count = BigInteger.ZERO;
        BigInteger[] factorial = new BigInteger[limit];

        factorial[0] = BigInteger.ONE;
        for (int i = 1; i < limit; ++i) {
            factorial[i] = factorial[i - 1].multiply((BigInteger.valueOf(i)));
        }

        int n = limit - 1; // limit = 3, n = 2
        for (int r = 0; r < limit; ++r) { // r = 0 ~ 2
            int value = r + 5 * (n - r) + 5;
            if(value % 3 == 0){
                count = count.add(getDelta(factorial, n, r));
            }
        }

        count = count.mod(mod);
        System.out.println(count);
    }

    public static BigInteger getDelta(BigInteger[] factorial, int n, int r){
        return factorial[n].divide(factorial[r].multiply(factorial[n-r]));
    }
}
