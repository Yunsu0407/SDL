package Y2026.M08.D19;

import java.util.*;
import java.io.*;

public class S8500 {
    public static void main(String[] args) throws IOException {
        theaterSeat();
    }

    public static void theaterSeat() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; ++i) {
            int size = Integer.parseInt(br.readLine().trim());
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int max = 0;
            int sum = size;
            for (int j = 0; j < size; ++j) {
                int range = Integer.parseInt(st.nextToken());
                sum = sum + range;
                max = Math.max(max, range);
            }
            sum = sum + max;

            String line = String.format("#%d %d\n", (i + 1), sum);
            sb.append(line);
        }

        System.out.print(sb.toString());
    }
}
