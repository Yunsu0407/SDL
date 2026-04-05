package D05;

import java.util.*;
import java.io.*;

public class B11650 {
    public static void main(String[] args) throws IOException {
        arrageCoord();
    }

    public static void arrageCoord() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine().trim());

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < size; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new int[] { x, y });
        }

        list.sort(
                Comparator.comparingInt((int[] i) -> i[0])
                        .thenComparingInt(i -> i[1]));

        StringBuilder sb = new StringBuilder();
        for (int[] curr : list) {
            sb.append(curr[0]).append(" ").append(curr[1]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
