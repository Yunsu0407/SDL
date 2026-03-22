package Y2026.M03.D22;

import java.util.*;
import java.io.*;

public class B2869 {
    public static void main(String[] args) throws IOException {
        climbSnail();
    }

    public static void climbSnail() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        int cost = 1;
        int target = v - a;
        int dayMove = a - b;
        cost = cost + target / dayMove;
        if (target % dayMove != 0) {
            cost = cost + 1;
        }

        System.out.println(cost);
    }
}
