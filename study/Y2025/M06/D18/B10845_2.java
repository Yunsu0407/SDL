package study.Y2025.M06.D18;

import java.util.*;
import java.io.*;

public class B10845_2 {
    public static void main(String[] args) throws IOException {
        useQueue();
    }

    public static String input1 = "15\n" +
            "push 1\n" +
            "push 2\n" +
            "front\n" +
            "back\n" +
            "size\n" +
            "empty\n" +
            "pop\n" +
            "pop\n" +
            "pop\n" +
            "size\n" +
            "empty\n" +
            "pop\n" +
            "push 3\n" +
            "empty\n" +
            "front";

    public static void useQueue() throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader(input1));
        int size = Integer.parseInt(br.readLine().trim());
        Deque<Integer> queue = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < size; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            String order = st.nextToken();
            Integer value;
            switch (order) {
                case "push":
                    value = Integer.parseInt(st.nextToken());
                    queue.add(value);
                    break;
                case "pop":
                    value = queue.isEmpty() ? -1 : queue.poll();
                    sb.append(value).append("\n");
                    break;
                case "size":
                    value = queue.size();
                    sb.append(value).append("\n");
                    break;
                case "empty":
                    value = queue.isEmpty() ? 1 : 0;
                    sb.append(value).append("\n");
                    break;
                case "front":
                    value = queue.isEmpty() ? -1 : queue.peekFirst();
                    sb.append(value).append("\n");
                    break;
                case "back":
                    value = queue.isEmpty() ? -1 : queue.peekLast();
                    sb.append(value).append("\n");
                    break;
            }
        }

        System.out.print(sb.toString());
    }
}
