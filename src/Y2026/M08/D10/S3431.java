package Y2026.M08.D10;

import java.util.*;
import java.io.*;

public class S3431 {
    public static void main(String[] args) throws IOException {
        checkExercise();
    }

    public static void checkExercise() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < testcase; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int lowerBound = Integer.parseInt(st.nextToken());
            int upperBound = Integer.parseInt(st.nextToken());
            int exTime = Integer.parseInt(st.nextToken());
            int result;

            if (exTime < lowerBound) {
                result = lowerBound - exTime;
            } else if (exTime > upperBound) {
                result = -1;
            } else {
                result = 0;
            }

            String line = String.format("#%d %d\n", (i + 1), result);
            sb.append(line);
        }

        System.out.print(sb.toString());
    }
}
