package solutions.stage3.D240711_T1002_S1231;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class S1231 {
    public static void main(String[] args) throws IOException {
        prnWord();
    }

    public static void prnWord() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int TESTCASE = 10;
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < TESTCASE; ++i) {
            final int total = Integer.parseInt(br.readLine().trim());
            Node root = null;
            Queue<Node> queue = new LinkedList<>();
            for (int j = 0; j < total; ++j) {
                StringTokenizer st = new StringTokenizer(br.readLine().trim());
                st.nextToken();
                String data = st.nextToken();
                Node newNode = new Node(data);

                if (root == null) {
                    root = newNode;
                } else {
                    Node curr = queue.peek();
                    if (!curr.isAvail()) {
                        queue.poll();
                        curr = queue.peek();
                    }
                    curr.addChild(newNode);
                }
                queue.add(newNode);
            }   // 완전 이진 트리 설정 완료

            StringBuilder sb = new StringBuilder();
            if (root != null) {
                root.prnWord(sb);
            }
            answer.append(String.format("#%d %s\n", i + 1, sb));
        }
        br.close();

        System.out.printf("%s", answer.toString());
    }

    public static class Node {
        private String data;
        private Node left;
        private Node right;

        public Node(String data) {
            this.data = data;
            this.left = this.right = null;
        }

        public boolean isAvail() {
            return this.left == null || this.right == null;
        }

        public void addChild(Node child) {
            if (this.left == null) {
                this.left = child;
            } else {
                this.right = child;
            }
        }

        public void prnWord(StringBuilder sb) {
            // 경우 1. 왼 오
            // 경우 2. 왼
            // 경우 3. 무

            if (this.left != null && this.right != null) {    // 왼 오
                this.left.prnWord(sb);
                sb.append(this.data);
                this.right.prnWord(sb);
            }
            if (this.left != null && this.right == null) {    // 왼
                this.left.prnWord(sb);
                sb.append(this.data);
            }
            if (this.left == null && this.right == null) {    // 무
                sb.append(this.data);
            }
        }
    }
}
