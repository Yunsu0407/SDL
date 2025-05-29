package study.Y2025.M05.D26;

import java.util.*;
import java.io.*;

public class B5397 {
    public static void main(String[] args) throws IOException {
        keyLogger();
    }

    public static String input1 = "2\n" +
            "<<BP<A>>Cd-\n" +
            "ThIsIsS3Cr3t";
    // BAPC
    // ThIsIsS3Cr3t

    public static void keyLogger() throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader(input1));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; ++i) {
            String input = br.readLine().trim();
        }

        System.out.print(sb.toString());
    }
}
