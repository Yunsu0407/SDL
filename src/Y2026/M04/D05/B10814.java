package Y2026.M04.D05;

import java.util.*;
import java.io.*;

public class B10814 {
    public static void main(String[] args) throws IOException {
        arrangeAge();
    }

    public static class Info {
        int order;
        int age;
        String name;

        public Info(int order, int age, String name) {
            this.order = order;
            this.age = age;
            this.name = name;
        }
    }

    public static void arrangeAge() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine().trim());

        List<Info> list = new ArrayList<>();
        for (int i = 0; i < size; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            list.add(new Info(i, age, name));
        }
        list.sort(
                Comparator.comparingInt((Info i) -> i.age)
                        .thenComparingInt(i -> i.order));

        StringBuilder sb = new StringBuilder();
        for (Info info : list) {
            sb.append(info.age).append(" ").append(info.name).append("\n");
        }

        System.out.println(sb.toString());
    }
}
