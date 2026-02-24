package Y2026.M02.D24;

import java.util.*;
import java.io.*;

/*
카드의 개수(N)와 제한 점수(M)가 주어질 때
N개의 카드들 중 3개를 골라 최대한 M에 가까운 수의 값을 출력하라.
N은 3이상 100이하, M은 10이상 300,000이하, 숫자들은 1이상 100,000이하
 */

public class B2798 {
    public static void main(String[] args) throws IOException {
        playNewGame();
    }

    public static void playNewGame() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int size = Integer.parseInt(st.nextToken());
        int limit = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < size; ++i) {
            int number = Integer.parseInt(st.nextToken());
            if(number < limit) {
                list.add(number);
            }
        }

        int max = 0;

        search:
        for (int i = 0; i < size - 2; ++i) {
            int num1 = list.get(i);

            for(int j = i + 1; j < size - 1; ++j) {
                int num2 = list.get(j);
                int sum1 = num1 + num2;
                if(sum1 >= limit) {
                    continue;
                }

                for (int k = j + 1; k < size; ++k) {
                    int num3 = list.get(k);
                    int sum2 = sum1 + num3;

                    if (sum2 == limit) {
                        max = limit;
                        break search;
                    } else if (sum2 < limit) {
                        max = Math.max(max, sum2);
                    }
                }
            }
        }

        System.out.println(max);
    }
}
