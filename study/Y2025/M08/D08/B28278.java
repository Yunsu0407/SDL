package Y2025.M08.D08;

import java.util.*;
import java.io.*;

public class B28278 {
    public static void main(String[] args) throws IOException {
        stack2();
    }

    public static void stack2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int orderSize = Integer.parseInt(br.readLine().trim());
        List<Integer> stack = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < orderSize; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int order = Integer.parseInt(st.nextToken());

            if (order == 1) {
                int num = Integer.parseInt(st.nextToken());
                stack.add(num);
            } else if (order == 2) {
                int last = stack.size() - 1;
                int output = stack.isEmpty() ? -1 : stack.remove(last);
                sb.append(output).append("\n");
            } else if (order == 3) {
                sb.append(stack.size()).append("\n");
            } else if (order == 4) {
                int output = stack.isEmpty() ? 1 : 0;
                sb.append(output).append("\n");
            } else { // order == 5
                int last = stack.size() - 1;
                int output = stack.isEmpty() ? -1 : stack.get(last);
                sb.append(output).append("\n");
            }
        }

        System.out.print(sb.toString());
    }
}
