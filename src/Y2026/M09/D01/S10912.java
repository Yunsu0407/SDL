package Y2026.M09.D01;

import java.io.*;

public class S10912 {
    public static void main(String[] args) throws IOException {
        lonelyString();
    }

    public static void lonelyString() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; ++i) {
            String input = br.readLine().trim();
            int[] alphabet = new int[26];

            for (int j = 0; j < input.length(); ++j) {
                int idx = input.charAt(j) - 'a';
                ++alphabet[idx];
            }

            StringBuilder ans = new StringBuilder();
            boolean isGood = true;
            for (int j = 0; j < alphabet.length; ++j) {
                if (alphabet[j] % 2 != 0) {
                    char c = (char) (j + 'a');
                    ans.append(c);
                    isGood = false;
                }
            }

            if (isGood) {
                ans.append("Good");
            }

            String line = String.format("#%d %s\n", (i + 1), ans.toString());
            sb.append(line);
        }

        System.out.print(sb.toString());
    }
}
