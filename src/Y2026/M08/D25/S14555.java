package Y2026.M08.D25;

import java.io.*;
import java.util.regex.Pattern;

public class S14555 {
    public static void main(String[] args) throws IOException {
        ballGrass();
    }

    public static void ballGrass() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        String[] outlines = { "()", "(|", "|)" };

        for (int i = 0; i < testcase; ++i) {
            String state = br.readLine().trim();
            int count = 0;
            for (String outline : outlines) {
                count = count + checkOutLine(state, outline);
            }

            String line = String.format("#%d %d\n", (i + 1), count);
            sb.append(line);
        }

        System.out.print(sb.toString());
    }

    public static int checkOutLine(String state, String outline) {
        int count = 0;

        while (state.contains(outline)) {
            ++count;
            state = state.replaceFirst(Pattern.quote(outline), "");
        }

        return count;
    }
}
