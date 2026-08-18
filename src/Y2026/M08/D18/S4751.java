package Y2026.M08.D18;

import java.io.*;

public class S4751 {
    public static void main(String[] args) throws IOException {
        decorateWord();
    }

    public static void decorateWord() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; ++i) {
            String word = br.readLine().trim();
            int len = word.length();
            StringBuilder decorated = new StringBuilder();
            String secondCrust = makeOutLine(len, "..#.", '.');
            String firstCrust = makeOutLine(len, ".#.#", '.');
            String core = makeInnerLine(len, word, '#');

            decorated.append(secondCrust);
            decorated.append(firstCrust);
            decorated.append(core);
            decorated.append(firstCrust);
            decorated.append(secondCrust);

            sb.append(decorated.toString());
        }

        System.out.print(sb.toString());
    }

    public static String makeOutLine(int len, String repeat, char last) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < len; ++i) {
            sb.append(repeat);
        }
        sb.append(last).append("\n");

        return sb.toString();
    }

    public static String makeInnerLine(int len, String word, char last) {
        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < len; ++j) {
            char c = word.charAt(j);
            String repeat = String.format("#.%c.", c);
            sb.append(repeat);
        }
        sb.append(last).append("\n");

        return sb.toString();
    }

}
