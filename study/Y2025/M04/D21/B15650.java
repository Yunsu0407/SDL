package study.Y2025.M04.D21;

import java.util.*;
import java.io.*;

public class B15650 {
    public static void main(String[] args) throws IOException {
        makeSeries();
    }

    public static void makeSeries() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int limit = Integer.parseInt(st.nextToken()); // 1 ~ 8
        int size = Integer.parseInt(st.nextToken()); // 1 ~ 8

        for (int i = 1; i <= limit; ++i) { // 1부터 limit 까지
            StringBuilder sb = new StringBuilder();
            sb.append(i).append(" ");
            recursivelyMakeSeries(sb, size - 1, i, limit);
        }

        System.out.println(ans.toString());
    }

    public static StringBuilder ans = new StringBuilder();

    public static void recursivelyMakeSeries(StringBuilder prev, int count, int value, int limit) {
        if (count > 0) {
            for (int i = value + 1; i <= limit; ++i) {
                StringBuilder sb = new StringBuilder(prev);
                sb.append(i).append(" ");
                recursivelyMakeSeries(sb, count - 1, i, limit);
            }
        } else {
            ans.append(prev).append("\n");
        }
    }
}
