package study.Y2025.M08.D03;

import java.util.*;
import java.io.*;

public class B2294 {
    public static void main(String[] args) throws IOException {
        coinTwo();
    }

    // 사용된 코인의 개수, 남은 코인의 값
    public static class Data implements Comparable<Data> {
        int rest, usage;

        public Data(int rest, int usage) {
            this.rest = rest;
            this.usage = usage;
        }

        @Override
        public int compareTo(Data other) {
            return this.usage - other.usage;
        }
    }

    public static void coinTwo() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int kindOfCoin = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        List<Integer> coinList = new ArrayList<>();

        for (int i = 0; i < kindOfCoin; ++i) {
            int coin = Integer.parseInt(br.readLine().trim());
            coinList.add(coin);
        }
        coinList.sort(Collections.reverseOrder()); // 내림차순 정렬

        Queue<Data> pq = new PriorityQueue<>();
        pq.offer(new Data(target, 0));
        int min = Integer.MAX_VALUE;
        Map<Integer, Integer> uMap = new HashMap<>();
        boolean possible = false;

        while (!pq.isEmpty()) {
            Data data = pq.poll();
            int usage = data.usage + 1;

            for (int coin : coinList) {
                int rest = data.rest - coin;

                if (usage < min) {
                    if (rest == 0) {
                        min = usage;
                        possible = true;
                    } else if (rest > 0) {
                        if (uMap.containsKey(rest)) {
                            if (usage < uMap.get(rest)) {
                                pq.offer(new Data(rest, usage));
                                uMap.replace(rest, usage);
                            }
                        } else {
                            pq.offer(new Data(rest, usage));
                            uMap.put(rest, usage);
                        }

                    }
                }
            }
        }

        if (!possible) {
            min = -1;
        }

        System.out.println(min);
    }
}
