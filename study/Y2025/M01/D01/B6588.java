package Y2025.M01.D01;

import java.util.*;
import java.io.*;

public class B6588 {
    public static void main(String[] args) throws IOException {
        solveGuess();
    }

    public static String example = "8\n20\n42\n0";
    public static String example1 = "6\n0";

    public static void solveGuess() throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader(example1));
        final int LIMIT = 1000001;
        boolean[] primes = new boolean[LIMIT];

        Arrays.fill(primes, true);
        primes[0] = primes[1] = false;
        for (int i = 2; i * i < LIMIT; ++i) {
            if (primes[i]) {
                for (int j = i * i; j < LIMIT; j = j + i) {
                    primes[j] = false;
                }
            }
        } // 에라토스테네스의 체로 소수를 구함

        StringBuilder sb = new StringBuilder();

        while (true) {
            int target = Integer.parseInt(br.readLine().trim());
            if (target == 0) {
                break;
            } // 0이면 종료

            boolean wrong = true;
            for (int i = 3; i <= target / 2; i = i + 2) {
                int rest = target - i;
                if(primes[i] && primes[rest]){
                    sb.append(String.format("%d = %d + %d\n", target, i, rest));
                    wrong = false;
                    break;
                }
            }
            if(wrong){
                sb.append("Goldbach's conjecture is wrong.\n");
            }
        }

        System.out.println(sb.toString());
    }
}
