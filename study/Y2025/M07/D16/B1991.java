package study.Y2025.M07.D16;

import java.util.*;
import java.io.*;

public class B1991 {
    public static void main(String[] args) throws IOException {
        traversal();
    }

    public static class Node {
        char base;
        char left;
        char right;

        public Node(char base, char left, char right) {
            this.base = base;
            this.left = left;
            this.right = right;
        }
    }

    public static void traversal() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine().trim());
        Node[] tree = new Node[size];

        for (int i = 0; i < size; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            char base = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            int baseIdx = base - 'A';

            tree[baseIdx] = new Node(base, left, right);
        }

        preorderTraversal(tree, 0);
        sb.append("\n");

        inorderTraversal(tree, 0);
        sb.append("\n");

        postorderTraversal(tree, 0);
        sb.append("\n");

        System.out.print(sb.toString());
    }

    public static StringBuilder sb = new StringBuilder();

    public static void preorderTraversal(Node[] tree, int baseIdx) {
        char base = tree[baseIdx].base;
        char left = tree[baseIdx].left;
        char right = tree[baseIdx].right;

        sb.append(base);

        if (left != '.') {
            int leftIdx = left - 'A';
            preorderTraversal(tree, leftIdx);
        }

        if (right != '.') {
            int rightIdx = right - 'A';
            preorderTraversal(tree, rightIdx);
        }
    }

    public static void inorderTraversal(Node[] tree, int baseIdx) {
        char base = tree[baseIdx].base;
        char left = tree[baseIdx].left;
        char right = tree[baseIdx].right;

        if (left != '.') {
            int leftIdx = left - 'A';
            inorderTraversal(tree, leftIdx);
        }

        sb.append(base);

        if (right != '.') {
            int rightIdx = right - 'A';
            inorderTraversal(tree, rightIdx);
        }
    }

    public static void postorderTraversal(Node[] tree, int baseIdx) {
        char base = tree[baseIdx].base;
        char left = tree[baseIdx].left;
        char right = tree[baseIdx].right;

        if (left != '.') {
            int leftIdx = left - 'A';
            postorderTraversal(tree, leftIdx);
        }

        if (right != '.') {
            int rightIdx = right - 'A';
            postorderTraversal(tree, rightIdx);
        }

        sb.append(base);
    }
}
