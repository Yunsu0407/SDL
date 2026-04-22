package Y2026.M04.D21;

import java.util.*;
import java.io.*;

public class B11047 {
    public static void main(String[] args) throws IOException {
        coinZero();
    }

    public static void coinZero() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> price = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            int curr = Integer.parseInt(br.readLine().trim());
            price.add(curr);
        }

        int accCnt = 0;
        int idx = price.size() - 1;
        while (k > 0 && idx > -1) {
            int curr = price.get(idx);

            if (k >= curr) {
                int cnt = k / curr;
                k = k - cnt * curr;
                accCnt = accCnt + cnt;
            }

            idx = idx - 1;
        }

        System.out.println(accCnt);
    }
}
