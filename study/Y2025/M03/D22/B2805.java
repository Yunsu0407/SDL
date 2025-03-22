package study.Y2025.M03.D22;

import java.util.*;
import java.io.*;

public class B2805 {
    public static void main(String[] args) throws IOException {
        logging();
    }

    public static void logging() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int treeSize = Integer.parseInt(st.nextToken());
        int treeLimit = Integer.parseInt(st.nextToken());

        Integer[] treeHeight = new Integer[treeSize];
        int max = 0;
        st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < treeSize; ++i) {
            treeHeight[i] = Integer.parseInt(st.nextToken());
            max = Math.max(treeHeight[i], max);
        }

        Arrays.sort(treeHeight, Collections.reverseOrder());

        int high = max;
        int low = 1;
        Integer ans = 0;
        while (low <= high) {
            int cut = (high + low) / 2;
            int index = 0;
            long treeSum = 0;
            while (index < treeSize && treeHeight[index] >= cut) {
                treeSum = treeSum + treeHeight[index];
                ++index;
            }
            treeSum = treeSum - ((long) cut * index);

            if (treeSum >= treeLimit) {
                ans = Math.max(ans, cut);
                low = cut + 1;
            } else { // treeSum < treeLimit
                high = cut - 1;
            }
        }

        System.out.println(ans);
    }
}
