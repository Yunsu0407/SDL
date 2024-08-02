package D240725_T2005_B1717;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1717 {
    public static void main(String[] args) throws IOException {
        setOperating();
    }

    public static void setOperating() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        final int SIZE = Integer.parseInt(st.nextToken());
        final int OPERATING_COUNT = Integer.parseInt(st.nextToken());

        int[] parent = new int[SIZE + 1];
        for (int i = 0; i < SIZE + 1; ++i) {
            parent[i] = i;
        }

        for (int i = 0; i < OPERATING_COUNT; ++i) {
            st = new StringTokenizer(br.readLine().trim());
            int operating = Integer.parseInt(st.nextToken());
            int targetA = Integer.parseInt(st.nextToken());
            int targetB = Integer.parseInt(st.nextToken());
            if (targetB < targetA) {
                int temp = targetA;
                targetA = targetB;
                targetB = temp;
            }
            if (operating == 0) { // 합집합
                combine(parent, targetA, targetB);
            } else {    // operating == 1, 확인
                if (check(parent, targetA, targetB)) {
                    sb.append("yes\n");
                } else {
                    sb.append("no\n");
                }
            }
        }
        br.close();
        System.out.printf("%s", sb.toString());
    }

    public static void combine(int[] parent, int targetA, int targetB) {
        int parentA = getParent(parent, targetA);
        int parentB = getParent(parent, targetB);
        if (!(parentA == parentB)) {
            parent[targetB] = targetA;
        }
    }

    public static int getParent(int[] parent, int target) {
        int index = target;
        int value = parent[index];
        while (index != value) {
            index = value;
            value = parent[index];
        }
        return index;
    }

    public static boolean check(int[] parent, int targetA, int targetB) {
        return getParent(parent, targetA) == getParent(parent, targetB);
    }
}

