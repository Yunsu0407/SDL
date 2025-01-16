package Y2025.M01.D03;

import java.util.*;
import java.io.*;

/*
홍준이가 자연수 N개를 칠판에 적는다.
각 수는 1이상 100,000이하이다.
명우에게 질문을 M번 한다.
질문은 두 정수 S와 E로 나타냄
S번째 수부터 E번째 까지의 수가 팰린드롬을 이루는지 물어보면 명우가 팰린드롬이 맞는지 아닌지를 말해야함
S: 1보다 크거나 같고 E보다 작거나 같음
E: S보다 크거나 같고 N보다 작거나 같음

예를 들어 홍준이가 칠판에 1,2,1,3,1,2,1을 적었으면
S=1,E=3인 경우 1,2,1은 팰린드롬이고,
S=2,E=5인 경우 2,1,3,1은 팰린드롬이 아니고,
S=3,E=3인 경우 1은 팰린드롬이고,
S=5,E=7인 경우 1,2,1은 팰린드롬이다.

팰린드롬인 경우 1, 아니면 0

1213121
 */

public class B10492 {
    public static String example = "7\n" +
            "1 2 1 3 1 2 1\n" +
            "4\n" +
            "1 3\n" +
            "2 5\n" +
            "3 3\n" +
            "5 7";

    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader(example));
        int length = Integer.parseInt(br.readLine().trim());
        String sentence;
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        for (int i = 0; i < length; ++i) {
            sb.append(st.nextToken());
        }
        sentence = sb.toString();

        sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine().trim());

        // 1213121
        // 2 4 -> 1 3, 1 & 3
        // 4
        // 121
        // 1, 1

        // 2 5 -> 1 4, 1 2 & 3 4
        // 5
        // 1213
        // 12, 13

        for (int i = 0; i < tc; ++i) {
            st = new StringTokenizer(br.readLine().trim());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int mid = (start + end) / 2;
            String comp1, comp2;
            int num1, num2;

            if(start == end){
                sb.append("1\n");
                continue;
            }

            if ((start + end) % 2 == 0) {
                comp1 = sentence.substring(start, mid);
            } else {
                comp1 = sentence.substring(start, mid + 1);
            }
            comp2 = new StringBuilder(sentence.substring(mid + 1, end + 1)).reverse().toString();

            if(comp1.equals(comp2)){
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }
        }

        System.out.println(sb.toString());
    }
}
