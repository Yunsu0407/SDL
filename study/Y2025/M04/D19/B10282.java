package study.Y2025.M04.D19;

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

    public static String input2 = "1\n" +
            "4 5 1\n" +
            "4 1 1\n" +
            "2 4 10\n" +
            "3 1 2\n" +
            "2 3 2\n" +
            "3 2 2"; // ans = 4 4

    // 가능한 모든 컴퓨터가 감염되는 시간을 구해야한다.

    public static void happyHacking() throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        BufferedReader br = new BufferedReader(new StringReader(input2));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int cptSize = Integer.parseInt(st.nextToken());
            int edgeSize = Integer.parseInt(st.nextToken());
            int hacked = Integer.parseInt(st.nextToken());
            Map<Integer, List<Integer[]>> adjList = new HashMap<>();

            // 인접리스트 생성
            for (int j = 0; j < edgeSize; ++j) {
                st = new StringTokenizer(br.readLine().trim());
                int to = Integer.parseInt(st.nextToken());
                int from = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                List<Integer[]> edges;
                if (adjList.containsKey(from)) {
                    edges = adjList.get(from);
                } else {
                    edges = new ArrayList<>();
                }

                edges.add(new Integer[]{to, cost});
                adjList.put(from, edges);
            }

            int minSec = Integer.MAX_VALUE;
            int infected = 0;
            Queue<Virus> queue = new PriorityQueue<>();
            queue.add(new Virus(cptSize, hacked));

            while (!queue.isEmpty()) {
                Virus cVirus = queue.remove();
                boolean isContinue = false;

                if (adjList.containsKey(cVirus.cpt)) {
                    for (Integer[] next : adjList.get(cVirus.cpt)) {
                        if (!cVirus.isVisit(next[0])) {
                            isContinue = true;
                            queue.add(new Virus(cVirus, next));
                        }
                    }
                }

                if(!isContinue) {
                    infected = cVirus.infected;
                    minSec = cVirus.accSec;
                    break;
                }
            }

            sb.append(infected).append(" ").append(minSec).append("\n");

        }

        System.out.println(sb.toString());
    }

    public static class Virus implements Comparable<Virus>{
        boolean[] visit;
        int cpt;
        int accSec;
        int infected;

        public Virus(int cptSize, int hacked) {
            visit = new boolean[cptSize + 1];
            cpt = hacked;
            visit[hacked] = true;
            accSec = 0;
            infected = 1;
        }

        public Virus(Virus prev, Integer[] next) {
            visit = prev.visit.clone();
            visit[next[0]] = true;
            cpt = next[0];
            accSec = prev.accSec + next[1];
            infected = prev.infected + 1;
        }

        @Override
        public int compareTo(Virus other) {
            return Integer.compare(this.accSec, other.accSec);
        }

        public boolean isVisit(int cpt) {
            return visit[cpt];
        }
    }

    /*
    큐에 1번 컴퓨터를 넣는다.

    큐가 비어있지 않은 동안 다음을 반복
        큐에서 현재 컴퓨터를 가져온다.
        현재 컴퓨터와 연결된 다음 컴퓨터 목록을 가져온다. // 인접 리스트

        다음 방문지가 있는지 확인하는 변수 선언 // isNextExist = false;

        컴퓨터 목록으로 다음을 반복한다.
            현재 컴퓨터가 다음 컴퓨터를 방문하지 않았으면
                방문 처리하고 큐에 다음 컴퓨터 삽입
                다음 방문지 확인 변수에 true 할당 // isNextExist = true;

        만약 다음에 방문할 수 있는 곳이 없으면
            현재 누적 시간을 종료 시간에 갱신한다
     */
}
