package solutions.stage3.D240704_T1614_S3499;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3499 {
    public static void main(String[] args) throws IOException {
        perfectShuffle();
    }

    public static void perfectShuffle() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int testcase = Integer.parseInt(br.readLine().trim());
        String[] answer = new String[testcase];

        for (int i = 0; i < testcase; ++i) {
            final int count = Integer.parseInt(br.readLine().trim());
            StringTokenizer st = new StringTokenizer(br.readLine().trim());

            boolean oddCheck = count % 2 == 1;  // 홀수인가
            int half = count / 2;
            int upsize, downsize;
            if(oddCheck){
                upsize = half + 1;
                downsize = half;
            } else {
                upsize = downsize = half;
            }
            String[] up = new String[upsize];
            String[] down = new String[downsize];

            int idxUp = 0;
            int idxDown = 0;
            for (int j = 0; j < count; ++j) {
                String card = st.nextToken();
                if (j < upsize) {
                    up[idxUp++] = card;
                } else {
                    down[idxDown++] = card;
                }
            }

            StringBuilder sb = new StringBuilder();
            int insert = 0;
            while (insert < half) {   // 4->2, 5->2
                sb.append(up[insert]);
                sb.append(" ");
                sb.append(down[insert]);
                sb.append(" ");
                ++insert;
            }
            if (oddCheck) {
                sb.append(up[insert]);
            }
            answer[i] = sb.toString();
        }

        for (int i = 0; i < testcase; ++i) {
            System.out.printf("#%d %s\n", i + 1, answer[i]);
        }
    }
}
