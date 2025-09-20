package study.Y2025.M08.D15;

import java.util.*;
import java.io.*;

public class B2720 {
    public static void main(String[] args) throws IOException {
        laundry();
    }

    public static String input1 = "3\n" +
            "124\n" +   // 4 2 0 4
            "25\n" +    // 1 0 0 0
            "194";      // 7 1 1 4

    public static int[] change = {25, 10, 5, 1};

    public static void laundry() throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader(input1));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; ++i) {
            int money = Integer.parseInt(br.readLine().trim());
            sb.append(getSet(money)).append("\n");
        }

        System.out.println(sb.toString());
    }

    public static String getSet(int money) {
        String minSet = null;
        int minCount = 51;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{money, 0, 0, 0, 0});

        while (!queue.isEmpty()) {
            int[] data = queue.remove();
            
            int currCount = 0;
            for (int j = 1; j < data.length; ++j) {
                currCount = currCount + data[j];
            }

            if (data[0] == 0) {
                if (currCount < minCount) {
                    minCount = currCount;
                    StringBuilder sb = new StringBuilder();
                    for (int i = 1; i < data.length; ++i) {
                        sb.append(data[i]).append(" ");
                    }
                    minSet = sb.toString();
                }
            }

            for (int i = 0; i < change.length; ++i) {
                if (data[0] - change[i] > 0) {
                    int[] nData = data.clone();
                    nData[0] = nData[0] + change[i];
                    ++nData[i + 1];

                    if(currCount < minCount) {
                        queue.add(nData);
                    }
                }
            }
        }

        return minSet;
    }
}
