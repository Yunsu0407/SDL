package Y2026.M08.D14;

import java.io.*;

public class S1215 {
    public static void main(String[] args) throws IOException {
        countPalindrome();
    }

    public static void countPalindrome() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = 10;
        StringBuilder sb = new StringBuilder();
        final int SIDE = 8;

        for (int i = 0; i < testcase; ++i) {
            int len = Integer.parseInt(br.readLine().trim());
            String[] orgLines = new String[SIDE];

            for (int j = 0; j < SIDE; ++j) {
                orgLines[j] = br.readLine().trim();
            }
            int count = checkLines(orgLines, len);

            String[] revLines = new String[SIDE];
            for (int j = 0; j < SIDE; ++j) {
                StringBuilder sbLine = new StringBuilder();
                for (String line : orgLines) {
                    char c = line.charAt(j);
                    sbLine.append(c);
                }
                revLines[j] = sbLine.toString();
            }
            count = count + checkLines(revLines, len);

            String line = String.format("#%d %d\n", (i + 1), count);
            sb.append(line);
        }

        System.out.print(sb.toString());
    }

    public static int checkLines(String[] lines, int len) {
        int count = 0;
        int range = lines.length - len + 1;

        for (String line : lines) {
            for (int i = 0; i < range; ++i) {
                String sub = line.substring(i, i + len);
                if (isPalin(sub)) {
                    ++count;
                }
            }
        }

        return count;
    }

    public static boolean isPalin(String sub) {
        boolean ret = true;
        int length = sub.length();
        int check = length / 2;

        for (int i = 0; i < check; ++i) {
            char front = sub.charAt(i);
            char rear = sub.charAt(length - (i + 1));
            if (front != rear) {
                ret = false;
                break;
            }
        }

        return ret;
    }
}

/*
 * ABAC
 * BBAC
 * AACA
 * ABCA
 */