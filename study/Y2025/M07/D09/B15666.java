package study.Y2025.M07.D09;

import java.util.*;
import java.io.*;

public class B15666 {
    public static void main(String[] args) throws IOException {
        NandM();
    }

    public static void NandM() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int size = Integer.parseInt(st.nextToken());
        int limit = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < size; ++i) {
            numSet.add(Integer.parseInt(st.nextToken()));
        }

        for (int curr : numSet) {
            recursive(new StringBuilder(), curr, limit - 1);
        }

        StringBuilder ans = new StringBuilder();
        for (String curr : ansSet) {
            ans.append(curr).append("\n");
        }

        System.out.print(ans);
    }

    public static Set<Integer> numSet = new TreeSet<>();
    public static Set<String> ansSet = new LinkedHashSet<>();

    public static void recursive(StringBuilder sb, int prev, int limit) {
        sb.append(prev).append(" ");

        if (limit > 0) {
            for (int curr : numSet) {
                if (curr >= prev) {
                    recursive(new StringBuilder(sb), curr, limit - 1);
                }
            }
        } else {
            ansSet.add(sb.toString());
        }
    }
}
