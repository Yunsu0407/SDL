package Y2026.M08.D18;

import java.util.*;
import java.io.*;

public class S1234 {
    public static void main(String[] args) throws IOException {
        guessPassword();
    }

    public static void guessPassword() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = 1;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            Integer.parseInt(st.nextToken());
            String word = st.nextToken();

            String result = word;
            while (true) {
                int[] initPos = getInitPos(result);
                if (initPos == null) {
                    break;
                }

                String removal = getRemoval(result, initPos);
                result = result.replace(removal, "");
            }

            String line = String.format("#%d %s\n", (i + 1), result);
            sb.append(line);
        }

        System.out.print(sb.toString());
    }

    public static String getRemoval(String word, int[] pos) {
        String removal = null;
        int fdx = pos[0];
        int rdx = pos[1];

        while (true) {
            fdx = fdx - 1;
            rdx = rdx + 1;
            if (fdx < 0 || rdx >= word.length()) {
                fdx = fdx + 1;
                break;
            }

            char front = word.charAt(fdx);
            char rear = word.charAt(rdx);
            if (front != rear) {
                fdx = fdx + 1;
                break;
            }
        }

        removal = word.substring(fdx, rdx);

        return removal;
    }

    public static int[] getInitPos(String word) {
        int[] pos = new int[2];
        boolean isFind = false;

        int i = 0;
        char front = word.charAt(i);
        for (i = 1; i < word.length(); ++i) {
            char rear = word.charAt(i);

            if (front == rear) {
                pos[0] = i - 1;
                pos[1] = i;
                isFind = true;
                break;
            }
            front = rear;
        }

        if (!isFind) {
            pos = null;
        }

        return pos;
    }
}
