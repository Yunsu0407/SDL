package study.Y2025.M06.D18;

import java.util.*;
import java.io.*;

public class B10845 {
    public static void main(String[] args) throws IOException {
        customQueue();
    }

    public static class Node {
        Node front;
        Node back;
        Integer value;

        public Node(Node front, Node back, Integer value) {
            this.front = front;
            this.back = back;
            this.value = value;
        }
    }

    public static class MyQueue {
        StringBuilder sb;
        Node root;

        public MyQueue() {
            sb = new StringBuilder();
            root = new Node(null, null, null);
            root.front = root.back = root;
        }

        public void push(int value) {
            Node chase = root;
            while (true) {
                if (chase.back == root) {
                    Node node = new Node(chase, root, value);
                    chase.back = node;
                    root.front = node;
                    break;
                } else {
                    chase = chase.back;
                }
            }
        }

        public void pop() {
            if (root.front == root && root.back == root) {
                sb.append("-1");
            } else {
                Node remove = root.back;
                Node connect = remove.back;

                root.back = connect;
                connect.front = root;
                sb.append(remove.value);
            }
            sb.append("\n");
        }

        public void size() {
            Node chase = root;
            int count = 0;
            while (chase.back != root) {
                chase = chase.back;
                ++count;
            }
            sb.append(count).append("\n");
        }

        public void empty() {
            if (root.front == root && root.back == root) {
                sb.append("1");
            } else {
                sb.append("0");
            }
            sb.append("\n");
        }

        public void front() {
            if (root.front == root && root.back == root) {
                sb.append("-1");
            } else {
                sb.append(root.back.value);
            }
            sb.append("\n");
        }

        public void back() {
            if (root.front == root && root.back == root) {
                sb.append("-1");
            } else {
                sb.append(root.front.value);
            }
            sb.append("\n");
        }

        @Override
        public String toString() {
            return sb.toString();
        }
    }

    public static void customQueue() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numOfOrd = Integer.parseInt(br.readLine().trim());
        String[] orders = new String[numOfOrd];

        for (int i = 0; i < numOfOrd; ++i) {
            orders[i] = br.readLine().trim();
        }

        MyQueue queue = new MyQueue();

        handleOrders(queue, orders);

        System.out.println(queue.toString());
    }

    public static void handleOrders(MyQueue queue, String[] orders) {
        for (int i = 0; i < orders.length; ++i) {
            StringTokenizer st = new StringTokenizer(orders[i]);
            String order = st.nextToken();
            switch (order) {
                case "push":
                    int value = Integer.parseInt(st.nextToken());
                    queue.push(value);
                    break;
                case "pop":
                    queue.pop();
                    break;
                case "size":
                    queue.size();
                    break;
                case "empty":
                    queue.empty();
                    break;
                case "front":
                    queue.front();
                    break;
                case "back":
                    queue.back();
                    break;
            }
        }
    }
}
