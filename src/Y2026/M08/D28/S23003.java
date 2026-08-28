package Y2026.M08.D28;

import java.util.*;
import java.io.*;

public class S23003 {
    public static void main(String[] args) throws IOException {
        colorCheck();
    }

    public static String input1 = "4\r\n" + //
            "red red\r\n" + //
            "red purple\r\n" + //
            "red green\r\n" + //
            "red yellow";

    public static void colorCheck() throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader(input1));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        String[] colors = new String[] { "purple", "blue", "green", "yellow", "orange", "red" };
        Map<String, Integer> colorMap = new HashMap<>();
        for (int i = 0; i < colors.length; ++i) {
            colorMap.put(colors[i], i);
        }

        for (int i = 0; i < testcase; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            String front = st.nextToken();
            String rear = st.nextToken();

            int fValue = colorMap.get(front);
            int rValue = colorMap.get(rear);

            int diff = (Math.abs(fValue - rValue)) % 4;

            String res;
            if (diff == 0) {
                res = "E";
            } else if (diff == 1) {
                res = "A";
            } else if (diff == 3) {
                res = "C";
            } else {
                res = "X";
            }

            String line = String.format("%s\n", res);
            sb.append(line);
        }

        System.out.print(sb.toString());
    }
}
