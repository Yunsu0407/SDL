package D240913_T1928_B14888;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class B14888 {
    public static void main(String[] args) throws IOException {
        embeddingOperator();
    }

    public static void embeddingOperator() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();  // N 제거
        StringTokenizer st1 = new StringTokenizer(br.readLine().trim());
        StringTokenizer st2 = new StringTokenizer(br.readLine().trim());
        br.close();
        Operator operator = new Operator(st1, st2);
        int max = operator.getMax();
        int min = operator.getMin();
        System.out.printf("%d\n%d", max, min);
    }

    public static class Operator {
        private ArrayList<Integer> numbers;
        private boolean[] bOprt;
        private int[] oprt;
        private final int ADD = 0;
        private final int SUB = 1;
        private final int MUL = 2;
        private final int DIV = 3;

        public Operator(StringTokenizer st1, StringTokenizer st2) {
            numbers = new ArrayList<>();
            while (st1.hasMoreTokens()) {
                int curr = Integer.parseInt(st1.nextToken());
                numbers.add(curr);
            }
            Collections.sort(numbers);  // asc

            final int KIND = 4;
            bOprt = new boolean[KIND];
            oprt = new int[KIND];
            for (int i = 0; i < KIND; ++i) {
                int curr = Integer.parseInt(st2.nextToken());
                if (curr != 0) {
                    bOprt[i] = true;
                    oprt[i] = curr;
                }
            }
        }

        public int getMax() {
            int max = 0;



            return max;
        }

        public int getMin() {
            int min = 0;



            return min;
        }
    }
}
