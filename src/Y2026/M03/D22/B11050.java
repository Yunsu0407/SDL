package Y2026.M03.D22;

import java.util.*;
import java.io.*;

public class B11050 {
    public static void main(String[] args) throws IOException {
        binomialCoefficient();
    }

    public static void binomialCoefficient() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int ans = 1;
        for (int i = 0; i < k; ++i) {
            ans = ans * (n - i) / (i + 1);
        }
        System.out.println(ans);
    }
}
