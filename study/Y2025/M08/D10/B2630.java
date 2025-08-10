package Y2025.M08.D10;

import java.util.*;
import java.io.*;

public class B2630 {
    public static void main(String[] args) throws IOException {
        makePaper();
    }

    public static void makePaper() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int iSize = Integer.parseInt(br.readLine().trim());
        boolean[][] iPaper = new boolean[iSize][iSize];

        for (int r = 0; r < iSize; ++r) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            for (int c = 0; c < iSize; ++c) {
                iPaper[r][c] = st.nextToken().equals("1");
            }
        }

        Queue<boolean[][]> queue = new ArrayDeque<>();
        queue.add(iPaper);
        final int W = 0, B = 1;
        int[] count = new int[2];

        while (!queue.isEmpty()) {
            boolean[][] paper = queue.remove();
            int size = paper.length;
            boolean sColor = paper[0][0]; // start color
            boolean countable = true;

            paperCheck:
            for (int r = 0; r < size; ++r) {
                for (int c = 0; c < size; ++c) {
                    if (sColor != paper[r][c]) {
                        countable = false;
                        break paperCheck;
                    }
                }
            }

            if (countable) {
                if (sColor) { // true = blue
                    ++count[B];
                } else { // false = white
                    ++count[W];
                }
            } else {
                int bound = size / 2;
                int[] ir = {0, 0, bound, bound};
                int[] ic = {0, bound, 0, bound};

                for (int i = 0; i < ir.length; ++i) {
                    boolean[][] nPaper = new boolean[bound][bound];
                    for (int r = 0; r < bound; ++r) {
                        for (int c = 0; c < bound; ++c) {
                            nPaper[r][c] = paper[r + ir[i]][c + ic[i]];
                        }
                    }
                    queue.add(nPaper);
                }
            }
        }

        System.out.printf("%d\n%d", count[W], count[B]);
    }
}
