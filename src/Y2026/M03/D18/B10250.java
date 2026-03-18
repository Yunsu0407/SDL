package Y2026.M03.D18;

import java.util.*;
import java.io.*;

public class B10250 {
    public static void main(String[] args) throws IOException {
        hotelACM();
    }

    public static String input1 = "4\r\n" + //
            "6 12 10\r\n" + //
            "3 1 2\r\n" + //
            "1 4 1\r\n" + //
            "30 50 72";

    public static void hotelACM() throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader(input1));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int height = Integer.parseInt(st.nextToken());
            int width = Integer.parseInt(st.nextToken());
            int guest = Integer.parseInt(st.nextToken());

            int floor = ((guest - 1) % height + 1) * 100;
            int depth = (guest - 1) / height + 1;
            int room = floor + depth;
            sb.append(room).append("\n");
        }

        System.out.println(sb.toString());
    }
}
