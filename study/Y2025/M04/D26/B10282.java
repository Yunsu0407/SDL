package study.Y2025.M04.D26;

import java.util.*;
import java.io.*;

public class B10282 {
    public static void main(String[] args) throws IOException {
        happyHacking();
    }

    public static void happyHacking() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int numOfCpt = Integer.parseInt(st.nextToken());
            int dependency = Integer.parseInt(st.nextToken());
            int hackedCpt = Integer.parseInt(st.nextToken());
            Node[] node = new Node[numOfCpt + 1];

            // 1. 입력을 받아 노드들의 값을 설정한다.
            setNode(br, numOfCpt, dependency, node);

            // 감염된 컴퓨터 수와 최대 감염 시간 측정에 공통적으로 사용되는 변수
            Integer[] timeTable = new Integer[numOfCpt + 1];

            // 2. 감염된 컴퓨터 수를 측정한다.
            int numOfInfected = getNumOfInfected(hackedCpt, node, timeTable);
            // 3. 최대 감염 시간을 측정한다.
            int maxTime = getMaxTime(timeTable);

            sb.append(numOfInfected).append(" ").append(maxTime).append("\n");
        }

        System.out.println(sb.toString());
    }

    public static class Node implements Comparable<Node> {
        List<Edge> edges;
        int accTime;

        public Node() {
            edges = new ArrayList<>();
            accTime = 0;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.accTime, other.accTime);
        }
    }

    public static class Edge {
        int dst;
        int cost;

        public Edge(int dst, int cost) {
            this.dst = dst;
            this.cost = cost;
        }
    }

    // 입력을 받아 노드들의 값을 설정한다.
    public static void setNode (BufferedReader br, int numOfCpt, int dependency, Node[] node) throws IOException {
        for (int j = 0; j < numOfCpt + 1; ++j) {
            node[j] = new Node();
        }

        for (int j = 0; j < dependency; ++j) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            // 컴퓨터 a가 컴퓨터 b를 의존, B가 감염되면 A도 감염됨
            int a = Integer.parseInt(st.nextToken()); // dst
            int b = Integer.parseInt(st.nextToken()); // src
            int cost = Integer.parseInt(st.nextToken());
            node[b].edges.add(new Edge(a, cost));
        }
    }

    // 감염된 컴퓨터 수를 측정한다.
    public static int getNumOfInfected (int hackedCpt, Node[] node, Integer[] timeTable) {
        Queue<Node> pq = new PriorityQueue<>();
        int numOfInfected = 0;

        pq.add(node[hackedCpt]);
        timeTable[hackedCpt] = 0;
        ++numOfInfected;

        while (!pq.isEmpty()) {
            Node currCpt = pq.remove();
            List<Edge> edges = currCpt.edges;
            int accTime = currCpt.accTime;

            for (Edge edge : edges) {
                int dst = edge.dst;
                int cost = edge.cost;
                int nextAccTime = accTime + cost;

                if (timeTable[dst] == null) { // 처음 방문한 경우
                    // 누적 시간 갱신, pq에 추가, 타임 테이블 갱신, 감염된 컴퓨터 수 증가
                    node[dst].accTime = nextAccTime;
                    pq.add(node[dst]);
                    timeTable[dst] = nextAccTime;
                    ++numOfInfected;
                } else {
                    if (nextAccTime < timeTable[dst]) { // 방문했지만 시간이 더 적은 경우
                        // 누적 시간 갱신, pq에 추가, 타임 테이블 갱신
                        node[dst].accTime = nextAccTime;
                        pq.add(node[dst]);
                        timeTable[dst] = nextAccTime;
                    }
                }
            }
        }
        return numOfInfected;
    }

    // 최대 감염 시간을 측정한다.
    public static int getMaxTime (Integer[] timeTable) {
        int maxTime = -1;
        for (Integer time : timeTable) {
            if(time != null){
                maxTime = Math.max(maxTime, time);
            }
        }
        return maxTime;
    }
}
