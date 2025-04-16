package Y2025.M04.D16;

import java.io.*;

public class B14916 {
    public static void main(String[] args) throws IOException {
        giveChange();
    }

    public static void giveChange() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cash = Integer.parseInt(br.readLine().trim());
        int min = 100_001;
        final int FIVE = 5, TWO = 2;
        boolean isPossible = false;

        int limit = cash / FIVE;
        for (int i = 0; i <= limit; ++i) {
            int rest = cash - FIVE * i;

            if (rest % TWO == 0) {
                int quotient = rest / TWO + i;

                min = Math.min(min, quotient);
                isPossible = true;
            }
        }

        if (!isPossible) {
            min = -1;
        }

        System.out.println(min);
    }

}
