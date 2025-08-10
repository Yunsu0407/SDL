package Y2025.M08.D10;

import java.util.*;
import java.io.*;

public class B11779 {
    public static void main(String[] args) throws IOException {
        minCost2();
    }

    public static class Node {
        int dst;
        int cost;

        public Node(int dst, int cost) {
            this.dst = dst;
            this.cost = cost;
        }
    }

    public static class Source implements Comparable<Source> {
        int src;
        int acc;

        public Source(int src, int acc) {
            this.src = src;
            this.acc = acc;
        }

        @Override
        public int compareTo(Source other) {
            return this.acc - other.acc;
        }
    }

    public static void minCost2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int citySize = Integer.parseInt(br.readLine().trim());
        int busSize = Integer.parseInt(br.readLine().trim());
        Map<Integer, List<Node>> graph = new HashMap<>();

        for (int i = 0; i < busSize; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int src = Integer.parseInt(st.nextToken());
            int dst = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            List<Node> nodes = graph.getOrDefault(src, new ArrayList<>());
            nodes.add(new Node(dst, cost));
            graph.put(src, nodes);
        }

        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int sCity = Integer.parseInt(st.nextToken());
        int eCity = Integer.parseInt(st.nextToken());

        int[] cityCost = new int[citySize + 1];
        Arrays.fill(cityCost, Integer.MAX_VALUE);
        cityCost[sCity] = 0;

        int[] cityTrace = new int[citySize + 1];

        Queue<Source> pq = new PriorityQueue<>();
        pq.add(new Source(sCity, 0));

        while (!pq.isEmpty()) {
            Source source = pq.remove();
            if (source.acc >= cityCost[eCity]) {
                continue;
            }

            if (graph.containsKey(source.src)) {
                for (Node node : graph.get(source.src)) {
                    int nCost = source.acc + node.cost;
                    if (nCost < cityCost[node.dst]) {
                        cityCost[node.dst] = nCost;
                        cityTrace[node.dst] = source.src;

                        if (source.src != eCity) {
                            pq.add(new Source(node.dst, nCost));
                        }
                    }
                }
            }
        }

        List<Integer> revTrace = new ArrayList<>();
        int currCity = eCity;
        while (true) {
            revTrace.add(0, currCity);

            if (currCity == sCity) {
                break;
            }
            currCity = cityTrace[currCity];
        }

        StringBuilder sb = new StringBuilder();
        sb.append(cityCost[eCity]).append("\n");
        sb.append(revTrace.size()).append("\n");
        for (int city : revTrace) {
            sb.append(city).append(" ");
        }

        System.out.println(sb.toString());
    }
}
