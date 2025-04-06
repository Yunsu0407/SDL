package study.Y2025.M04.D06;

import java.util.*;
import java.io.*;

public class B1764_2 {
    public static void main(String[] args) throws IOException {
        findCommon();
    }

    public static String input1 = "3 4\n" +
            "ohhenrie\n" +
            "charlie\n" +
            "baesangwook\n" +
            "obama\n" +
            "baesangwook\n" +
            "ohhenrie\n" +
            "clinton";

    public static void findCommon() throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader(input1));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int sizeOfUnheard = Integer.parseInt(st.nextToken());
        int sizeOfUnseen = Integer.parseInt(st.nextToken());

        Set<String> unheard = new TreeSet<>();
        Set<String> unseen = new TreeSet<>();

        for (int i = 0; i < sizeOfUnheard; ++i) {
            unheard.add(br.readLine().trim());
        }

        for (int i = 0; i < sizeOfUnseen; ++i) {
            unseen.add(br.readLine().trim());
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (String curr : unheard) {
            if (unseen.contains(curr)) {
                ++count;
                sb.append(curr).append("\n");
            }
        }

        System.out.println(count);
        System.out.println(sb.toString());
    }

}
