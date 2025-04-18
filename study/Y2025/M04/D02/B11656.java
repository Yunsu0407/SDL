package study.Y2025.M04.D02;

import java.util.*;
import java.io.*;

public class B11656 {
    public static void main(String[] args) throws IOException {
        orderPrefix();
    }

    public static void orderPrefix() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(getPrefix(br.readLine().trim()));
    }

    public static String getPrefix(String str) {
        List<String> prefix = new ArrayList<>();
        for (int i = 0; i < str.length(); ++i) {
            prefix.add(str.substring(i));
        }
        Collections.sort(prefix);

        StringBuilder sb = new StringBuilder();
        for (String curr : prefix) {
            sb.append(curr).append("\n");
        }

        return sb.toString();
    }
}
