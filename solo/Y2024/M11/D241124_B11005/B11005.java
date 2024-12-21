package Y2024.M11.D241124_B11005;

import java.util.*;
import java.io.*;

/*
10진법을 B진법으로 바꾸기
A:10, B:11, ... Z:35
B는 2이상 36이하

1. 입력값을 B로 나눈다.
2. 나머지를 B진법 체계로 바꾸고 append()한다.
3. 나머지가 B보다 큰 동안 1,2를 반복한다.
4. 마지막 몫을 B진법 체계로 바꾸고 append()한다.
5. revser()해주고 출력한다.
 */

public class B11005 {
    public static void main(String[] args) throws IOException {
        changeSystem();
    }

    public static void changeSystem() throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader("60466175 36")); // ZZZZZ
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int input = Integer.parseInt(st.nextToken()); // 입력값
        int system = Integer.parseInt(st.nextToken()); // B진법
        int target = input;
        StringBuilder sb = new StringBuilder();

        int next;
        int residue;
        while (target >= system) {
            next = target / system;
            residue = target - next * system;
            target = next;
            sb.append(changeValue(residue));
        }
        sb.append(changeValue(target));
        sb.reverse();

        System.out.println(sb.toString());
    }

    public static String changeValue(int decimal) {
        if (decimal > 9) {
            return String.valueOf((char) ('A' + (decimal - 10)));
        } else {
            return String.valueOf(decimal);
        }
    }
}
