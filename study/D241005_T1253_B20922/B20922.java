package study.D241005_T1253_B20922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B20922 {
    public static void main(String[] args) throws IOException {
        getMaxLength();
    }

    public static int size;
    public static int limit;
    public static int[] numbers;

    public static void getMaxLength() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        size = Integer.parseInt(st.nextToken());
        limit = Integer.parseInt(st.nextToken());
        numbers = new int[size];

        HashMap<Integer, Integer> myMap = new HashMap<>();
        st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < size; ++i) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        

        br.close();
    }
}
