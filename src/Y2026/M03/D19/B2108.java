package Y2026.M03.D19;

import java.util.*;
import java.io.*;

public class B2108 {
    public static void main(String[] args) throws IOException {
        statistics();
    }

    /*
     * N은 홀수
     * 1. 산술평균
     * 2. 중앙값
     * 3. 최빈값
     * 4. 범위 (최대 최소의 차이)
     */

    public static String input1 = "5\r\n" + //
            "1\r\n" + //
            "3\r\n" + //
            "8\r\n" + //
            "-2\r\n" + //
            "2";

    public static String input2 = "1\r\n" + //
            "4000";

    public static String input3 = "5\r\n" + //
            "-1\r\n" + //
            "-2\r\n" + //
            "-3\r\n" + //
            "-1\r\n" + //
            "-2";

    public static String input4 = "3\r\n" + //
            "0\r\n" + //
            "0\r\n" + //
            "-1";

    public static void statistics() throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader(input4));
        int size = Integer.parseInt(br.readLine().trim());
        List<Integer> arr = new ArrayList<>();
        Map<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < size; ++i) {
            int curr = Integer.parseInt(br.readLine().trim());
            arr.add(curr);
            if (map.containsKey(curr)) {
                map.replace(curr, map.get(curr) + 1);
            } else {
                map.put(curr, 1);
            }
        }
        Collections.sort(arr);

        int avg = getAvg(arr);
        int mid = arr.get(size / 2);
        int mode = getMod(map);
        int diff = arr.get(size - 1) - arr.get(0);

        StringBuilder sb = new StringBuilder();
        sb.append(avg).append("\n");
        sb.append(mid).append("\n");
        sb.append(mode).append("\n");
        sb.append(diff);
        System.out.println(sb.toString());
    }

    public static int getAvg(List<Integer> arr) {
        int sum = 0;
        for (int curr : arr) {
            sum = sum + curr;
        }
        return (int) Math.round(sum / (arr.size() * 1.0));
    }

    public static int getMod(Map<Integer, Integer> map) {
        int min = Integer.MAX_VALUE;
        int cnt = 0;
        boolean isDup = false;

        for (int i = 0; i < 2; ++i) {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int curr = entry.getKey();
                int currCnt = entry.getValue();

                if (currCnt > cnt) {
                    min = curr;
                    cnt = currCnt;
                    isDup = false;
                } else if (currCnt == cnt) {
                    min = curr < min ? curr : min;
                    cnt = currCnt;
                    isDup = true;
                }
            }

            if (i == 0 && isDup) {
                map.remove(min);
                min = Integer.MAX_VALUE;
                cnt = 0;
            } else {
                break;
            }
        }

        return min;
    }
}
