package Y2026.M03.D13;

import java.util.*;
import java.io.*;

public class B2475 {
    public static void main(String[] args) throws IOException {
        verifiedNumber();
    }

    public static void verifiedNumber() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        int sum = 0;
        while(st.hasMoreTokens()) {
            int digit = Integer.parseInt(st.nextToken());
            sum = sum + (int)Math.pow(digit, 2.0);
        }

        sum = sum % 10;

        System.out.println(sum);
    }
}
