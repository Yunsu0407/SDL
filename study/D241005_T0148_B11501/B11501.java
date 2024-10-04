package D241005_T0148_B11501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11501 {
    public static void main(String[] args) throws IOException {
        maxProfit();
    }

    public static long[] price;
    public static int days;
    public static long[] sum;

    public static void maxProfit() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int CASE = Integer.parseInt(br.readLine().trim());
        long[] ans = new long[CASE];

        for (int i = 0; i < CASE; ++i) {
            days = Integer.parseInt(br.readLine().trim());
            price = new long[days];
            sum = new long[days];
            StringTokenizer st = new StringTokenizer(br.readLine().trim());

            long max = Integer.MIN_VALUE;
            int maxIndex = 0;
            for (int j = 0; j < days; ++j) {
                price[j] = Integer.parseInt(st.nextToken());
                if(j == 0){
                    sum[j] = price[j];
                } else {
                    sum[j] = sum[j - 1] + price[j];
                }
                if (price[j] >= max) {
                    max = price[j];
                    maxIndex = j;
                }
            }

            long profit = 0;
            if(maxIndex != 0){
                profit = (maxIndex) * price[maxIndex] - sum[maxIndex - 1];
            }
            int index = maxIndex;
            while(index < days){
                int next = getMaxIndex(index);
                if(next - index < 1){
                    break;
                }
                profit = profit + (next - (index+ 1)) * price[next] - (sum[next - 1] - sum[index]);
                index = next;
            }

            ans[i] = profit;
        }
        br.close();

         StringBuilder sb = new StringBuilder();
         for(long curr: ans){
             sb.append(curr).append("\n");
         }
        System.out.println(sb.toString());
    }

    public static int getMaxIndex(int start) {
        long max = Integer.MIN_VALUE;
        int maxIndex = 0;
        for(int i = start + 1; i < days; ++i){
            if(price[i] >= max){
                max = price[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
