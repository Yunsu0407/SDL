package Y2026.M04.D21;

import java.util.*;
import java.io.*;

public class B11047 {
    public static void main(String[] args) throws IOException {
        coinZero();
    }

    public static String input1 = "10 4200\r\n" + //
            "1\r\n" + //
            "5\r\n" + //
            "10\r\n" + //
            "50\r\n" + //
            "100\r\n" + //
            "500\r\n" + //
            "1000\r\n" + //
            "5000\r\n" + //
            "10000\r\n" + //
            "50000"; // 6

    public static void coinZero() throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader(input1));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> price = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            int val = Integer.parseInt(br.readLine().trim());
            price.add(val);
        }

        price.sort(Collections.reverseOrder());

        for (int curr : price) {

        }
    }
}
