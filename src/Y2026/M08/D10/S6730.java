package Y2026.M08.D10;

import java.util.*;
import java.io.*;

public class S6730 {
    public static void main(String[] args) throws IOException {
        blockRaceDifficulty();
    }

    public static void blockRaceDifficulty() throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input1));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; ++i) {
            int blockSize = Integer.parseInt(br.readLine().trim());
            StringTokenizer st = new StringTokenizer(br.readLine().trim());

            int prev = Integer.parseInt(st.nextToken());
            int up = 0, down = 0;
            for (int j = 0; j < blockSize - 1; ++j) {
                int curr = Integer.parseInt(st.nextToken());
                int diff = prev - curr;
                if (diff < 0) {
                    diff = diff * -1;
                    if (diff > up) {
                        up = diff;
                    }
                } else {
                    if (diff > down) {
                        down = diff;
                    }
                }

                prev = curr;
            }

            String line = String.format("#%d %d %d\n", (i + 1), up, down);
            sb.append(line);
        }

        System.out.print(sb.toString());
    }
}
