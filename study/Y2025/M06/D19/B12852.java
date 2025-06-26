package study.Y2025.M06.D19;

import java.util.*;
import java.io.*;

public class B12852 {
    public static void main(String[] args) throws IOException {
        makeItOne();
    }

    public static String input1 = "10";

    public static class Block implements Comparable<Block> {
        int value;
        int count;
        List<Integer> seq;

        public Block(int value, int count, List<Integer> seq) {
            this.value = value;
            this.count = count;
            this.seq = new ArrayList<>(seq);
            this.seq.add(value);
        }

        @Override
        public int compareTo(Block other) {
            return Integer.compare(other.value, this.value);
        }
    }

    public static void makeItOne() throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader(input1));
        int target = Integer.parseInt(br.readLine().trim());

        final int V = 0, C = 1;
        int minCount = Integer.MAX_VALUE;

        int[] visit = new int[target + 1];
        Arrays.fill(visit, Integer.MAX_VALUE);

        Queue<Block> queue = new PriorityQueue<>();
        visit[1] = 0;
        queue.offer(new Block(1, 0, new ArrayList<>()));

        Block ans = null;

        while (!queue.isEmpty()) {
            Block block = queue.poll();
            int value = block.value;
            int count = block.count;
            List<Integer> seq = block.seq;

            if (count > minCount) {
                continue;
            }

            if (value == target) {
                minCount = count;
                ans = block;
            }

            count = count + 1;
            int mul3 = value * 3;
            if (mul3 <= target && count < visit[mul3]) {
                visit[mul3] = count;
                queue.add(new Block(mul3, count, seq));
            }

            int mul2 = value * 2;
            if (mul2 <= target && count < visit[mul2]) {
                visit[mul2] = count;
                queue.add(new Block(mul2, count, seq));
            }

            int add1 = value + 1;
            if (add1 <= target && count < visit[add1]) {
                visit[add1] = count;
                queue.add(new Block(add1, count, seq));
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(ans.count).append("\n");
        for (int i = ans.seq.size() - 1; i >= 0; --i) {
            sb.append(ans.seq.get(i)).append(" ");
        }
        System.out.println(sb.toString());
    }

}
