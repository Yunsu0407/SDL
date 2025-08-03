package study.Y2025.M07.D31;

import java.util.*;
import java.io.*;

public class B1043 {
    public static void main(String[] args) throws IOException {
        lie();
    }

    public static String input1 = "4 1\n" +
            "1 1\n" +
            "4 1 2 3 4"; // 0

    public static String input2 = "4 1\n" +
            "0\n" +
            "4 1 2 3 4"; // 1

    public static void lie() throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader(input2));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int personSize = Integer.parseInt(st.nextToken());
        int partySize = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine().trim());
        int knownSize = Integer.parseInt(st.nextToken());
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < knownSize; ++i) {
            int number = Integer.parseInt(st.nextToken());
            set.add(number);
        }

        int count = 0;

        for (int i = 0; i < partySize; ++i) {
            boolean isKnown = false;
            st = new StringTokenizer(br.readLine().trim());
            int groupSize = Integer.parseInt(st.nextToken());

            for (int j = 0; j < groupSize; ++j) {
                int number = Integer.parseInt(st.nextToken());
                if (set.contains(number)) {
                    isKnown = true;
                    break;
                }
            }

            if (!isKnown) {
                ++count;
            }
        }

        System.out.println(count);
    }
}
