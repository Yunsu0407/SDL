package Y2026.M08.D18;

import java.util.*;
import java.io.*;

public class S8741 {
    public static void main(String[] args) throws IOException {
        makeAcronym();
    }

    public static void makeAcronym() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            StringBuilder acronym = new StringBuilder();

            while (st.hasMoreTokens()) {
                String word = st.nextToken().substring(0, 1);
                char c = word.charAt(0);
                acronym.append(c);
            }

            String capital = acronym.toString().toUpperCase();
            String line = String.format("#%d %s\n", (i + 1), capital);
            sb.append(line);
        }

        System.out.print(sb.toString());
    }
}
