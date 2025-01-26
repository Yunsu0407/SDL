package Y2025.M01.D26;

import java.util.*;
import java.io.*;

public class B20115 {
    public static void main(String[] args) throws IOException {
        combineEnergyDrink();
    }

    public static String input1 = "5\n" +
            "3 2 10 9 6";
    public static String input2 = "10\n" +
            "100 9 77 65 39 27 45 1 80 495";

    public static void combineEnergyDrink() throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader(input1));
        int size = Integer.parseInt(br.readLine().trim()); // 2 <= size <= 10^(5)
        double total = 0;
        int max = 0;

        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < size; ++i) {
            int liquid = Integer.parseInt(st.nextToken()); // 1 <= liquid <= 1,000,000,000 (10억)
            if (liquid > max) {
                total = total + max / 2.0;
                max = liquid;
            } else {
                total = total + liquid / 2.0;
            }
        }

        double ans = total + max;
        System.out.println(ans);
    }
}
