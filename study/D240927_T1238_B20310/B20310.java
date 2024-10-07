package study.D240927_T1238_B20310;

import java.io.*;
import java.util.*;

public class B20310 {
    public static void main(String[] args) throws IOException {
        decreasing();
    }

    public static void decreasing() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String origin = br.readLine().trim();
        br.close();
        int zero = 0;
        int one = 0;
        int[] state = new int[origin.length()];
        for (int i = 0; i < origin.length(); ++i) {
            if (origin.charAt(i) == '0') {
                state[i] = 0;
                ++zero;
            } else {
                ++one;
                state[i] = 1;
            }
        }

        zero = zero / 2;
        one = one / 2;
        int index = 0;
        while (one > 0) {
            if (state[index] == 1) {
                state[index] = 2;
                --one;
            }
            ++index;
        }
        index = state.length - 1;
        while (zero > 0) {
            if (state[index] == 0) {
                state[index] = 2;
                --zero;
            }
            --index;
        }

        StringBuilder sb = new StringBuilder();
        for (int curr : state) {
            if (curr != 2) {
                sb.append(curr);
            }
        }

        System.out.print(sb.toString());
    }
}

