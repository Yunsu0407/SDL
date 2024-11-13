package D240920_T0925_B17484;

import java.io.*;
import java.util.*;

public class B17484 {
    public static void main(String[] args) throws IOException {
        getPath();
    }

    public static int[][] map;
    public static int[] direction = {-1, 0, 1};
    public static int N;
    public static int M;
    public static int min = Integer.MAX_VALUE;

    public static void getPath() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int r = 0; r < N; ++r) {
            st = new StringTokenizer(br.readLine().trim());
            for (int c = 0; c < M; ++c) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();
        control();
        System.out.println(min);
    }

    public static void control() {
        PriorityQueue<Spaceship> path = new PriorityQueue<>();
        initiate(path);

        while (!path.isEmpty()) {
            Spaceship curr = path.remove();
            int row = curr.row;
            int col = curr.col;
            int fuel = curr.fuel;
            int prev = curr.prev;

            int nextRow = row + 1;
            if (nextRow == N) {
                 min = Math.min(min, fuel);
            } else {
                for (int c = 0; c < 3; ++c) {
                    int nextCol = col + direction[c];
                    if (prev != direction[c] && (nextCol > -1 && nextCol < M)) {
                        path.add(new Spaceship(fuel, nextRow, nextCol, direction[c]));
                    }
                }
            }
        }
    }

    public static void initiate(PriorityQueue<Spaceship> path) {
        for (int c = 0; c < M; ++c) {
            path.add(new Spaceship(0, 0, c ,-2));
        }
    }

    public static class Spaceship implements Comparable<Spaceship> {
        int fuel;
        int prev;
        int row, col;

        public Spaceship(int fuel, int row, int col, int prev) {
            this.fuel = fuel + map[row][col];
            this.prev = prev;
            this.row = row;
            this.col = col;
        }

        @Override
        public int compareTo(Spaceship other) {
            return this.fuel - other.fuel;
        }
    }
}
