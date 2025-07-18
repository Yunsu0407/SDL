package study.Y2025.M07.D18;

import java.util.*;
import java.io.*;

public class B10775 {
    public static void main(String[] args) throws IOException {
        handleAirport();
    }

    public static String input1 = "4\n" +
            "3\n" +
            "4\n" +
            "1\n" +
            "1"; // 2

    public static String input2 = "4\n" +
            "6\n" +
            "2\n" +
            "2\n" +
            "3\n" +
            "3\n" +
            "4\n" +
            "4"; // 3

    public static void handleAirport() throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader(input1));
        int gate = Integer.parseInt(br.readLine().trim());
        int plane = Integer.parseInt(br.readLine().trim());
        boolean[] airport = new boolean[gate];
        Map<Integer, Integer> lastCheck = new HashMap<>();

        int ans = 0;
        for (int i = 0; i < plane; ++i) {
            int limit = Integer.parseInt(br.readLine().trim()) - 1;
            if (isPossible(airport, limit, lastCheck)) {
                ++ans;
            } else {
                break;
            }
        }

        System.out.println(ans);
    }

    public static boolean isPossible(boolean[] airport, int limit, Map<Integer, Integer> lastCheck) {
        boolean possible = false;
        int start;

        if(lastCheck.containsKey(limit)) {
            start = lastCheck.get(limit);
        } else {
            start = limit;
        }

        for (int i = start; i >= 0; --i) {
            if (!airport[i]) {
                possible = true;
                airport[i] = true;
                lastCheck.put(limit, i);
                break;
            }
        }

        return possible;
    }
}
