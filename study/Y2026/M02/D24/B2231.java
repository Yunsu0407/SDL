package study.Y2026.M02.D24;

import java.util.*;
import java.io.*;

/*
생성자 = N과 N을 이루는 자릿수의 합
N은 1이상 1,000,000이하
가장 작은 생성자를 구하시오.
 */

public class B2231 {
    public static void main(String[] args) throws IOException {
        findDecompositionSum();
    }

    public static void findDecompositionSum() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine().trim());

        int min = 0;
        int curr = target;
        while (curr > 0) {
            int sum = curr;
            int number = curr;

            while (number > 0) {
                sum = sum + number % 10;
                number = number / 10;
            }

            if(sum == target) {
                min = curr;
            }

            curr = curr - 1;
        }

        System.out.println(min);
    }
}
