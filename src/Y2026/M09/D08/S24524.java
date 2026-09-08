package Y2026.M09.D08;

import java.util.*;
import java.io.*;

public class S24524 {
    public static void main(String[] args) throws IOException {
        levelUp();
    }

    public static void levelUp() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; ++i) {
            int size = Integer.parseInt(br.readLine().trim());
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < size; ++j) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            int min = Integer.MAX_VALUE;
            for (int j = 1; j < size - 1; ++j) {
                int remove = list.remove(j);
                int sum = 0;
                for (int k = 1; k < list.size(); ++k) {
                    sum = sum + Math.abs(list.get(k) - list.get(k - 1));
                    if (sum > min) {
                        break;
                    }
                }

                list.add(j, remove);
                min = Math.min(min, sum);
            }

            sb.append(min).append("\n");
        }

        System.out.print(sb.toString());
    }
}
