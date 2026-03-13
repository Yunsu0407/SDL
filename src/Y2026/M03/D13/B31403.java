package Y2026.M03.D13;

import java.io.*;

public class B31403 {
    public static void main(String[] args) throws IOException {
        numberAndString();
    }

    public static void numberAndString() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = new int[3];

        for (int i = 0; i < numbers.length; ++i) {
            numbers[i] = Integer.parseInt(br.readLine().trim());
        }

        int sum1 = numbers[0] + numbers[1] - numbers[2];

        int target = numbers[1];
        int exponent = 0;
        while (target > 0) {
            ++exponent;
            target = target / 10;
        }
        int sum2 = numbers[0] * (int) Math.pow(10, exponent) + numbers[1] - numbers[2];

        StringBuilder sb = new StringBuilder();
        sb.append(sum1).append("\n").append(sum2);

        System.out.println(sb.toString());
    }
}
