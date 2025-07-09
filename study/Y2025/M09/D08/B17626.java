package study.Y2025.M09.D08;

import java.io.*;

public class B17626 {
    public static void main(String[] args) throws IOException {
        fourSquares();
    }

    public static void fourSquares() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine().trim());

        recursive(target, 1);

        System.out.println(min);
    }

    public static int min = Integer.MAX_VALUE;

    public static void recursive(int target, int count) {
        int sqrt = (int) Math.sqrt(target);

        if (count < min) {
            for (int i = sqrt; i > 0; --i) {
                int rest = target - (int) Math.pow(i, 2);

                if (rest == 0) {
                    min = Math.min(min, count);
                } else {
                    recursive(rest, count + 1);
                }
            }
        }
    }
}
