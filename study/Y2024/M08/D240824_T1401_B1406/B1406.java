package study.Y2024.M08.D240824_T1401_B1406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class B1406 {
    public static void main(String[] args) throws IOException {
        editor();
    }

    public static void editor() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String initial = br.readLine().trim();
        final int COUNT = Integer.parseInt(br.readLine().trim());

        LinkedList<Character> sentence = new LinkedList<>();
        for (char c : initial.toCharArray()) {
            sentence.add(c);
        }
        ListIterator<Character> cursor = sentence.listIterator(initial.length());

        for (int i = 0; i < COUNT; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            String choice = st.nextToken();
            switch (choice) {
                case "L":
                    if (cursor.hasPrevious()) {
                        cursor.previous();
                    }
                    break;
                case "D":
                    if (cursor.hasNext()) {
                        cursor.next();
                    }
                    break;
                case "B":
                    if (cursor.hasPrevious()) {
                        cursor.previous();
                        cursor.remove();
                    }
                    break;
                case "P":
                    cursor.add(st.nextToken().charAt(0));
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : sentence) {
            sb.append(c);
        }
        System.out.println(sb);
    }
    /*
    L: 왼쪽 한 칸
    D: 오른쪽 한 칸
    B: 커서 왼쪽 삭제
    P $: 커서 왼쪽에 추가
     */
}
