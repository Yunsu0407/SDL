package Y2026.M03.D31;

import java.util.*;
import java.io.*;

public class B2751 {
    public static void main(String[] args) throws IOException {
        arrangeNumbers();
    }

    public static void arrangeNumbers() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine().trim());
        Set<Integer> ts = new TreeSet<>();

        for (int i = 0; i < size; ++i) {
            int curr = Integer.parseInt(br.readLine().trim());
            ts.add(curr);
        }

        StringBuilder sb = new StringBuilder();
        for (int curr : ts) {
            sb.append(curr).append("\n");
        }

        System.out.println(sb.toString());
    }
}
