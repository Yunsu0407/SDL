package study.Y2024.M11.D241130_B14719;

import java.util.*;
import java.io.*;

public class B14719 {
    public static void main(String[] args) throws IOException {
        rainwater();
    }

    public static void rainwater() throws IOException {
        BufferedReader br = new BufferedReader(new StringReader("4 4\n" +
                "3 0 1 4"));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        boolean[][] space = new boolean[height][width];

        st = new StringTokenizer(br.readLine().trim());
        for (int col = 0; col < width; ++col) {
            int water = Integer.parseInt(st.nextToken());
            int row = height - 1;
            while (water > 0) {
                space[row][col] = true;
                --water;
                --row;
            }
        }

        int total = 0;
        for (int row = height - 1; row >= 0; --row) {
            boolean isBlocked = false;
            int count = 0;
            for (int col = 0; col < width; ++col) {
                if (isBlocked) { // 앞에 벽이 있을 때
                    if (space[row][col]) { // 벽이라면
                        total = total + count;
                        count = 0;
                    } else { // 빈 공간이라면
                        ++count;
                    }
                } else { // 벽이 없을 때
                    if (space[row][col]) { // 벽이 나타나면
                        isBlocked = true;
                    } else { // 빈 공간이면
                        continue; // 넘어감
                    }
                }
            }
        }

        System.out.println(total);
    }
}