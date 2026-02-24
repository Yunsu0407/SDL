package study.Y2026.M02.D05;

/*
전제
거스름돈 액수에 따른 동전의 개수 최소화
쿼터 0.25 (25)
다임 0.10 (10)
니켈 0.05 (5)
페니 0.01 (1)

조건
- 거스름돈 동전의 최소화
- 거스름돈은 항상 5달러 이하
 */

import java.io.*;

public class B2720 {
    public static void main(String[] args) throws IOException {
        handleCharge();
    }

    public static String input = "3\n" +
            "124\n" +
            "25\n" +
            "194";

    public static void handleCharge() throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br= new BufferedReader(new StringReader(input));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; ++i) {
            int[] kind = {25, 10, 5, 1};
            int charge = Integer.parseInt(br.readLine().trim());

            int cycle = 0;
            while(cycle < kind.length) {
                int count = charge / kind[cycle];
                charge = charge - kind[cycle] * count;
                sb.append(count).append(" ");
                ++cycle;
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
