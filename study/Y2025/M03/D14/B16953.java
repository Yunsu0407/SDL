package study.Y2025.M03.D14;

import java.util.*;
import java.io.*;

public class B16953 {
    public static void main(String[] args) throws IOException {
        changeAtoB();
    }

    public static String input1 = "2 162";
    public static String input2 = "4 42";
    public static String input3 = "100 40021";

    /*
    1. 2를 곱한다.
    2. 수의 가장 오른쪽에 1을 추가한다.
     */

    /*
    2 162
    162 = 2 * 3^(4) = 2 * 81 = 2 * 9 * 9
     */

    public static void changeAtoB() throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader(input3));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int curr = end;

        int count = 0;
        while (true) {
            int last_digit = curr % 10;
            if (last_digit == 1) {
                curr = curr / 10;
                ++count;
            } else {
                int residue = curr % 2;
                if(residue == 0) {
                    curr = curr / 2;
                    ++count;
                } else {
                    break;
                }
            }

            if(curr <= start) {
                break;
            }
        }

        if(curr == start) {
            count = count + 1;
        } else {
            count = -1;
        }

        System.out.println(count);
    }
}
