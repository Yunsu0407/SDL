package Y2026.M04.D19;

import java.util.*;
import java.io.*;

public class B1874 {
    public static void main(String[] args) throws IOException {
        stackSeq();
    }

    public static void stackSeq() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine().trim());

        Stack<Integer> stack = new Stack<>();
        int count = 0;
        StringBuilder sb = new StringBuilder();
        boolean isPossible = true;
        for (int i = 0; i < size; ++i) {
            int curr = Integer.parseInt(br.readLine().trim()); // 4
            int top = stack.isEmpty() ? -1 : stack.peek(); // 1

            if (curr > top) {
                if (curr > count) { // 넣으면 됨
                    while (count != curr) {
                        count = count + 1;
                        stack.push(count);
                        sb.append("+").append("\n");
                    }

                    stack.pop();
                    sb.append("-").append("\n");
                } else { // 불가능
                    isPossible = false;
                    break;
                }
            } else if (curr == top) {
                stack.pop();
                sb.append("-").append("\n");
            } else { // curr < top
                isPossible = false;
            }
        }

        if (!isPossible) {
            sb = new StringBuilder("NO");
        }

        System.out.println(sb.toString());
    }
}
