package study.Y2025.M07.D05;

import java.util.*;
import java.io.*;

public class B11657 {
    public static void main(String[] args) throws IOException {
        timeMachine();
    }

    public static String input1 = "3 4\n" +
            "1 2 4\n" +
            "1 3 3\n" +
            "2 3 -1\n" +
            "3 1 -2"; // 4 3

    public static String input2 = "3 4\n" +
            "1 2 4\n" +
            "1 3 3\n" +
            "2 3 -4\n" +
            "3 1 -2"; // -1

    public static String input3 = "3 2\n" +
            "1 2 4\n" +
            "1 2 3"; // 3 -1

    public static String input4 = "2 2\n" +
            "1 2 2\n" +
            "1 2 5\n"; // 2

    public static class Edge {
        Map<Integer, Integer> edges;

        public Edge() {
            edges = new HashMap<>();
        }

        public void add(int dst, int cost) {
            if (edges.containsKey(dst)) {
                if (cost < edges.get(dst)) {
                    edges.put(dst, cost);
                }
            } else {
                edges.put(dst, cost);
            }
        }
    }

    public static void timeMachine() throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader(input4));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int nodeSize = Integer.parseInt(st.nextToken());
        int edgeSize = Integer.parseInt(st.nextToken());
        Map<Integer, Edge> graph = new HashMap<>();

        for (int i = 0; i < edgeSize; ++i) {
            st = new StringTokenizer(br.readLine().trim());
            int src = Integer.parseInt(st.nextToken()) - 1;
            int dst = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());

            Edge edge;
            if (graph.containsKey(src)) {
                edge = graph.get(src);
            } else {
                edge = new Edge();
            }
            edge.add(dst, cost);
            graph.put(src, edge);
        }

        long[] dist = new long[nodeSize];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        for (int i = 0; i < nodeSize - 1; ++i) {
            for (Map.Entry<Integer, Edge> entry : graph.entrySet()) {
                int src = entry.getKey();
                Edge edge = entry.getValue();
                for (Map.Entry<Integer, Integer> entry2 : edge.edges.entrySet()) {
                    int dst = entry2.getKey();
                    int cost = entry2.getValue();
                    if (dist[src] != Integer.MAX_VALUE && dist[src] + cost < dist[dst]) {
                        dist[dst] = dist[src] + cost;
                    }
                }
            }
        }

        boolean isNegCyc = false;
        finalLoop:
        for (Map.Entry<Integer, Edge> entry : graph.entrySet()) {
            int src = entry.getKey();
            Edge edge = entry.getValue();
            for (Map.Entry<Integer, Integer> entry2 : edge.edges.entrySet()) {
                int dst = entry2.getKey();
                int cost = entry2.getValue();
                if (dist[src] != Integer.MAX_VALUE && dist[src] + cost < dist[dst]) {
                    isNegCyc = true;
                    break finalLoop;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        if (isNegCyc) {
            sb.append(-1);
        } else {
            for (int i = 1; i < nodeSize; ++i) {
                if (dist[i] == Integer.MAX_VALUE) {
                    dist[i] = -1;
                }
                sb.append(dist[i]).append("\n");
            }
        }

        System.out.print(sb.toString());
    }
}
