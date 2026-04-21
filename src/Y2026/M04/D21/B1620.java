package Y2026.M04.D21;

import java.util.*;
import java.io.*;

public class B1620 {
    public static void main(String[] args) throws IOException {
        makeDictionary();
    }

    public static void makeDictionary() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            String number = String.valueOf(i + 1);
            String name = br.readLine().trim();
            map.put(number, name);
            map.put(name, number);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; ++i) {
            String input = br.readLine().trim();
            String output = map.get(input);
            sb.append(output).append("\n");
        }

        System.out.println(sb.toString());
    }
}
