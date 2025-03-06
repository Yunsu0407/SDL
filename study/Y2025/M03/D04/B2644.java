package study.Y2025.M03.D04;

import java.util.*;
import java.io.*;

public class B2644 {
    public static void main(String[] args) throws IOException {
        checkFamily();
    }

    public static String input1 = "9\n" +
            "7 3\n" +
            "7\n" +
            "1 2\n" +
            "1 3\n" +
            "2 7\n" +
            "2 8\n" +
            "2 9\n" +
            "4 5\n" +
            "4 6";

    public static String input2 = "9\n" +
            "8 6\n" +
            "7\n" +
            "1 2\n" +
            "1 3\n" +
            "2 7\n" +
            "2 8\n" +
            "2 9\n" +
            "4 5\n" +
            "4 6";

    public static String input3 = "9\n" +
            "8 6\n" +
            "8\n" +
            "1 2\n" +
            "1 3\n" +
            "2 7\n" +
            "2 8\n" +
            "2 9\n" +
            "4 5\n" +
            "4 6\n" +
            "9 4";

    public static void checkFamily() throws IOException {
        // BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader(input2));
        final int N = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        final int P1 = Integer.parseInt(st.nextToken());
        final int P2 = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(br.readLine().trim());

        HashMap<Integer, HashSet<Integer>> adjList = new HashMap<>();

        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine().trim());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            HashSet<Integer> parentSet = adjList.get(parent);
            HashSet<Integer> childSet = adjList.get(child);
            if (parentSet == null) {
                parentSet = new HashSet<>();
            }
            if (childSet == null) {
                childSet = new HashSet<>();
            }
            parentSet.add(child);
            childSet.add(parent);
            adjList.put(parent, parentSet);
            adjList.put(child, childSet);
        }

        boolean[] visited = new boolean[N + 1];

        HashSet<Integer> currRelated = new HashSet<>();
        currRelated.add(P1);
        visited[P1] = true;

        boolean isFound = false;
        int count = 0;
        //  카운트 증가 해야함
        while (!currRelated.isEmpty()) {
            ++count;
            HashSet<Integer> nextRelated = new HashSet<>();

            for (int curr : currRelated) {
                HashSet<Integer> relatedPerson = adjList.get(curr);
                for(int curr2: relatedPerson){
                    if(!visited[curr2]){
                        nextRelated.add(curr2);
                        visited[curr2] = true;
                    }
                }
            }

            if (nextRelated.contains(P2)) {
                isFound = true;
                break;
            } else {
                currRelated = nextRelated;
            }
        }

        int ans;
        if (isFound) {
            ans = count;
        } else {
            ans = -1;
        }

        System.out.println(ans);
    }

}
