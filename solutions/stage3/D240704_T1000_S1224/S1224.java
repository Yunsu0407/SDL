package solutions.stage3.D240704_T1000_S1224;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class S1224 {
    public static void main(String[] args) throws IOException {
        changeExpression();
    }

    public static void changeExpression() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int TESTCASE = 1;
        String[] postfix = new String[TESTCASE];
        int[] answer = new int[TESTCASE];

        for (int i = 0; i < TESTCASE; ++i) {
            int length = Integer.parseInt(br.readLine().trim());
            String expr = br.readLine().trim();
//            String expr = "2+4*(3+2)+3*(4+2)";
            postfix[i] = infixToPostfix(expr);
            answer[i] = calculatePostfix(postfix[i]);
        }

        for (int i = 0; i < TESTCASE; ++i) {
            System.out.printf("#%d %d\n", i + 1, answer[i]);
//            System.out.printf("#%d Ans: %d, Postfix: %s\n", i + 1, answer[i], postfix[i]);
        }
    }

    public static String infixToPostfix(String expr) {
        int length = expr.length();
        StringBuilder sb = new StringBuilder();
        LinkedList<Character> operator = new LinkedList<>();

        for (int i = 0; i < length; ++i) {
            char current = expr.charAt(i);
            if (current >= '0' && current <= '9') { // 숫자인 경우
                sb.append(current);
            } else {
                char top;
                if (operator.isEmpty() || (top = operator.peek()) == '(') {
                    operator.addFirst(current);
                } else {
                    if (current == '+') {
                        top = operator.peek();
                        while ((top == current || top == '*')) { // 연산자 우선순위가 낮아질 때까지
                            char remove = operator.removeFirst();
                            sb.append(remove);
                            if (operator.isEmpty()) {
                                break;
                            } else {
                                top = operator.peek();
                            }
                        }
                        operator.addFirst(current);
                    } else if (current == '*') {
                        top = operator.peek();
                        while (top == current) {    // +(+(*
                            char remove = operator.removeFirst();
                            sb.append(remove);
                            if (operator.isEmpty()) {
                                break;
                            } else {
                                top = operator.peek();
                            }
                        }
                        operator.addFirst(current);
                    } else if (current == '(') {
                        operator.addFirst(current);
                    } else { // current == ')'
                        top = operator.removeFirst();
                        while (top != '(') {
                            sb.append(top);
                            top = operator.removeFirst();
                        }
                    }
                }
            }
        }

        while (!operator.isEmpty()) {
            sb.append(operator.removeFirst());
        }

        return sb.toString();
    }

    public static int calculatePostfix(String postfix) {
        int length = postfix.length();
        LinkedList<Integer> digit = new LinkedList<>();
        for (int i = 0; i < length; ++i) {
            char current = postfix.charAt(i);
            if (current >= '0' && current <= '9') { // digit
                digit.addFirst(current - '0');
            } else {
                int top = digit.removeFirst();
                int nextTop = digit.removeFirst();
                if (current == '+') {
                    top = top + nextTop;
                } else {    // current == '*'
                    top = top * nextTop;
                }
                digit.addFirst(top);
            }
        }
        return digit.removeFirst();
    }
}
