package Y2026.M04.D22;

import java.util.*;
import java.io.*;

public class B1463 {
    public static void main(String[] args) throws IOException {
        makeOne();
    }

    public static void makeOne() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine().trim());
        recursive(x, 0);
        System.out.println(min);
    }

    public static int min = Integer.MAX_VALUE;

    public static void recursive(int x, int acc) {
        if (x == 1) {
            min = Math.min(min, acc);
        } else {
            if (acc < min) {
                if (x % 3 == 0) {
                    recursive(x / 3, acc + 1);
                }
                if (x % 2 == 0) {
                    recursive(x / 2, acc + 1);
                }
                recursive(x - 1, acc + 1);
            }
        }
    }
}
