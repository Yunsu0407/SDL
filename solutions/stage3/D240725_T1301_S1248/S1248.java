package stage3.D240725_T1301_S1248;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.Set;
import java.util.Queue;
import java.util.ArrayDeque;

public class S1248 {
    public static void main(String[] args) throws IOException {
        findParent();
    }

    public static void findParent() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int vertices = Integer.parseInt(st.nextToken());
            int edges = Integer.parseInt(st.nextToken());
            int target1 = Integer.parseInt(st.nextToken());
            int target2 = Integer.parseInt(st.nextToken());
            int[] tree = new int[edges * 2];

            HashMap<Integer, Integer> map = new HashMap<>();

            st = new StringTokenizer(br.readLine().trim());
            int check = 0;
            int prev = 0;
            while (st.hasMoreTokens()) {
                ++check;
                int curr = Integer.parseInt(st.nextToken());
                tree[check - 1] = curr;
                if (check % 2 != 0) {
                    prev = curr;
                } else {
                    map.put(curr, prev);
                }
            }

            LinkedList<Integer> parentList1 = findParent(map, target1);
            LinkedList<Integer> parentList2 = findParent(map, target2);

            int nearest = findNearestSameParent(parentList1, parentList2);
            int depth = findDepth(tree, nearest);

            sb.append(String.format("#%d %d %d\n", i + 1, nearest, depth));
        }

        br.close();

        System.out.printf("%s", sb.toString());
    }

    public static LinkedList<Integer> findParent(HashMap<Integer, Integer> map, int target) {
        LinkedList<Integer> list = new LinkedList<>();
        int key = target;
        while (map.containsKey(key)) {
            int value = map.get(key);
            list.add(value);
            key = value;
        }
        return list;
    }

    public static int findNearestSameParent(LinkedList<Integer> list1, LinkedList<Integer> list2) {
        Set<Integer> set = new HashSet<>();
        int nsp = 0;    // nearest same parent
        while (true) {
            if (!list1.isEmpty()) {
                int parent1 = list1.remove();
                if (!set.add(parent1)) {
                    nsp = parent1;
                    break;
                }
            }
            if (!list2.isEmpty()) {
                int parent2 = list2.remove();
                if (!set.add(parent2)) {
                    nsp = parent2;
                    break;
                }
            }
        }
        return nsp;
    }

    public static int findDepth(int[] tree, int nearest) {
        int size = 1;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(nearest);

        while (!queue.isEmpty()) {
            int parent = queue.remove();
            for (int i = 0; i < tree.length / 2; ++i) {
                if (tree[2 * i] == parent) {
                    queue.add(tree[2 * i + 1]);
                    ++size;
                }
            }
        }
        return size;
    }
}
