package Y2026.M11.D19;

import java.util.*;
import java.io.*;

public class S5185 {
    public static void main(String[] args) throws IOException {
        hexToBi();
    }

    public static void hexToBi() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < tc; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int len = Integer.parseInt(st.nextToken());
            String hex = st.nextToken();

            StringBuilder ans = new StringBuilder();
            for (int j = 0; j < len; ++j) {
                ans.append(convertHexDigit(hex.charAt(j)));
            }

            String line = String.format("#%d %s\n", (i + 1), ans.toString());
            sb.append(line);
        }

        System.out.print(sb.toString());
    }

    public static String convertHexDigit(char c) {
        StringBuilder sb = new StringBuilder();
        int size = c >= '0' && c <= '9' ? c - '0' : c - 'A' + 10;

        for (int i = 0; i < 3; ++i) {
            int rest = size % 2;
            size = size / 2;
            sb.append(rest);
        }
        sb.append(size);

        return sb.reverse().toString();
    }
}
