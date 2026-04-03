package Y2026.M04.D03;

import java.util.*;
import java.io.*;

public class B1966 {
    public static void main(String[] args) throws IOException {
        printerQueue();
    }

    public static class Doc {
        int index;
        int order;

        public Doc(int index, int order) {
            this.index = index;
            this.order = order;
        }
    }

    public static void printerQueue() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tc; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int size = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine().trim());

            int[] importance = new int[10];
            List<Doc> list = new ArrayList<>();
            for (int j = 0; j < size; ++j) {
                int order = Integer.parseInt(st.nextToken());
                list.add(new Doc(j, order));
                importance[order] = importance[order] + 1;
            }

            int outCnt = 0;
            loop: for (int j = importance.length - 1; j > -1; --j) {
                for (int k = importance[j]; k > 0; --k) {
                    while (true) {
                        Doc doc = list.remove(0);
                        if (doc.order == j) {
                            outCnt = outCnt + 1;

                            if (doc.index == target) {
                                break loop;
                            } else {
                                break;
                            }
                        } else {
                            list.add(doc);
                        }
                    }
                }
            }

            sb.append(outCnt).append("\n");
        }

        System.out.println(sb.toString());
    }
}
