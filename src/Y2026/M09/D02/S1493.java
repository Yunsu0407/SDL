package Y2026.M09.D02;

import java.util.*;
import java.io.*;

public class S1493 {
    public static void main(String[] args) throws IOException {
        freshCalc();
    }

    public static void freshCalc() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            int[] posP = findPos(p);
            int[] posQ = findPos(q);

            int[] posR = new int[] { posP[0] + posQ[0], posP[1] + posQ[1] };
            int dot = findDot(posR);

            String line = String.format("#%d %d\n", (i + 1), dot);
            sb.append(line);
        }

        System.out.print(sb.toString());
    }

    public static int[] findPos(int d) {
        int[] ret = null;
        int limit = 1;
        int group = 1;

        while (d > limit) {
            group = group + 1;
            limit = limit + group;
        }

        int sum = group + 1;
        int first = limit - group + 1;
        int x = d - first + 1;
        int y = sum - x;
        ret = new int[] { x, y };

        return ret;
    }

    public static int findDot(int[] pos) {
        int ret = 1;
        int group = pos[0] + pos[1] - 1;
        int add = 0;
        for (int i = 0; i < group; ++i) {
            ret = ret + add;
            add = add + 1;
        }

        ret = ret + pos[0] - 1;

        return ret;
    }
}