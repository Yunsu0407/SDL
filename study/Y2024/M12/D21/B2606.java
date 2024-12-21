package Y2024.M12.D21;

import java.util.*;
import java.io.*;

/*
네트워크가 연결된 컴퓨터는 바이러스가 퍼짐
바이러스가 퍼진 컴퓨터의 수를 구하여라

연결 관계를 어떻게 표현하는게 좋을까?


 */

public class B2606 {

    public static void main(String[] args) throws IOException {
        checkVirus();
    }

    public static void checkVirus() throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader("7\n" +
                "6\n" +
                "1 2\n" +
                "2 3\n" +
                "1 5\n" +
                "5 2\n" +
                "5 6\n" +
                "4 7"));
        int size = Integer.parseInt(br.readLine().trim());
        int pair = Integer.parseInt(br.readLine().trim());
        boolean[][] relation = new boolean[size][size]; // 관계 저장 배열
        boolean[] visit = new boolean[size]; // 방문 관리 배열

        for (int i = 0; i < pair; ++i) { // 관계 저장
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int src = Integer.parseInt(st.nextToken()) - 1;
            int des = Integer.parseInt(st.nextToken()) - 1;
            relation[src][des] = relation[des][src] = true;
        }

        HashSet<Integer> target = new HashSet<>();

        int total = 0;
        target.add(0);
        visit[0] = true;
        while (!target.isEmpty()) { // 감염시킬 컴퓨터가 남아있는 동안 계속
            HashSet<Integer> next = new HashSet<>();

            for (int now : target) { // 다음 컴퓨터 확인
                for (int j = 0; j < size; ++j) {
                    if (relation[now][j] && !visit[j]) { // 관계가 있고, 방문하지 않은 컴퓨터라면
                        next.add(j);
                        visit[j] = true;
                        ++total;
                    }
                }
            }

            target = next;
        }

        int stop = 0;
        System.out.println(total);
    }
}















