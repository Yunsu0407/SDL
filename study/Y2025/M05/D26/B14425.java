package study.Y2025.M05.D26;

import java.util.*;
import java.io.*;

public class B14425 {
    public static void main(String[] args) throws IOException {
        stringSet();
    }

    public static void stringSet() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        int sizeX = Integer.parseInt(st.nextToken());
        int sizeY = Integer.parseInt(st.nextToken());

        Set<String> setX = new HashSet<>();
        for (int i = 0; i < sizeX; ++i) {
            String curr = br.readLine().trim();
            setX.add(curr);
        }

        int ans = 0;
        for (int i = 0; i < sizeY; ++i) {
            String curr = br.readLine().trim();
            if(setX.contains(curr)) {
                ++ans;
            }
        }

        System.out.println(ans);
    }
}
