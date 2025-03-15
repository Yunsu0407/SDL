package study.Y2025.M03.D14;

import java.util.*;
import java.io.*;

public class B15657 {
    public static void main(String[] args) throws IOException {
        calculate();
    }

    public static StringBuilder sb = new StringBuilder();
    public static int[] numbers;

    public static void calculate() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int size = Integer.parseInt(st.nextToken());
        int limit = Integer.parseInt(st.nextToken());
        numbers = new int[size];

        st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < size; ++i) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);

        for (int i = 0; i < size; ++i) {
            String start = numbers[i] + " ";
            recursive(i, start, limit - 1);
        }

        System.out.println(sb.toString());
    }

    public static void recursive(int index, String sequence, int count) {
        if (count > 0) {
            for (int i = index; i < numbers.length; ++i) {
                String nextSeq = sequence + numbers[i] + " ";
                recursive(i, nextSeq, count - 1);
            }
        } else {
            sb.append(sequence).append("\n");
        }
    }
}
