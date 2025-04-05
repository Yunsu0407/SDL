package study.Y2025.M04.D05;

import java.util.*;
import java.io.*;

public class B12015 {
    public static void main(String[] args) throws IOException {
        getMaxSeries();
    }

    public static void getMaxSeries() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine().trim());
        int[] numbers = new int[size];

        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < size; ++i) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> lis = new ArrayList<>();
        int i = 0;
        lis.add(numbers[i]);
        for (i = 1; i < size; ++i) {
            int curr = numbers[i];
            int last = lis.get(lis.size() - 1);
            if (curr > last) {
                lis.add(curr);
            } else if (curr == last) {
                continue;
            } else { // curr < last
                binarySearch(lis, curr, 0, lis.size()-1);
            }
        }

        System.out.println(lis.size());
    }

    public static void binarySearch (List<Integer> lis, int prev, int first, int last) {
        int mid = (last + first) / 2;
        int curr = lis.get(mid);
        if(last - first > 0) {
            if(prev > curr) {
                binarySearch(lis, prev, mid + 1, last);
            } else if(prev < curr) {
                binarySearch(lis, prev, first, mid);
            }
        } else { // last - first = 0
            if(prev < curr) {
                lis.set(mid, prev);
            }
        }
    }
}
