package Y2026.M03.D23;

import java.util.*;
import java.io.*;

public class B1181 {
    public static void main(String[] args) throws IOException {
        arrangeWord();
    }

    public static void arrangeWord() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine().trim());
        Set<String> ts = new TreeSet<>(
                Comparator.comparing((String s) -> s.length())
                        .thenComparing(s -> s));

        for (int i = 0; i < size; ++i) {
            String str = br.readLine().trim();
            ts.add(str);
        }

        StringBuilder sb = new StringBuilder();
        for (String str : ts) {
            sb.append(str).append("\n");
        }

        System.out.println(sb.toString());
    }
}
