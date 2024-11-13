package study.Y2024.M11.D241112_T1531_B23971;

import java.util.*;
import java.io.*;

public class B23971 {
    public static void main(String[] args) throws IOException {
        seat();
    }

    public static void seat() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new StringReader("5 4 1 1"));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int topdown = Integer.parseInt(st.nextToken());
        int side = Integer.parseInt(st.nextToken());
        int count = 0;
        int r, c;

        r = 0;
        while (r < row) {
            c = 0;
            while (c < col) {
                ++count;
                c = c + side;
                ++c;
            }
            ++r;
            r = r + topdown;
        }

        System.out.println(count);
    }
}
