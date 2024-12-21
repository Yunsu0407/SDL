package study.Y2024.M11.D241130_B1138;

import java.util.*;
import java.io.*;

public class B1138 {
    public static void main(String[] args) throws IOException {
        makeLine();
    }

    public static void makeLine() throws IOException {
        BufferedReader br = new BufferedReader(new StringReader("4\n" +
                "2 1 1 0"));
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int number = Integer.parseInt(br.readLine().trim());
        st = new StringTokenizer(br.readLine().trim());
        int[] position = new int[number];

        for(int i = 0; i < number; ++i){
            int order = i + 1;
            int hint = Integer.parseInt(st.nextToken());
            position[hint] = order;
        }

        StringBuilder sb = new StringBuilder();
        for(int person: position){
            sb.append(person).append(" ");
        }

        System.out.println(sb.toString());
    }
}
