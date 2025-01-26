package Y2025.M01.D21;

import java.util.*;
import java.io.*;

public class B2531 {
    public static String input1 = "8 30 4 30\n7\n9\n7\n30\n2\n7\n9\n25"; // 5
    public static String input2 = "8 50 4 7\n2\n7\n9\n25\n7\n9\n7\n30"; // 4
    public static String input3 = "2 9 1 1\n2\n1"; // 2
    public static String input4 = "3 9 3 1\n2\n3\n4"; // 4
    public static String[] inputs = {input1, input2, input3, input4};
    // size kind stream coupon
    public static void main(String[] args) throws IOException {
        for (String s : inputs) {
            getSushi(s);
        }
//        getSushi(input3);
    }


    public static void getSushi(String input) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader(input));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int size = Integer.parseInt(st.nextToken());
        int kind = Integer.parseInt(st.nextToken());
        int stream = Integer.parseInt(st.nextToken());
        int coupon = Integer.parseInt(st.nextToken());
        ArrayList<Integer> queue = new ArrayList<>();
        ArrayList<Integer> belt = new ArrayList<>();
        int max = 0;

        for (int i = 0; i < size; ++i) {
            int value = Integer.parseInt(br.readLine().trim());
            belt.add(value);
        }

        for (int i = 0; i < stream - 1; ++i) {
            int value = belt.get(i);
            belt.add(value);
        }

        int total = belt.size();
        for (int i = 0; i < total; ++i) {
            int now = belt.remove(0);
            if (queue.isEmpty()) {
                queue.add(now);
            } else {
                int queueSize = queue.size();
                if (queue.contains(now)) {
                    max = Math.max(max, queueSize);
                    int index = queue.indexOf(now) + 1;
                    for (int j = 0; j < index; ++j) {
                        queue.remove(0);
                    }
                    queue.add(now);
                } else { // queue에 now가 없음
                    if (queueSize <= stream - 2) {
                        queue.add(now);
                    } else { // stream - 1
                        if (queue.contains(coupon)) {
                            queue.add(now);
                            max = Math.max(max, stream);
                        } else {
                            max = stream + 1;
                            break;
                        }
                    }

                }
            }
        }

        System.out.println(max);
    }
}
