package Y2025.M04.D19;

import java.util.*;
import java.io.*;

public class B10282 {
    public static void main(String[] args) throws IOException {
        happyHacking();
    }

    public static String input1 = "2\n" +
            "3 2 2\n" +
            "2 1 5\n" +
            "3 2 5\n" +
            "3 3 1\n" +
            "2 1 2\n" +
            "3 1 8\n" +
            "3 2 4";

    public static void happyHacking() throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        BufferedReader br = new BufferedReader(new StringReader(input1));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int cptSize = Integer.parseInt(st.nextToken());
            int edgeSize = Integer.parseInt(st.nextToken());
            int hacked = Integer.parseInt(st.nextToken());
            Map<Integer, List<Infection>> adjList = new HashMap<>();

            for (int j = 0; j < edgeSize; ++j) {
                st = new StringTokenizer(br.readLine().trim());
                int dst = Integer.parseInt(st.nextToken());
                int src = Integer.parseInt(st.nextToken());
                int sec = Integer.parseInt(st.nextToken());

                // HashMap에 Adjacent List 형태로 관계 저장
                List<Infection> edge;
                if (adjList.containsKey(src)) {
                    edge = adjList.get(src);
                } else {
                    edge = new ArrayList<>();
                }
                edge.add(new Infection(dst, sec));
                adjList.put(src, edge);
            }

            // a b s, a <-(infect)- b (s)
            Queue<Infection> pq = new PriorityQueue<>();
            int[][] isInfected = new int[cptSize + 1][2]; // 감염여부, 감염시간
            final int VISIT = 0, DP = 1;
            int hackedSize = 0, minSec = 1_001;

            for (int j = 0; j < cptSize + 1; ++j) {
                isInfected[j][1] = Integer.MAX_VALUE;
            }

            isInfected[hacked][VISIT] = 1;
            isInfected[hacked][DP] = 0;
            ++hackedSize;
            pq.add(new Infection(hacked, 0));

            while (!pq.isEmpty()) {
                Infection curr = pq.remove();
                int currCpt = curr.cpt;
                int currSec = curr.sec;

                if (adjList.containsKey(currCpt)) {
                    for (Infection next : adjList.get(currCpt)) {
                        int nextCpt = next.cpt;
                        int nextSec = currSec + next.sec;
                        boolean isVisit = isInfected[nextCpt][VISIT] < 1;

                        if (isVisit) { // 방문하지 않고, 최소 시간이면
                            isInfected[nextCpt][VISIT] = 1;
                            isInfected[nextCpt][DP] = nextSec;
                            ++hackedSize;
                            pq.add(new Infection(nextCpt, nextSec));
                        } else {
                            boolean isMin = nextSec < isInfected[nextCpt][DP];
                            if (isMin) {
                                isInfected[nextCpt][DP] = nextSec;
                                pq.add(new Infection(nextCpt, nextSec));
                            }
                        }
                    }
                } else {
                    minSec = Math.min(minSec, currSec);
                }
            }

            sb.append(hackedSize).append(" ").append(minSec).append("\n");
        }

        System.out.println(sb.toString());
    }

    public static class Infection implements Comparable<Infection> {
        int cpt;
        int sec;

        public Infection(int cpt, int sec) {
            this.cpt = cpt;
            this.sec = sec;
        }

        @Override
        public int compareTo(Infection other) {
            return Integer.compare(this.sec, other.sec);
        }
    }
}
