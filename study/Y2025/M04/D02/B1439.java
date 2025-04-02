package study.Y2025.M04.D02;

import java.util.*;
import java.io.*;

public class B1439 {
    public static void main(String[] args) throws IOException {
        upsetString();
    }

    public static void upsetString() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().trim();
        System.out.println(getMin(str));
    }

    public static int getMin(String str) {
        int[] count = new int[2];
        char prev = str.charAt(0);
        ++count[prev - '0'];

        for (int i = 1; i < str.length(); ++i) {
            char curr = str.charAt(i);
            if (curr != prev) {
                ++count[curr - '0'];
            }
            prev = curr;
        }

        return Math.min(count[0], count[1]);
    }
}
