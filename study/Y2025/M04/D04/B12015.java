package study.Y2025.M04.D04;

import java.util.*;
import java.io.*;

public class B12015 {
    public static void main(String[] args) throws IOException {
        getMaxSeries();
    }

    public static String input1 = "6\n" +
            "10 20 10 30 20 50"; // ans = 4

    /*
    N은 1이상 백만이하
    A(i)는 1이상 백만이하

    Map<Integer,Integer> archive = new TreeMap<>();
    archive.put(last, count);
     */


    public static void getMaxSeries() throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader(input1));
        int size = Integer.parseInt(br.readLine().trim());
        int[] numbers = new int[size];

        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < size; ++i) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for (int i = 0; i < size; ++i) {
            int prev = numbers[i];
            int count = 1;
            for (int j = i + 1; j < size; ++j) {
                int next = numbers[j];
                if (next > prev) {
                    ++count;
                    prev = next;
                }
            }
            max = Math.max(max, count);
        }

        System.out.println(max);
    }
}
