package Y2026.M08.D18;

import java.io.*;

public class S10804 {
    public static void main(String[] args) throws IOException {
        mirrorString();
    }

    public static void mirrorString() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; ++i) {
            String input = br.readLine().trim();
            StringBuilder output = new StringBuilder();

            for (int j = 0; j < input.length(); ++j) {
                char ci = input.charAt(j);
                char co = mirrorChar(ci);
                output.append(co);
            }
            output.reverse();

            String line = String.format("#%d %s\n", (i + 1), output.toString());
            sb.append(line);
        }

        System.out.print(sb.toString());
    }

    public static char mirrorChar(char ci) {
        char ret = 'o';
        switch (ci) {
            case 'b':
                ret = 'd';
                break;
            case 'd':
                ret = 'b';
                break;
            case 'p':
                ret = 'q';
                break;
            case 'q':
                ret = 'p';
                break;
        }

        return ret;
    }
}
