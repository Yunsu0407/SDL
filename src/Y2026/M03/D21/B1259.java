package Y2026.M03.D21;

import java.util.*;
import java.io.*;

public class B1259 {
    public static void main(String[] args) throws IOException {
        palindrome();
    }

    public static void palindrome() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String str = br.readLine().trim();
            if (str.equals("0")) {
                break;
            }

            int size = str.length();
            int fStart = 0, fEnd;
            int bStart, bEnd = size;

            if (size % 2 == 0) { // 문자열의 길이가 짝수
                fEnd = size / 2;
                bStart = fEnd;
            } else { // 홀수
                fEnd = size / 2;
                bStart = fEnd + 1;
            }

            String front = str.substring(fStart, fEnd);
            String back = (new StringBuilder(str.substring(bStart, bEnd))).reverse().toString();
            String ans = front.equals(back) ? "yes" : "no";
            sb.append(ans).append("\n");
        }

        System.out.println(sb.toString());
    }
}
