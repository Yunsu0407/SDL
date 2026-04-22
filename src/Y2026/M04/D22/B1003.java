package Y2026.M04.D22;

import java.util.*;
import java.io.*;

public class B1003 {
    public static void main(String[] args) throws IOException {
        fibFunc();
    }

    public static void fibFunc() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine().trim());
        int[][] fib = new int[41][2];
        fib[0][0] = 1;
        fib[0][1] = 0;
        fib[1][0] = 0;
        fib[1][1] = 1;

        for (int i = 2; i < fib.length; ++i) {
            fib[i][0] = fib[i - 2][0] + fib[i - 1][0];
            fib[i][1] = fib[i - 2][1] + fib[i - 1][1];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; ++i) {
            int curr = Integer.parseInt(br.readLine().trim());
            sb.append(fib[curr][0]).append(" ").append(fib[curr][1]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
