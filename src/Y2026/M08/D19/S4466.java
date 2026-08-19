package Y2026.M08.D19;

import java.util.*;
import java.io.*;

public class S4466 {
    public static void main(String[] args) throws IOException {
        maxSum();
    }

    public static void maxSum() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int kind = Integer.parseInt(st.nextToken());
            int select = Integer.parseInt(st.nextToken());

            int sum = 0;
            List<Integer> list = new ArrayList<>();
            st = new StringTokenizer(br.readLine().trim());
            for (int j = 0; j < kind; ++j) {
                int score = Integer.parseInt(st.nextToken());
                sum = sum + score;
                list.add(score);
            }

            list.sort(null);

            for (int j = 0; j < kind - select; ++j) {
                sum = sum - list.get(j);
            }

            String line = String.format("#%d %d\n", (i + 1), sum);
            sb.append(line);
        }

        System.out.print(sb.toString());
    }
}
