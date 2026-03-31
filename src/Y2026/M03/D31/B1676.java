package Y2026.M03.D31;

import java.util.*;
import java.io.*;

public class B1676 {
    public static void main(String[] args) throws IOException {
        facZero();
    }

    public static void facZero() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int cnt2 = 0;
        int cnt5 = 0;

        for (int i = 2; i < n + 1; ++i) {
            if (i % 2 == 0) {
                int curr = i;
                int div = 2;
                while (curr > 0 && curr % div == 0) {
                    cnt2 = cnt2 + 1;
                    curr = curr / div;
                }
            }

            if (i % 5 == 0) {
                int curr = i;
                int div = 5;
                while (curr > 0 && curr % div == 0) {
                    cnt5 = cnt5 + 1;
                    curr = curr / div;
                }
            }
        }

        int ans = Math.min(cnt2, cnt5);

        System.out.println(ans);
    }
}
