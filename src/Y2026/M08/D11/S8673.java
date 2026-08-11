package Y2026.M08.D11;

import java.util.*;
import java.io.*;

public class S8673 {
    public static void main(String[] args) throws IOException {
        codingTournament();
    }

    public static void codingTournament() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; ++i) {
            int exp = Integer.parseInt(br.readLine().trim());
            int size = (int) Math.pow(2, exp);
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int[] skill = new int[size];

            for (int j = 0; j < size; ++j) {
                skill[j] = Integer.parseInt(st.nextToken());
            }

            int boring = 0;
            int limit = size;
            while (limit > 1) {
                for (int j = 0; j < limit; j = j + 2) {
                    int front = skill[j];
                    int rear = skill[j + 1];
                    boring = boring + Math.abs(front - rear);
                    skill[j / 2] = Math.max(front, rear);
                }

                limit = limit / 2;
            }

            String line = String.format("#%d %d\n", (i + 1), boring);
            sb.append(line);
        }

        System.out.print(sb.toString());
    }
}
