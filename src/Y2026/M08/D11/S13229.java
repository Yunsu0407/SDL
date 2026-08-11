package Y2026.M08.D11;

import java.util.*;
import java.io.*;

public class S13229 {
    public static void main(String[] args) throws IOException {
        countSunday();
    }

    public static void countSunday() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> hashMap = makeMap();

        for (int i = 0; i < testcase; ++i) {
            String day = br.readLine().trim();
            int left = hashMap.get(day);

            String line = String.format("#%d %d\n", (i + 1), left);
            sb.append(line);
        }

        System.out.print(sb.toString());
    }

    public static HashMap<String, Integer> makeMap() {
        String[] days = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < days.length; ++i) {
            String key = days[i];
            int value = days.length - i;
            hashMap.put(key, value);
        }

        return hashMap;
    }
}
