package study.Y2025.M03.D06;

import java.util.*;
import java.io.*;

public class B11478 {
    public static void main(String[] args) throws IOException {
        diffString();
    }

    public static String input1 = "ababc"; // ans: 12

    public static void diffString() throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader(input1));

        String str = br.readLine().trim();
        int checkSize = str.length();

        Set<String> diffSet = new HashSet<>();
        while (checkSize > 0) {
            for (int i = 0; i < str.length() + 1 - checkSize; ++i) {
                String sub = str.substring(i, i + checkSize);
                diffSet.add(sub);
            }

            --checkSize;
        }

        System.out.println(diffSet.size());
    }
}
