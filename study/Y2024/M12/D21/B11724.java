package study.Y2024.M12.D21;

import java.util.*;
import java.io.*;

public class B11724 {
    public static void main(String[] args) throws IOException {
        countConnection();
    }

    public static int node, edge;
    public static boolean[][] relation;
    public static boolean[] visit;

    public static void countConnection() throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader("6 5\n" +
                "1 2\n" +
                "2 5\n" +
                "5 1\n" +
                "3 4\n" +
                "4 6"));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        node = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        relation = new boolean[node][node];
        visit = new boolean[node];

        for(int i = 0; i < edge; ++i){ // 관계 수령
            st = new StringTokenizer(br.readLine().trim());
            int src = Integer.parseInt(st.nextToken());
            int des = Integer.parseInt(st.nextToken());
            relation[src][des] = relation[des][src] = true;
        }


    }


}
