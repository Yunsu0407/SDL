package solutions.stage2.D240624_T0923_S1859;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1859 {
    public static void main(String[] args) throws IOException {
        getProfit();
    }

    public static void getProfit() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());
        long[] answer = new long[testcase];

        for (int i = 0; i < testcase; ++i) {
            int stockDay = Integer.parseInt(br.readLine().trim());
            int maxStockIndex = 0;
            int nextMaxStockIndex;
            int[] stockPrice = new int[stockDay];
            long maxStock = Long.MIN_VALUE;
            long stockSum = 0;
            long profit = 0;
            StringTokenizer st = new StringTokenizer(br.readLine().trim());

            for (int j = 0; j < stockDay; ++j) {
                stockPrice[j] = Integer.parseInt(st.nextToken());
                if (maxStock <= stockPrice[j]) {
                    maxStock = stockPrice[j];
                    maxStockIndex = j;
                }
            }

            for (int j = 0; j < maxStockIndex; ++j) {
                stockSum = stockSum + stockPrice[j];
            }
            profit = profit + maxStock * maxStockIndex - stockSum;
            nextMaxStockIndex = maxStockIndex;

            while (nextMaxStockIndex != stockDay - 1) {
                stockSum = 0;
                nextMaxStockIndex = getNextMaxStockIndex(stockPrice, maxStockIndex);
                for (int j = maxStockIndex + 1; j < nextMaxStockIndex; ++j) {
                    stockSum = stockSum + stockPrice[j];
                }
                maxStock = stockPrice[nextMaxStockIndex];
                if (maxStockIndex + 1 != nextMaxStockIndex) {
                    profit = profit + maxStock * (nextMaxStockIndex - (maxStockIndex + 1)) - stockSum;
                }
                maxStockIndex = nextMaxStockIndex;
            }
            answer[i] = profit;
        }

        for (int i = 0; i < testcase; ++i) {
            System.out.println("#" + (i + 1) + " " + answer[i]);
        }
    }

    public static Integer getNextMaxStockIndex(int[] stockPrice, int oldMaxStockIndex) {
        int maxStock = Integer.MIN_VALUE;
        Integer maxStockIndex = null;

        for (int i = oldMaxStockIndex + 1; i < stockPrice.length; ++i) {
            if (maxStock <= stockPrice[i]) {
                maxStock = stockPrice[i];
                maxStockIndex = i;
            }
        }

        return maxStockIndex;
    }
}
