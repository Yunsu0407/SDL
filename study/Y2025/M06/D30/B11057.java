package study.Y2025.M06.D30;

import java.util.*;
import java.io.*;

public class B11057 {
    public static void main(String[] args) throws IOException {
        ascendingNumber();
    }

    public static void ascendingNumber() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine().trim());
        Map<String, Integer> dp = new HashMap<>();

        for (int i = 0; i <= 9; ++i) {
            dp.put(String.valueOf(i), 1);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(0);
        for (int j = 0; j < count; ++j) {
            sb.append("X");
        }

        int ans = getValue(dp, sb.toString());

        System.out.println(ans);
    }

    public static int getValue(Map<String, Integer> dp, String target) {
        int ans;
        if (dp.containsKey(target)) {
            ans = dp.get(target);
        } else {
            int total = 0;
            int start = target.charAt(0) - '0';
            String sub = target.substring(2);
            for (int i = start; i <= 9; ++i) {
                StringBuilder sb = new StringBuilder();
                sb.append(i).append(sub);
                total = (total + getValue(dp, sb.toString())) % 10007;
            }
            dp.put(target, total);
            ans = total;
        }

        return ans;
    }
}
