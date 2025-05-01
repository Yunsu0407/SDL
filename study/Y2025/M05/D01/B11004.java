package study.Y2025.M05.D01;

import java.util.*;
import java.io.*;

public class B11004 {
    public static void main(String[] args) throws IOException {
        getK();
    }

    public static void getK() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int size = Integer.parseInt(st.nextToken());
        int index = Integer.parseInt(st.nextToken()) - 1; // 입력 형태는 index가 아님

        List<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine().trim());
        for(int i = 0; i < size; ++i) {
            int value = Integer.parseInt(st.nextToken());
            list.add(value);
        }

        Collections.sort(list);
        System.out.println(list.get(index));
    }
}
