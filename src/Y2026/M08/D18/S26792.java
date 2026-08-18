package Y2026.M08.D18;

import java.util.*;
import java.io.*;

public class S26792 {
    public static void main(String[] args) throws IOException {
        guessNumbers();
    }

    public static void guessNumbers() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int sum = Integer.parseInt(st.nextToken());
            int diff = Integer.parseInt(st.nextToken());
            int a = (sum + diff) / 2;
            int b = sum - a;
            String line = String.format("%d %d\n", a, b);
            sb.append(line);
        }

        System.out.print(sb.toString());
    }
}
