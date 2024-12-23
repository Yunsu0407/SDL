package study.Y2024.M12.D23;

import java.util.*;
import java.io.*;

public class B28446 {
    public static void main(String[] args) throws IOException {
        manageBall();
    }

    public static String example = "5\n1 5 900\n1 7 300\n1 15 100\n2 300\n2 100";

    public static class Ball implements Comparable<Ball> {
        private int weight;
        private int locker;

        public Ball(int weight, int locker) {
            this.weight = weight;
            this.locker = locker;
        }

        @Override
        public int compareTo(Ball other) {
            return Integer.compare(this.weight, other.weight);
        }

        public int getWeight() {
            return this.weight;
        }

        public int getLocker() {
            return this.locker;
        }
    }

    public static ArrayList<Ball> balls = new ArrayList<>();
    public static ArrayList<Integer> selects = new ArrayList<>();

    public static void manageBall() throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader(example));
        int numberOfRequest = Integer.parseInt(br.readLine().trim());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberOfRequest; ++i) {
            st = new StringTokenizer(br.readLine().trim());
            int request = Integer.parseInt(st.nextToken());
            if (request == 1) {
                int locker = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                balls.add(new Ball(weight, locker));
            } else {
                int weight = Integer.parseInt(st.nextToken());
                selects.add(weight);
            }
        }

        System.out.print(doSelects());
    }

    public static String doSelects() {
        StringBuilder sb = new StringBuilder();
        Collections.sort(balls);
        int size = balls.size();
        int min = 0, max = size - 1;

        for (int weight : selects) {
            int myLocker = findLocker(weight, min, max);
            sb.append(myLocker).append("\n");
        }

        return sb.toString();
    }

    public static int findLocker(int weight, int min, int max) {
        int mid = (max + min) / 2;
        int midValue = balls.get(mid).getWeight();
        if (weight > midValue) {
            return findLocker(weight, mid + 1, max);
        } else if (weight == midValue) {
            return balls.get(mid).getLocker();
        } else {
            return findLocker(weight, min, mid - 1);
        }
    }
}