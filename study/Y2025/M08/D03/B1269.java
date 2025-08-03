package study.Y2025.M08.D03;

import java.util.*;
import java.io.*;

public class B1269 {
    public static void main(String[] args) throws IOException {
        symmetrySetDifference();
    }

    public static void symmetrySetDifference() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int sizeA = Integer.parseInt(st.nextToken());
        int sizeB = Integer.parseInt(st.nextToken());

        Set<Integer> setA = new HashSet<>();
        st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < sizeA; ++i) {
            int value = Integer.parseInt(st.nextToken());
            setA.add(value);
        }

        int count = 0;
        st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < sizeB; ++i) {
            int value = Integer.parseInt(st.nextToken());
            if(setA.contains(value)) {
                setA.remove(value);
            } else {
                ++count;
            }
        }
        count = count + setA.size();

        System.out.print(count);
    }
}
