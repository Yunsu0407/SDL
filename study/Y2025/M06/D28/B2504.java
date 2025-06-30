package study.Y2025.M06.D28;

import java.util.*;
import java.io.*;

public class B2504 {
    public static void main(String[] args) throws IOException {
        bracketValue();
    }

    public static String input1 = "(()[[]])([])"; // 28

    public static String input2 = "[][]((])"; // 0

    public static String input3 = "[()]";

    public static String input4 = "[]]]";


    public static void bracketValue() throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader(input4));
        String str = br.readLine().trim();
        Deque<String> queue = new ArrayDeque<>();

        for (int i = 0; i < str.length(); ++i) {
            String s = str.substring(i, i + 1);
            queue.offer(s);
        }

        int ans, sCheck, lCheck;
        while (true) {
            sCheck = lCheck = 0;
            String prev2 = null, prev = null, curr = null;
            Deque<String> temp = new ArrayDeque<>();

            while (!queue.isEmpty()) {
                curr = queue.poll();

                if (prev == null) {
                    prev = curr;
                    continue;
                }

                if (prev.equals("(")) {
                    ++sCheck;

                    if (curr.equals(")")) {
                        prev = "2";
                    } else if (isValue(curr)) {
                        prev2 = prev;
                        prev = curr;
                    } else {
                        temp.offer(prev);
                        prev = curr;
                    }
                } else if (prev.equals(")")) {
                    --sCheck;

                    temp.offer(prev);
                    prev = curr;
                } else if (prev.equals("[")) {
                    ++lCheck;

                    if (curr.equals("]")) {
                        prev = "3";
                    } else if (isValue(curr)) {
                        prev2 = prev;
                        prev = curr;
                    } else {
                        temp.offer(prev);
                        prev = curr;
                    }
                } else if (prev.equals("]")) {
                    --lCheck;

                    temp.offer(prev);
                    prev = curr;
                } else { // prev = value
                    if (isValue(curr)) { // prev = value, curr = value
                        int value = Integer.parseInt(prev) + Integer.parseInt(curr);
                        prev = String.format("%d", value);
                    } else { // prev = value, curr != value
                        if (prev2 != null) { // prev2 != null, prev = value, curr != value
                            if (prev2.equals("(")) {
                                if (isValue(prev)) {
                                    if (curr.equals(")")) {
                                        --sCheck;
                                        prev2 = null;
                                        int value = Integer.parseInt(prev) * 2;
                                        prev = String.format("%d", value);
                                    } else {
                                        temp.offer(prev2);
                                        temp.offer(prev);
                                        prev2 = null;
                                        prev = curr;
                                    }
                                }
                            } else if (prev2.equals("[")) {
                                if (isValue(prev)) {
                                    if (curr.equals("]")) {
                                        --lCheck;
                                        prev2 = null;
                                        int value = Integer.parseInt(prev) * 3;
                                        prev = String.format("%d", value);
                                    } else {
                                        temp.offer(prev2);
                                        temp.offer(prev);
                                        prev2 = null;
                                        prev = curr;
                                    }
                                }
                            }
                        } else { // prev2 == null, prev = value, curr != value
                            if (curr.equals("(")) {
                                ++sCheck;
                            } else if (curr.equals(")")) {
                                --sCheck;
                            } else if (curr.equals("[")) {
                                ++lCheck;
                            } else if (curr.equals("]")) {
                                --lCheck;
                            }

                            temp.offer(prev);
                            prev = curr;
                        }
                    }
                }

                if (sCheck < 0 || lCheck < 0) {
                    ans = 0;
                    break;
                }
            }

            temp.offer(prev);
            queue = temp;
            if (queue.size() == 1) {
                if (sCheck != 0 || lCheck != 0) {
                    ans = 0;
                } else {
                    ans = Integer.parseInt(queue.poll());
                }
                break;
            }
        }

        if (sCheck != 0 || lCheck != 0) {
            ans = 0;
        }

        System.out.println(ans);
    }

    public static boolean isValue(String s) {
        return !(s.equals("(") || s.equals(")") || s.equals("[") || s.equals("]"));
    }
}
