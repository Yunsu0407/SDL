package Y2026.M03.D18;

import java.util.*;
import java.io.*;

public class B2920 {
    public static void main(String[] args) throws IOException {
        scale();
    }

    public static void scale() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int n1 = Integer.parseInt(st.nextToken());
        boolean isMix = n1 == 1 || n1 == 8 ? false : true;
        boolean isAsc = n1 == 1;
        int weight = isAsc ? 1 : -1;

        if (!isMix) {
            while (st.hasMoreTokens()) {
                int n2 = Integer.parseInt(st.nextToken());

                if (n2 != n1 + weight) {
                    isMix = true;
                    break;
                }

                n1 = n2;
            }
        }

        String ans = isMix ? "mixed" : (isAsc ? "ascending" : "descending");
        System.out.println(ans);
    }
}
