package Y2026.M03.D18;

import java.io.*;

public class B8958 {
    public static void main(String[] args) throws IOException {
        quizOX();
    }

    public static void quizOX() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < tc; ++i) {
            String res = br.readLine().trim();
            boolean isCon = false; // is continued
            int score = 0;
            int combo = 0;

            for (int j = 0; j < res.length(); ++j) {
                char curr = res.charAt(j);

                if (curr == 'O') {
                    if (isCon) {
                        combo = combo + 1;
                    } else {
                        combo = 1;
                    }
                    score = score + combo;
                    isCon = true;
                } else {
                    isCon = false;
                }
            }

            sb.append(score).append("\n");
        }

        System.out.println(sb.toString());
    }
}
