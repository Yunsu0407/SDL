package study.Y2025.M05.D10;

import java.util.*;
import java.io.*;

public class B17219 {
    public static void main(String[] args) throws IOException {
        searchPassword();
    }

    public static void searchPassword() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        final int totalSize = Integer.parseInt(st.nextToken());
        final int searchSize = Integer.parseInt(st.nextToken());

        Map<String, String> map = new HashMap<>();
        for(int i = 0; i < totalSize; ++i) {
            st = new StringTokenizer(br.readLine().trim());
            String site = st.nextToken();
            String password = st.nextToken();
            map.put(site, password);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < searchSize; ++i) {
            String site = br.readLine().trim();
            sb.append(map.get(site)).append("\n");
        }

        System.out.print(sb.toString());
    }
}
