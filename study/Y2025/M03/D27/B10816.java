package study.Y2025.M03.D27;

import java.util.*;
import java.io.*;

public class B10816 {
    public static void main(String[] args) throws IOException {
        numberCard2();
    }

    public static void numberCard2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int source = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        Map<Integer, Integer> srcMap = new HashMap<>();
        for (int i = 0; i < source; ++i) {
            int card = Integer.parseInt(st.nextToken());
            if (srcMap.containsKey(card)) {
                int count = srcMap.get(card);
                srcMap.replace(card, count + 1);
            } else {
                srcMap.put(card, 1);
            }
        }

        int target = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < target; ++i) {
            int integer = Integer.parseInt(st.nextToken());
            if(srcMap.containsKey(integer)){
                sb.append(srcMap.get(integer)).append(" ");
            } else {
                sb.append("0 ");
            }
        }

        System.out.println(sb.toString());
    }
}
