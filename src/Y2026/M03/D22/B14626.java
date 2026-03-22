package Y2026.M03.D22;

import java.util.*;
import java.io.*;

public class B14626 {
    public static void main(String[] args) throws IOException {
        handleISBN();
    }

    public static void handleISBN() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String serial = br.readLine().trim();

        int sum = 0;
        int idx = 0;
        for (int i = 0; i < serial.length() - 1; ++i) {
            char c = serial.charAt(i);

            if (c == '*') {
                idx = i;
            } else {
                int curr = c - '0';
                if (i % 2 == 0) {
                    sum = sum + curr;
                } else {
                    sum = sum + curr * 3;
                }
            }
        }

        int m = serial.charAt(serial.length() - 1) - '0';
        int mul = idx % 2 == 0 ? 1 : 3;
        int ruinRes = 10 - (sum + m) % 10;
        int ruin = -1;

        if (ruinRes == 10) {
            ruin = 0;
        } else {
            for (int i = 0; i < 10; ++i) {
                int curr = mul * i;
                if (curr % 10 == ruinRes) {
                    ruin = i;
                    break;
                }
            }
        }

        System.out.println(ruin);
    }
}
