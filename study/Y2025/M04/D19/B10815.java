package study.Y2025.M04.D19;

import java.util.*;
import java.io.*;

public class B10815 {
    public static void main(String[] args) throws IOException {
        numberCard();
    }

    public static void numberCard() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> srcSet = new HashSet<>();
        int srcSize = Integer.parseInt(br.readLine().trim());

        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < srcSize; ++i) {
            int currNum = Integer.parseInt(st.nextToken());

            srcSet.add(currNum);
        }

        int askSize = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine().trim());
        for(int i = 0; i < askSize; ++i) {
            int askNum = Integer.parseInt(st.nextToken());

            if(srcSet.contains(askNum)){
                sb.append(1).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }

        System.out.println(sb.toString());
    }
}
