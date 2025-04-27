package Y2025.M04.D27;

import java.util.*;
import java.io.*;

public class B2822 {
    public static void main(String[] args) throws IOException {
        calcScore();
    }

    public static void calcScore() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> map = new TreeMap<>(Comparator.reverseOrder());

        for (int i = 0; i < 8; ++i) {
            int turn = i + 1;
            int score = Integer.parseInt(br.readLine().trim());
            map.put(score, turn);
        }

        List<Integer> index = new ArrayList<>();
        int sum = 0;
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (count == 5) {
                break;
            }
            sum = sum + entry.getKey();
            index.add(entry.getValue());
            ++count;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(sum).append("\n");

        Collections.sort(index);
        for (int curr : index) {
            sb.append(curr).append(" ");
        }

        System.out.println(sb.toString());
    }
}
