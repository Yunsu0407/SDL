package Y2026.M08.D18;

import java.util.*;
import java.io.*;

public class S3456 {
    public static void main(String[] args) throws IOException {
        rectangleSide();
    }

    public static void rectangleSide() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; ++i) {
            int size = 3;
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            Map<Integer, Integer> hmap = new HashMap<>();

            for (int j = 0; j < size; ++j) {
                int side = Integer.parseInt(st.nextToken());
                int value = 1;

                if (hmap.containsKey(side)) {
                    value = hmap.get(side) + 1;
                }
                hmap.put(side, value);
            }

            int rest = 0;
            for (Map.Entry<Integer, Integer> entry : hmap.entrySet()) {
                int value = entry.getValue();
                if (value == 1 || value == 3) {
                    rest = entry.getKey();
                }
            }

            String line = String.format("#%d %d\n", (i + 1), rest);
            sb.append(line);
        }

        System.out.print(sb.toString());
    }
}