package Y2026.M03.D20;

import java.util.*;
import java.io.*;

public class B1978 {
    public static void main(String[] args) throws IOException {
        findPrime();
    }

    public static void findPrime() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] isPrime = new boolean[1001];

        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 0; i < isPrime.length; ++i) {
            if (isPrime[i]) {
                int idx;
                int mul = 2; // mul = multiplier

                while (true) {
                    idx = i * mul;
                    if (idx >= isPrime.length) {
                        break;
                    }

                    isPrime[idx] = false;
                    mul = mul + 1;
                }
            }
        }

        int size = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int primeCnt = 0;
        for (int i = 0; i < size; ++i) {
            int curr = Integer.parseInt(st.nextToken());
            if (isPrime[curr]) {
                primeCnt = primeCnt + 1;
            }
        }

        System.out.println(primeCnt);
    }
}
