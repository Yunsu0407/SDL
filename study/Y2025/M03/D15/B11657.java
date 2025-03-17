package study.Y2025.M03.D15;

import java.util.*;
import java.io.*;

/*
N개의 도시가 있다.
그리고 도시 간 버스가 M개가 있다.
각 버스의 상태는 A, B, C로 나타낼 수 있다.
A: 시작도시(src), B: 도착도시(dest), C: 이동시간(cost)
C는 양수(실제 이동시간), 0(순간이동), 음수(타임머신) 세 가지 상태가 있다.
1번 도시에서 출발하여 나머지 도시로 가는 가장 빠른 시간을 구하는 프로그램을 만들어라.

도시의 개수 N은 1이상 500이하이다.
버스 노선의 개수 M은 1이상 6,000이하이다.
A,B는 1이상 N이하
C는 -10,000이상 10,000이하

인접행렬로 해당 도시가 갈 수 있는 도시들의 목록과 가중치를 저장한다.
이동 소요시간을 계산할 때, 방문배열이 필요하다.(무한루프 방지)
(출발도시  |  (도착도시 및 코스트 = Map<도착도시, 코스트>)) = HashMap<도착도시, Map>
0           X
1           X
2           {{otherCity1, cost1}, {otherCity2, cost2} ... {otherCityN,costN}}
...
N
 */

public class B11657 {
    public static void main(String[] args) throws IOException {
        unrealIntercityTravel();
    }

    public static String input1 = "3 4\n" +
            "1 2 4\n" +
            "1 3 3\n" +
            "2 3 -1\n" +
            "3 1 -2";

    public static void unrealIntercityTravel() throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader(input1));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int numOfCity = Integer.parseInt(st.nextToken());
        int numOfBus = Integer.parseInt(st.nextToken());


        // 인접행렬 만들기
        Map<Integer, Map<Integer, Integer>> adjList = new HashMap<>();
        for (int i = 0; i < numOfBus; ++i) {
            st = new StringTokenizer(br.readLine().trim());
            int srcCity = Integer.parseInt(st.nextToken());
            int destCity = Integer.parseInt(st.nextToken());
            int travelCost = Integer.parseInt(st.nextToken());

            Map<Integer, Integer> otherCities;
            if (adjList.containsKey(srcCity)) {
                otherCities = adjList.get(srcCity);
            } else {
                otherCities = new HashMap<>();
            }

            if (otherCities.containsKey(destCity)) {
                travelCost = Math.min(otherCities.get(destCity), travelCost);
            }
            otherCities.put(destCity, travelCost);
            adjList.put(srcCity, otherCities);
        }

        class Accure {
            public boolean[] visited;
            public int city;
            public int accCost;

            public Accure() {
                visited = new boolean[numOfCity + 1];
                visited[1] = true;
                city = 1;
                accCost = 0;
            }

            public Accure(boolean[] visited, int city, int accCost) {
                this.visited = visited;
                this.city = city;
                this.accCost = accCost;
            }

            public boolean isPossible(int city) {
                return visited[city];
            }
        }

        int[] costResult = new int[numOfCity + 1];
        Arrays.fill(costResult, 10001);

        for (int i = 2; i < numOfCity; ++i) {
            Queue<Accure> travelQueue = new ArrayDeque<>();
            travelQueue.add(new Accure());
            while (!travelQueue.isEmpty()) {
                Accure aPrevCity = travelQueue.remove();
                int srcCity = aPrevCity.city;
                if (srcCity == i) {
                    costResult[i] = Math.min(costResult[i], aPrevCity.accCost);
                }

                for (Map.Entry<Integer, Map<Integer, Integer>> entry : adjList.entrySet()) {
                    if (entry.getKey() == srcCity) {
                        for (Map.Entry<Integer, Integer> nextCityInfo : entry.getValue().entrySet()) {
                            int nextCity = nextCityInfo.getKey();

                            if (!aPrevCity.isPossible(nextCity)) {
                                int nextCost = nextCityInfo.getValue();
                                boolean[] nextVisited = aPrevCity.visited.clone();
                                nextVisited[nextCity] = true;

                                Accure aNextCity = new Accure(nextVisited, nextCity, nextCost);
                                travelQueue.add(aNextCity);
                            } else {
                                costResult[i] = Math.min(costResult[i], -1);
                            }
                        }
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < costResult.length; ++i) {
            sb.append(costResult[i]).append("\n");
        }
        System.out.print(sb.toString());
    }
}
