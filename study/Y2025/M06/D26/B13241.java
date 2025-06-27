package study.Y2025.M06.D26;

import java.util.*;
import java.io.*;

public class B13241 {
    public static void main(String[] args) throws IOException {
        getLCM();
    }

    public static String input1 = "95003516 981111\n"; // 93208994586276

    // LCM = Lowest Common Multiple, 최소공배수
    public static void getLCM() throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader(input1));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int val1 = Integer.parseInt(st.nextToken());
        int val2 = Integer.parseInt(st.nextToken());
        int N = Math.max(val1, val2);
        boolean[] isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);

        for (int i = 2; i * i <= N; ++i) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j = j + i) {
                    isPrime[j] = false;
                }
            }
        }

        Map<Integer, Integer> factor = new HashMap<>();
        setFactor(isPrime, val1, factor);
        setFactor(isPrime, val2, factor);

        long ans = 1;
        for (Map.Entry<Integer, Integer> entry : factor.entrySet()) {
            ans = ans * (long) Math.pow(entry.getKey(), entry.getValue());
        }
        System.out.println(ans);
    }

    public static void setFactor(boolean[] isPrime, long val, Map<Integer, Integer> factor) {
        int value = (int) val;
        for (int i = 2; i <= value; ++i) {
            if (!isPrime[i]) continue;

            int count = 0;
            while (value % i == 0) {
                value = value / i;
                ++count;
            }

            if (count > 0) {
                count = Math.max(count, factor.getOrDefault(i, 0));
                factor.put(i, count);
            }
        }
    }
}
