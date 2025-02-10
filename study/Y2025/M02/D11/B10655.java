package Y2025.M02.D11;

import java.util.*;
import java.io.*;

public class B10655 {
    public static void main(String[] args) throws IOException {
        skip();
    }

    public static String input1 = "4\n" +
            "0 0\n" +
            "8 3\n" +
            "11 -1\n" +
            "10 0";

    public static String input2 = "3\n" +
            "0 0\n" +
            "8 3\n" +
            "10 0";

    public static String input3 = "5\n" +
            "0 0\n" +
            "2 2\n" +
            "3 1\n" +
            "4 -1\n" +
            "5 0";

    public static void skip() throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader(input3));

        int checkPoint = Integer.parseInt(br.readLine().trim());
        int total = 0;
        int[] oneDiff = new int[checkPoint];
        int[] twoDiff = new int[checkPoint];

        StringTokenizer st = new StringTokenizer(br.readLine().trim()); // 0
        int veryPrevX = Integer.parseInt(st.nextToken());
        int veryPrevY = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine().trim()); // 1
        int prevX = Integer.parseInt(st.nextToken());
        int prevY = Integer.parseInt(st.nextToken());
        oneDiff[1] = Math.abs(veryPrevX - prevX) + Math.abs(veryPrevY - prevY);
        total = total + oneDiff[1];

        for (int i = 2; i < checkPoint; ++i) {
            st = new StringTokenizer(br.readLine().trim());
            int currX = Integer.parseInt(st.nextToken());
            int currY = Integer.parseInt(st.nextToken());
            oneDiff[i] = Math.abs(prevX - currX) + Math.abs(prevY - currY);
            total = total + oneDiff[i];
            twoDiff[i - 1] = Math.abs(veryPrevX - currX) + Math.abs(veryPrevY - currY);

            veryPrevX = prevX;
            prevX = currX;
            veryPrevY = prevY;
            prevY = currY;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < checkPoint - 1; ++i) { // 첫번째와 마지막 제외
            // 1,2 2,3 빼고, 1,3 넣기
            int currDiff = total - (oneDiff[i] + oneDiff[i + 1]) + twoDiff[i];
            min = Math.min(min, currDiff);
        }

        System.out.println(min);
    }
}
