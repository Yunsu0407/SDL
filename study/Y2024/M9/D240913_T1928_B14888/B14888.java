package study.Y2024.M9.D240913_T1928_B14888;

import java.io.*;
import java.util.*;

public class B14888 {
    public static void main(String[] args) throws IOException {
        embeddingOperator();
    }

    public static int n;
    public static int[] numbers;

    public static void embeddingOperator() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());
        numbers = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < n; ++i) {
            int curr = Integer.parseInt(st.nextToken());
            numbers[i] = curr;
        }

        final int KIND = 4;
        int[] operators = new int[KIND];
        st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < KIND; ++i) {
            int curr = Integer.parseInt(st.nextToken());
            operators[i] = curr;
        }

        int count = 0;
        int sum = numbers[0];
        searchExtremal(++count, operators, sum);
        System.out.printf("%d\n%d",max,min);
    }

    public static int max = Integer.MIN_VALUE;
    public static int min = Integer.MAX_VALUE;
    public static final int ADD = 0;
    public static final int SUB = 1;
    public static final int MUL = 2;
    public static final int DIV = 3;

    public static void searchExtremal(int count, int[] operators, int sum) {
        if (count == n - 1) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
        }

        if (operators[ADD] > 0) {
            --operators[ADD];
            sum = sum + numbers[count];
            searchExtremal(++count, operators, sum);
            ++operators[ADD];
        }
        if (operators[SUB] > 0) {
            --operators[SUB];
            sum = sum - numbers[count];
            searchExtremal(++count, operators, sum);
            ++operators[SUB];

        }
        if (operators[MUL] > 0) {
            --operators[MUL];
            sum = sum * numbers[count];
            searchExtremal(++count, operators, sum);
            ++operators[MUL];

        }
        if (operators[DIV] > 0) {
            --operators[DIV];
            sum = sum / numbers[count];
            searchExtremal(++count, operators, sum);
            ++operators[DIV];
        }
    }
}
