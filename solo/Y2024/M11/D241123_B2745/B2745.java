package Y2024.M11.D241123_B2745;

import java.util.*;
import java.io.*;

/*
B진법 수 N이 주어진다.
이 수를 10진법으로 바꿔 출력하는 프로그램을 작성하라.
10진법을 넘어가는 수는 알파벳 대문자를 사용한다.
A:10, B:11, ... Z:35

진법을 확인한다.

해당 값 x 진법^(자리수-1)
만약 해당 값이 숫자라면{
    해당 값 = 해당 값 - '0';
} 숫자가 아니면 {
    해당 값 = 해당 값 - 'A' + 10;
}
 */
public class B2745 {
    public static void main(String[] args) throws IOException {
        changeSystem();
    }

    public static void changeSystem() throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new StringReader("ZZZZZ 36"));
        BufferedReader br = new BufferedReader(new StringReader("123 10"));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        String expr = st.nextToken();
        int system = Integer.parseInt(st.nextToken());

        int result = 0;
        int length = expr.length();
        for (int i = 0; i < length; ++i) {
            char currValue = expr.charAt(length - (i + 1));
            int decimal;
            if (currValue >= '0' && currValue <= '9') {
                decimal = currValue - '0';
            } else {
                decimal = currValue - 'A' + 10;
            }
            result = result + decimal * (int) Math.pow(system, i);
        }
        System.out.println(result);
    }
}

// 1F 16진법