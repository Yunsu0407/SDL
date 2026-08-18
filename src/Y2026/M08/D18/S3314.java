package Y2026.M08.D18;

import java.util.*;
import java.io.*;

public class S3314 {
    public static void main(String[] args) throws IOException {
        calcAverage();
    }

    public static void calcAverage() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int size = 5;
            int sum = 0;

            for (int j = 0; j < size; ++j) {
                int score = Integer.parseInt(st.nextToken());
                int cutline = 40;
                score = score >= cutline ? score : cutline;
                sum = sum + score;
            }

            int average = sum / size;
            String line = String.format("#%d %d\n", (i + 1), average);
            sb.append(line);
        }

        System.out.print(sb.toString());
    }
}
