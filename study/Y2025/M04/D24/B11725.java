package Y2025.M04.D24;

import java.util.*;
import java.io.*;

public class B11725 {
    public static void main(String[] args) throws IOException {
        getParent();
    }

    public static void getParent() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine().trim());

        List<List<Integer>> graph = new ArrayList<>();
        getData(br, size, graph); // 양방향 그래프 생성 및 값 수령

        int[] parentTable = new int[size + 1];
        findParent(size, graph, parentTable); // 부모 노드 찾기

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < size + 1; ++i) {
            sb.append(parentTable[i]).append("\n");
        }
        System.out.println(sb.toString());
    }

    // 부모 노드 찾기
    public static void findParent (int size, List<List<Integer>> graph, int[] parentTable) {
        Queue<Integer> queue = new ArrayDeque<>();
        final int ROOT = 1;

        parentTable[ROOT] = ROOT;
        queue.add(ROOT);

        while (!queue.isEmpty()) {
            int currParent = queue.remove();

            for (int child : graph.get(currParent)) {
                if (parentTable[child] == 0) { // 부모가 없으면
                    parentTable[child] = currParent;
                    queue.add(child);
                }
            }
        }
    }

    // 양방향 그래프 생성 및 값 수령
    public static void getData(BufferedReader br, int size, List<List<Integer>> graph) throws IOException {
        // 양방향 그래프 초기화
        for (int i = 0; i < size + 1; ++i) {
            graph.add(new ArrayList<>());
        }

        // 그래프에 값 저장
        for (int i = 0; i < size - 1; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }
    }
}
