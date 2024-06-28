package solutions.stage3.D240625_T0905_S1206;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1206 {
    public static void main(String[] args) throws IOException {
        calculateTotalProspect();
    }

    public static void calculateTotalProspect() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int testcase = 10;
        int[] answer = new int[testcase];

        for (int i = 0; i < testcase; ++i) {
            int prospect = 0;
            int width = Integer.parseInt(br.readLine().trim());
            int[] buildings = new int[width];
            StringTokenizer st = new StringTokenizer(br.readLine().trim());

            for (int j = 0; j < width; ++j) {
                buildings[j] = Integer.parseInt(st.nextToken());
            }

            int start = 2;
            int end = width - 2;
            int maxHeight;
            for (int j = start; j < end; ++j) {
                maxHeight = getMaxHeight(buildings[j - 2], buildings[j - 1], buildings[j + 1], buildings[j + 2]);
                if (buildings[j] > maxHeight) {
                    prospect = prospect + buildings[j] - maxHeight;
                }
            }

            answer[i] = prospect;
        }

        for (int i = 0; i < testcase; ++i) {
            System.out.println("#" + (i + 1) + " " + answer[i]);
        }
    }

    public static int getMaxHeight(int front1, int front2, int rear1, int rear2) {
        return Math.max(Math.max(front1, front2), Math.max(rear1, rear2));
    }
}
