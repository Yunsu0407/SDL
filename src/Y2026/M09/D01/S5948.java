package Y2026.M09.D01;

import java.util.*;
import java.io.*;

public class S5948 {
    public static void main(String[] args) throws IOException {
        game735();
    }

    public static void game735() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int size = 7;
            int[] nums = new int[size];

            for (int j = 0; j < size; ++j) {
                nums[j] = Integer.parseInt(st.nextToken());
            }

            Set<Integer> set = new TreeSet<>((a, b) -> Integer.compare(b, a));
            for (int l = 0; l < size - 2; ++l) {
                for (int m = l + 1; m < size - 1; ++m) {
                    for (int n = m + 1; n < size; ++n) {
                        set.add(nums[l] + nums[m] + nums[n]);
                    }
                }
            }

            List<Integer> list = new ArrayList<>(set);
            String line = String.format("#%d %d\n", (i + 1), list.get(4));
            sb.append(line);
        }

        System.out.print(sb.toString());
    }
}
