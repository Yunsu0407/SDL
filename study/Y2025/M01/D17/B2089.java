package Y2025.M01.D17;

import java.util.*;
import java.io.*;

public class B2089 {
    public static void main(String[] args) throws IOException {
        negativeBinary();
    }

    public static String input = "-13";

    public static void negativeBinary() throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader(input));
        int value = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        while (true) {
            if (Math.abs(value) % 2 == 1) { // 홀수면
                value = value - 1;
                sb.append("1");
            } else { // 짝수면
                sb.append("0");
            }

            int next = value / -2;
            if (next == 0 || next == 1) {
                if(next == 1){
                    sb.append("1");
                }
                break;
            } else {
                value = next;
            }
        }
        System.out.println(sb.reverse());
    }
}
