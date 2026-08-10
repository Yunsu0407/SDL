package Y2026.M08.D10;

import java.io.*;

public class S4406 {
    public static void main(String[] args) throws IOException {
        forgetVowel();
    }

    public static void forgetVowel() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < testcase; ++i) {
            String word = br.readLine().trim();
            StringBuilder sbResult = new StringBuilder();
            char[] vowel = { 'a', 'e', 'i', 'o', 'u' };

            for (int j = 0; j < word.length(); ++j) {
                char c = word.charAt(j);
                boolean isVowel = false;

                for (char v : vowel) {
                    if (c == v) {
                        isVowel = true;
                        break;
                    }
                }

                if (!isVowel) {
                    sbResult.append(c);
                }
            }

            String line = String.format("#%d %s\n", (i + 1), sbResult.toString());
            sb.append(line);
        }

        System.out.print(sb.toString());
    }
}
