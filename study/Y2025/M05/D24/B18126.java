package study.Y2025.M05.D24;

import java.util.*;
import java.io.*;

public class B18126 {
    public static void main(String[] args) throws IOException {
        racoonGugu();
    }

    public static String input1 = "4\n" +
            "1 2 3\n" +
            "2 3 2\n" +
            "2 4 4";
    // ans = 7

    /*
    1. 1부터 N(~5000)개 까지의 방이 있음
    2. 입구는 1번임
    3. 모든 방들은 N-1개의 길로 연결됨
    4. 입구에서 가장 먼 방에 숨김
    5. 양방향 연결됨

    입력
    N: 방의 개수
    A B C: A번 방, B번 방, 방 사이의 거리
     */

    public static void racoonGugu() throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader(input1));
        int size = Integer.parseInt(br.readLine().trim());
        List<long[]>[] graph = new ArrayList[size + 1];

        for (int i = 0; i < graph.length; ++i) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < size - 1; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[n1].add(new long[]{n2, cost});
            graph[n2].add(new long[]{n1, cost});
        }

        boolean[] visit = new boolean[size + 1];
        Queue<long[]> queue = new ArrayDeque<>();
        queue.add(new long[]{1, 0});
        visit[1] = true;

        long max = 0;

        while (!queue.isEmpty()) {
            long[] curr = queue.remove();

            List<long[]> nextNodeInfo = graph[(int) curr[0]];

            boolean possible = false;

            for (long[] nextOne : nextNodeInfo) {
                int nextNode = (int) nextOne[0];
                long nextCost = nextOne[1];

                possible = possible || !visit[nextNode];

                if (!visit[nextNode]) {
                    visit[nextNode] = true;
                    queue.add(new long[]{nextNode, curr[1] + nextCost});
                }
            }

            if(!possible) {
                max = Math.max(max, curr[1]);
            }
        }
        System.out.println(max);
    }
}
