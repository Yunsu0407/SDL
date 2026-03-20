package Y2026.M03.D20;

import java.util.*;
import java.io.*;

public class B4153 {
    public static void main(String[] args) throws IOException {
        rightTriangle();
    }

    public static void rightTriangle() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int[] nums = new int[3];
            int maxIdx = -1;
            int maxVal = Integer.MIN_VALUE;

            for (int i = 0; i < nums.length; ++i) {
                nums[i] = Integer.parseInt(st.nextToken());
                if (nums[i] > maxVal) {
                    maxIdx = i;
                    maxVal = nums[i];
                }
            }

            if (nums[0] == 0) { // 반복문 종료
                break;
            }

            int sum = 0;
            for (int i = 0; i < nums.length; ++i) {
                if (i == maxIdx) {
                    sum = sum + (int) Math.pow(nums[i], 2);
                } else {
                    sum = sum - (int) Math.pow(nums[i], 2);
                }
            }

            if (sum == 0) {
                sb.append("right").append("\n");
            } else {
                sb.append("wrong").append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}
