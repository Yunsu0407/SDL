package study.Y2025.M07.D24;

import java.util.*;
import java.io.*;

public class B2011 {
    public static void main(String[] args) throws IOException {
        secretCode();
    }

    public static String input1 = "25114"; // 6
    public static String input2 = "1111111111"; // 89
    public static String input3 = "0"; // 0

    // A=1, B=2, ... , Z=26
    public static void secretCode() throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader(input3));
        String str = br.readLine().trim();

        recursive(str, 0);

        System.out.print(count);
    }

    public static final int DIV = 1_000_000;

    public static int count = 0;

    public static void recursive(String str, int startIdx) {
        int restIdx = str.length() - startIdx;
        if (restIdx == 0) {
            count = (count + 1) % DIV;
        } else {
            int lastIdx;

            if (restIdx > 1) {
                lastIdx = startIdx + 2;
                if (isPossible(str, startIdx, lastIdx)) {
                    recursive(str, lastIdx);
                }
            }
            if (restIdx > 0) {
                lastIdx = startIdx + 1;
                if (isPossible(str, startIdx, lastIdx)) {
                    recursive(str, lastIdx);
                }
            }
        }
    }

    public static boolean isPossible(String str, int startIdx, int lastIdx) {
        String sub = str.substring(startIdx, lastIdx);
        int target = Integer.parseInt(sub);
        return target > 0 && target < 27;
    }
}
