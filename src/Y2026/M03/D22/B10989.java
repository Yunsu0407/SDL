package Y2026.M03.D22;

import java.util.*;
import java.io.*;

public class B10989 {
    public static void main(String[] args) throws IOException {
        arrangeNumbers();
    }

    public static void arrangeNumbers() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine().trim());

        int[] arr = new int[size];
        for (int i = 0; i < size; ++i) {
            int curr = Integer.parseInt(br.readLine().trim());
            arr[i] = curr;
        }

        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (int curr : arr) {
            sb.append(curr).append("\n");
        }
        System.out.println(sb.toString());
    }
}
