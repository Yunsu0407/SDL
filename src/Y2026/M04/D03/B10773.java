package Y2026.M04.D03;

import java.util.*;
import java.io.*;

public class B10773 {
    public static void main(String[] args) throws IOException {
        zero();
    }

    public static void zero() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine().trim());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < size; ++i) {
            int curr = Integer.parseInt(br.readLine().trim());
            if (curr == 0) {
                stack.remove(stack.size() - 1);
            } else {
                stack.add(curr);
            }
        }

        int sum = 0;
        for (int curr : stack) {
            sum = sum + curr;
        }
        System.out.println(sum);
    }
}
