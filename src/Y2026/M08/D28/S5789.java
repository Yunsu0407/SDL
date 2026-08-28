package Y2026.M08.D28;

import java.util.*;
import java.io.*;

public class S5789 {
    public static void main(String[] args) throws IOException {
        changeBox();
    }

    public static void changeBox() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int size = Integer.parseInt(st.nextToken());
            int task = Integer.parseInt(st.nextToken());
            int[] box = new int[size];

            for (int j = 0; j < task; ++j) {
                st = new StringTokenizer(br.readLine().trim());
                int left = Integer.parseInt(st.nextToken()) - 1;
                int right = Integer.parseInt(st.nextToken());
                int value = j + 1;

                for (int k = left; k < right; ++k) {
                    box[k] = value;
                }
            }

            StringBuilder ans = new StringBuilder();
            for (int j = 0; j < size; ++j) {
                int val = box[j];
                ans.append(val).append(" ");
            }

            String line = String.format("#%d %s\n", (i + 1), ans.toString());
            sb.append(line);
        }

        System.out.print(sb.toString());
    }
}
