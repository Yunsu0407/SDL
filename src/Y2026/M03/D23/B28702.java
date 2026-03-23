package Y2026.M03.D23;

import java.util.*;
import java.io.*;

public class B28702 {
    public static void main(String[] args) throws IOException {
        guessWhat();
    }

    public static void guessWhat() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] vals = new String[3];

        for (int i = 0; i < vals.length; ++i) {
            vals[i] = br.readLine().trim();
        }

        final String F = "Fizz";
        final String B = "Buzz";
        final String FB = "FizzBuzz";

        String ans;
        if (vals[0].equals(F)) {
            if (vals[1].equals(B)) {
                ans = judge(vals[2], 1);
            } else {
                ans = judge(vals[1], 2);
            }
        } else if (vals[0].equals(B)) {
            if (vals[1].equals(F)) {
                ans = judge(vals[2], 1);
            } else {
                ans = judge(vals[1], 2);
            }
        } else if (vals[0].equals(FB)) {
            ans = judge(vals[1], 2);
        } else { // vals[0] == i
            ans = judge(vals[0], 3);
        }

        System.out.println(ans);
    }

    public static String judge(String target, int weight) {
        int val = Integer.parseInt(target) + weight;
        String ret;
        if (val % 3 == 0 && val % 5 == 0) {
            ret = "FizzBuzz";
        } else if (val % 3 == 0) {
            ret = "Fizz";
        } else if (val % 5 == 0) {
            ret = "Buzz";
        } else {
            ret = String.valueOf(val);
        }
        return ret;
    }
}
