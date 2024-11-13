package study.D241112_T1531_B23971;

import java.util.*;
import java.io.*;

public class B23971_2 {
    public static void main(String[] args) throws IOException {
        seat();
    }

    public static void seat() throws IOException {
        BufferedReader br = new BufferedReader(new StringReader("5 4 1 1"));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int topdown = Integer.parseInt(st.nextToken());
        int side = Integer.parseInt(st.nextToken());
        double count, r, c;

        r = Math.ceil(row / (topdown + 1.0));
        c = Math.ceil(col / (side + 1.0));
        count = r * c;

        System.out.println((int)count);
    }
}
