package Y2025.M09.D20;

import java.util.*;
import java.io.*;

public class B2098 {
    public static void main(String[] args) throws IOException {
        salesmanProblem();
    }

    /*
        A -> B, B -> A의 코스트는 상이하다.
        A -> A = 0이다.
        A -> B = 0인 경우는 길이 없는 경우다.
     */

    public static String input1 = "4\n" +
            "0 10 15 20\n" +
            "5 0 9 10\n" +
            "6 13 0 12\n" +
            "8 8 9 0";

    public static class Memory implements Comparable<Memory> {
        boolean[] visit;
        int count;
        int accum;
        int currCity;

        public Memory(boolean[] visit, int count, int accum, int visitCity) {
            this.visit = new boolean[visit.length];
            this.visit = visit.clone();
            this.accum = accum;
            this.count = count - 1;
            this.currCity = visitCity;
            this.visit[visitCity] = true;
        }

        @Override
        public int compareTo(Memory other) {
            return this.accum - other.accum;
        }

    }

    public static void salesmanProblem() throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader(input1));
        int numOfCity = Integer.parseInt(br.readLine().trim());

        Map<Integer, List<Integer>> totalCost = new HashMap<>();
        for(int i = 0; i < numOfCity; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            List<Integer> oneCost = new ArrayList<>();
            for(int j = 0; j < numOfCity; ++j) {
                oneCost.add(Integer.parseInt(st.nextToken()));
            }
            totalCost.put(i, oneCost);
        }

        Queue<Memory> pq = new PriorityQueue<>();
        pq.offer(new Memory(new boolean[numOfCity], numOfCity, 0, 0));
        int min = Integer.MAX_VALUE;

        while (!pq.isEmpty()) {
            Memory memory = pq.poll();

            if(memory.count == 0) {
                min = Math.min(min, memory.accum);
                continue;
            }

            List<Integer> nextCity = totalCost.get(memory.currCity);
            for(int i = 0; i < nextCity.size(); ++i) {
                if(!memory.visit[i] && nextCity.get(i) != 0) { // 방문하지 않았고, 이동이 가능하면

                    // boolean[] visit, int count, int accum, int visitCity
                    pq.offer(new Memory(memory.visit, memory.count, memory.accum, i));

                }
            }
        }

        System.out.println(min);
    }
}
