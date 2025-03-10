package study.Y2025.M03.D10;

import java.util.*;
import java.io.*;

public class B11723 {
    public static void main(String[] args) throws IOException {
        controlSet();
    }

    public static void controlSet() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        final int SIZE = 20;
        final int ORDER = Integer.parseInt(br.readLine().trim());
        boolean[] targetSet = new boolean[SIZE + 1];

        for (int i = 0; i < ORDER; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            String order = st.nextToken();

            if (order.equals("all")) {
                Arrays.fill(targetSet, true);
            } else if (order.equals("empty")) {
                Arrays.fill(targetSet, false);
            } else {
                int element = Integer.parseInt(st.nextToken());
                if (order.equals("add")) {
                    targetSet[element] = true;
                } else if (order.equals("remove")) {
                    targetSet[element] = false;
                } else if (order.equals("check")) {
                    sb.append(targetSet[element] ? 1 : 0).append("\n");
                } else { // order.equals("toggle")
                    targetSet[element] = !targetSet[element];
                }
            }
        }

        System.out.println(sb.toString());
    }
}
