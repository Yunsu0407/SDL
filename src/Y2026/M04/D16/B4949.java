package Y2026.M04.D16;

import java.util.*;
import java.io.*;

public class B4949 {
    public static void main(String[] args) throws IOException {
        balancedWorld();
    }

    public static void balancedWorld() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = br.readLine();
            int len = line.length();
            if (len == 1) {
                break;
            }

            boolean isPossible = true;
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < len; ++i) {
                char curr = line.charAt(i);

                if (curr == '(' || curr == '[') {
                    stack.push(curr);
                } else if (curr == ')' || curr == ']') {
                    if (stack.isEmpty()) {
                        isPossible = false;
                        break;
                    }

                    char prev = stack.pop();
                    if ((curr == ')' && prev != '(') || ((curr == ']') && prev != '[')) {
                        isPossible = false;
                        break;
                    }
                }
            }

            if (!stack.isEmpty()) {
                isPossible = false;
            }

            String ans = isPossible ? "yes" : "no";
            sb.append(ans).append("\n");
        }

        System.out.println(sb.toString());
    }
}
