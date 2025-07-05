package study.Y2025.M07.D02;

import java.util.*;
import java.io.*;

public class B2042 {
    public static void main(String[] args) throws IOException {
        getLocalSum();
    }

    public static void getLocalSum() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int numSize = Integer.parseInt(st.nextToken());
        int changeSize = Integer.parseInt(st.nextToken());
        int sumSize = Integer.parseInt(st.nextToken());

        long[] number = new long[numSize + 1];
        for (int i = 0; i < numSize; ++i) {
            number[i + 1] = Long.parseLong(br.readLine().trim());
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < changeSize + sumSize; ++i) {
            st = new StringTokenizer(br.readLine().trim());
            int order = Integer.parseInt(st.nextToken());
            long val1 = Long.parseLong(st.nextToken());
            long val2 = Long.parseLong(st.nextToken());

            if(order == 1) {
                number[(int) val1] = val2;
            } else {
                long locSum = getSum(number, val1, val2);
                sb.append(locSum).append("\n");
            }
        }

        System.out.println(sb.toString());
    }

    public static long getSum(long[] number, long start, long end) {
        long ret = 0;

        for(int i = (int)start; i <= (int)end; ++i) {
            ret = ret + number[i];
        }

        return ret;
    }
}

