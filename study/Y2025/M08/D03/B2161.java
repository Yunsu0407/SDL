package study.Y2025.M08.D03;

import java.util.*;
import java.io.*;

public class B2161 {
    public static void main(String[] args) throws IOException {
        cardOne();
    }

    public static void cardOne() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine().trim());
        List<Integer> list = new LinkedList<>();

        for (int i = 0; i < size; ++i) {
            list.add(i + 1);
        }

        StringBuilder sb = new StringBuilder();
        boolean discard = true;
        while(!list.isEmpty()) {
            int card = list.remove(0);

            if(discard) {
                discard = false;
                sb.append(card).append(" ");
            } else {
                discard = true;
                list.add(card);
            }
        }

        System.out.println(sb.toString());
    }
}
