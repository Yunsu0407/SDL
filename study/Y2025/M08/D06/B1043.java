package study.Y2025.M08.D06;

import java.util.*;
import java.io.*;

public class B1043 {
    public static void main(String[] args) throws IOException {
        lie();
    }

    public static void lie() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int hSize = Integer.parseInt(st.nextToken()); // human size
        int pSize = Integer.parseInt(st.nextToken()); // party size
        int ans = pSize;

        Set<Integer> kSet = new HashSet<>();
        st = new StringTokenizer(br.readLine().trim());
        int kSize = Integer.parseInt(st.nextToken()); // known size
        if (kSize != 0) {
            for (int i = 0; i < kSize; ++i) {
                kSet.add(Integer.parseInt(st.nextToken()));
            }

            List<Set<Integer>> parties = new ArrayList<>();
            for (int i = 0; i < pSize; ++i) {
                st = new StringTokenizer(br.readLine().trim());
                int opSize = Integer.parseInt(st.nextToken()); // one party size
                Set<Integer> party = new HashSet<>();
                for (int j = 0; j < opSize; ++j) {
                    int number = Integer.parseInt(st.nextToken());
                    party.add(number);
                }
                parties.add(party);
            }

            boolean[] check = new boolean[pSize];
            boolean cycle = true;
            while (cycle) {
                if (kSet.size() == hSize) {
                    ans = 0;
                    break;
                }
                cycle = false;

                for (int i = 0; i < pSize; ++i) {
                    if (!check[i]) {
                        Set<Integer> party = parties.get(i);
                        for (int number : kSet) {
                            if (party.contains(number)) {
                                kSet.addAll(party);
                                check[i] = true;
                                --ans;
                                cycle = true;
                                break;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(ans);
    }
}
