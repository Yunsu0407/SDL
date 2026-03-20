package Y2026.M03.D20;

import java.util.*;
import java.io.*;

public class B15829 {
    public static void main(String[] args) throws IOException {
        hashing();
    }

    public static void hashing() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine().trim());
        String str = br.readLine().trim();

        int r = 31;
        int M = 1234567891;
        long mul = 1;
        long hashed = 0;

        for (int i = 0; i < size; ++i) {
            long curr = str.charAt(i) - 'a' + 1;
            curr = (curr * mul) % M;
            hashed = (hashed + curr) % M;
            mul = (mul * r) % M;
        }

        System.out.println(hashed);
    }
}
