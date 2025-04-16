package study.Y2025.M04.D08;

import java.util.*;
import java.io.*;

public class B18870 {
    public static void main(String[] args) throws IOException {
        compressOrd();
    }

    public static class Ord implements Comparable<Ord> {
        int value;
        int index;

        public Ord(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Ord other) {
            return Integer.compare(this.value, other.value);
        }
    }

    public static void compressOrd() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine().trim());
        Ord[] ords = new Ord[size];

        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < size; ++i) {
            int value = Integer.parseInt(st.nextToken());
            ords[i] = new Ord(value, i);
        }

        Arrays.sort(ords);

        int[] ans = new int[size];
        int count = -1, prev = Integer.MIN_VALUE;
        for (Ord curr : ords) {
            if (curr.value > prev) {
                ++count;
            }

            prev = curr.value;
            ans[curr.index] = count;
        }

        StringBuilder sb = new StringBuilder();
        for (int curr : ans) {
            sb.append(curr).append(" ");
        }

        System.out.println(sb.toString());
    }
}
