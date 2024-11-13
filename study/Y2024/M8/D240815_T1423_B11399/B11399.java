package D240815_T1423_B11399;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class B11399 {
    public static void main(String[] args) throws IOException {
        calculateMinTime();
    }

    public static void calculateMinTime() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int SIZE = Integer.parseInt(br.readLine().trim());
        ArrayList<Integer> time = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        br.close();

        for (int i = 0; i < SIZE; ++i) {
            int curr = Integer.parseInt(st.nextToken());
            time.add(curr);
        }
        Collections.sort(time);

        int min = 0;
        int index = SIZE;
        for (int curr : time) {
            min = min + curr * (index--);
        }

        System.out.printf("%d", min);
    }
}
