package Y2026.M08.D12;

import java.util.*;
import java.io.*;

public class S5431 {
    public static void main(String[] args) throws IOException {
        checkAssign();
    }

    public static void checkAssign() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            boolean[] isDone = new boolean[n];
            st = new StringTokenizer(br.readLine().trim());
            for (int j = 0; j < k; ++j) {
                int number = Integer.parseInt(st.nextToken()) - 1;
                isDone[number] = true;
            }

            StringBuilder ans = new StringBuilder();
            for (int j = 0; j < n; ++j) {
                if (!isDone[j]) {
                    int number = j + 1;
                    ans.append(number + " ");
                }
            }

            String line = String.format("#%d %s\n", (i + 1), ans.toString());
            sb.append(line);
        }

        System.out.print(sb.toString());
    }
}
