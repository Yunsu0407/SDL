package Y2026.M03.D20;

import java.util.*;
import java.io.*;

public class B2292 {
    public static void main(String[] args) throws IOException {
        hive();
    }

    public static void hive() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine().trim());
        int count = 0;
        int coef = 6; // coefficient
        int vari = 1; // variable
        int acc = 1;

        while (target > 0) {
            target = target - acc;
            acc = coef * vari;
            vari = vari + 1;
            count = count + 1;
        }

        System.out.println(count);
    }
}
