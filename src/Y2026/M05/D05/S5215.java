package Y2026.M05.D05;

import java.util.*;
import java.io.*;

public class S5215 {
    public static void main(String[] args) throws IOException {
        burgerDiet();
    }

    public static String input1 = "\r\n" + //
            "1\r\n" + // tc
            "5 1000\r\n" + // 재료의 수, 제한 칼로리
            "100 200\r\n" + // 점수, 칼로리
            "300 500\r\n" + //
            "250 300\r\n" + //
            "500 1000\r\n" + //
            "400 400";

    // 같은 재료 중복 불가
    // 조합 제한은 칼로리뿐임

    public static class Burger implements Comparable<Burger> {
        boolean[] visit;
        int accScore, leftCal;

        public Burger(boolean[] visit, int accScore, int leftCal) {
            this.visit = visit;
            this.accScore = accScore;
            this.leftCal = leftCal;
        }

        @Override
        public int compareTo(Burger other) {
            return other.accScore - this.accScore;
        }
    }

    public static void burgerDiet() throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader(input1));
        int tc = Integer.parseInt(br.readLine().trim());

        for (int t = 0; t < tc; ++t) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int kind = Integer.parseInt(st.nextToken());
            int limit = Integer.parseInt(st.nextToken());

            Queue<Burger> pq = new PriorityQueue<>();
            int[][] recipe = new int[kind][2];
            final int S = 0, C = 1;
            for (int i = 0; i < kind; ++i) {
                st = new StringTokenizer(br.readLine().trim());
                int score = Integer.parseInt(st.nextToken());
                int calorie = Integer.parseInt(st.nextToken());
                recipe[i][S] = score;
                recipe[i][C] = calorie;
                boolean[] visit = new boolean[kind];
                visit[i] = true;
                pq.add(new Burger(visit, score, limit - calorie));
            }

            int maxScore = 0;
            while (!pq.isEmpty()) {
                Burger curr = pq.remove();

                for (int i = 0; i < kind; ++i) {
                    if (!curr.visit[i]) {
                        int leftCal = curr.leftCal - recipe[i][C];
                        if (leftCal > 0) {
                            boolean[] visit = curr.visit.clone();
                            visit[i] = true;
                            int accScore = curr.accScore + recipe[i][S];
                            pq.add(new Burger(visit, accScore, leftCal));
                            maxScore = Math.max(maxScore, accScore);
                        }
                    }
                }
            }
        }
    }
}
