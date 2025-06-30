package study.Y2025.M06.D30;

import java.util.*;
import java.io.*;

public class B2217 {
    public static void main(String[] args) throws IOException {
        lope();
    }

    public static void lope() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine().trim());
        List<Integer> al = new ArrayList<>();

        for (int i = 0; i < size; ++i) {
            al.add(Integer.parseInt(br.readLine().trim()));
        }
        al.sort(Collections.reverseOrder());

        int max = 0;
        for (int i = 0; i < size; ++i) {
            int curr = al.get(i);
            curr = curr * (i + 1);
            max = Math.max(max, curr);
        }

        System.out.println(max);
    }
}
