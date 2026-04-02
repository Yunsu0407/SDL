package Y2026.M04;

import java.util.*;
import java.io.*;

public class B10828 {
    public static void main(String[] args) throws IOException {
        stack();
    }

    public static void stack() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine().trim());

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            String order = st.nextToken();
            if (order.equals("push")) {
                int val = Integer.parseInt(st.nextToken());
                stack.push(val);
            } else if (order.equals("pop")) {
                int val = stack.isEmpty() ? -1 : stack.pop();
                sb.append(val).append("\n");
            } else if (order.equals("size")) {
                int val = stack.size();
                sb.append(val).append("\n");
            } else if (order.equals("empty")) {
                int val = stack.isEmpty() ? 1 : 0;
                sb.append(val).append("\n");
            } else { // top
                int val = stack.isEmpty() ? -1 : stack.peek();
                sb.append(val).append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}
