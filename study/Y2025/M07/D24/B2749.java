package study.Y2025.M07.D24;

import java.util.*;
import java.io.*;

public class B2749 {
    public static void main(String[] args) throws IOException {
        fibonacci3();
    }

    public static final int DIV = 1000000;

    public static void fibonacci3() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long end = Long.parseLong(br.readLine().trim());
        List<Integer> fib = new ArrayList<>();

        int pisanoPeriod = getPisanoPeriod(fib);

        int targetIdx = (int)(end % pisanoPeriod);
        int ans = fib.get(targetIdx);

        System.out.print(ans);
    }

    // 피보나치 수열의 합과 피사노 주기를 구하는 함수
    public static int getPisanoPeriod(List<Integer> fib) {
        int first = 0, second = 1;
        int period = 1;

        fib.add(first);
        fib.add(second);

        while(true) {
            int temp = second;
            second = (second + first) % DIV;
            first = temp;

            fib.add(second);
            ++period;

            if(first == 0 && second == 1) {
                break;
            }
        }

        return period - 1;
    }
}
