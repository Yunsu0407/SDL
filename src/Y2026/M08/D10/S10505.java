package Y2026.M08.D10;

import java.util.*;
import java.io.*;

public class S10505 {
    public static void main(String[] args) throws IOException {
        incomeUnbalance();
    }

    public static void incomeUnbalance() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < testcase; ++i) {
            int incomeSize = Integer.parseInt(br.readLine().trim());
            int[] incomes = new int[incomeSize];
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int sum = 0;

            for (int j = 0; j < incomeSize; ++j) {
                int income = Integer.parseInt(st.nextToken());
                incomes[j] = income;
                sum = income + sum;
            }

            double average = (double) sum / incomeSize;

            int count = 0;
            for (int income : incomes) {
                if (income <= average) {
                    count = count + 1;
                }
            }

            String line = String.format("#%d %d\n", (i + 1), count);
            sb.append(line);
        }

        System.out.print(sb.toString());
    }
}
