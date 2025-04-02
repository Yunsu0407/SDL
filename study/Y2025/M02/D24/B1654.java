package Y2025.M02.D24;

import java.util.*;
import java.io.*;

public class B1654 {
    public static void main(String[] args) throws IOException {
        makeLine();
    }

    public static String input1 = "4 11\n" +
            "802\n" +
            "743\n" +
            "457\n" +
            "539";

    public static void makeLine() throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader(input1));

        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        final int src = Integer.parseInt(st.nextToken());
        final int target = Integer.parseInt(st.nextToken());

        int min = Integer.MAX_VALUE;
        int[] lines = new int[src];
        for (int i = 0; i < src; ++i) {
            lines[i] = Integer.parseInt(br.readLine().trim());
            min = Math.min(min, lines[i]);
        }

        int bottom = 1, top = min;
        int ans;
        while (true) {
            int mid = (top + bottom) / 2;

            int count = 0;
            for (int curr : lines) {
                count = count + curr / mid;
            }

            if(count < target) { // 목표 미달
                top = mid;
            } else if(count == target) { // 목표 충족
                ans = mid;
                break;
            } else { // count > target, 목표 초과
                bottom = mid;
            }
        }

        System.out.println(ans);
    }
}
