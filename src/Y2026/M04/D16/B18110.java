package Y2026.M04.D16;

import java.util.*;
import java.io.*;

public class B18110 {
    public static void main(String[] args) throws IOException {
        avgLevel();
    }

    public static void avgLevel() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine().trim());
        int[] level = new int[31];
        int sum = 0;

        for (int i = 0; i < size; ++i) {
            int curr = Integer.parseInt(br.readLine().trim());
            level[curr] = level[curr] + 1;
            sum = sum + curr;
        }

        int cut = (int) Math.round(size * 0.15);
        int low = 1;
        int high = level.length - low;
        sum = sum - getVal(level, cut, low, 1);
        sum = sum - getVal(level, cut, high, -1);

        double div = size - cut * 2.0;
        int ans = (int) Math.round(sum / div);
        System.out.println(ans);
    }

    public static int getVal(int[] level, int cut, int idx, int weight) {
        int sum = 0;

        while (cut > 0) {
            int curr = level[idx];

            if (curr <= cut) {
                sum = sum + idx * curr;
                cut = cut - curr;
            } else {
                sum = sum + idx * cut;
                cut = 0;
            }

            idx = idx + weight;
        }

        return sum;
    }
}
