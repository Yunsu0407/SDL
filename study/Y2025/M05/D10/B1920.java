package study.Y2025.M05.D10;

import java.util.*;
import java.io.*;

public class B1920 {
    public static void main(String[] args) throws IOException {
        searchValue();
    }

    public static void searchValue() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int baseSize = Integer.parseInt(br.readLine().trim());
        String baseStr = br.readLine().trim();
        int askSize = Integer.parseInt(br.readLine().trim());
        String askStr = br.readLine().trim();

        // 1. HashSet 변수 baseSet을 만들고, 문제에서 주어진 수들을 그 안에 입력한다.
        Set<Integer> baseSet = new HashSet<>();
        StringTokenizer st = new StringTokenizer(baseStr);
        for (int i = 0; i < baseSize; ++i) {
            int curr = Integer.parseInt(st.nextToken());
            baseSet.add(curr);
        }

        // 2. 문제에서 찾고자 하는 수들을 set.contains() 함수를 이용해 baseSet에서 찾는다.
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(askStr);
        for (int i = 0; i < askSize; ++i) {
            int curr = Integer.parseInt(st.nextToken());
            int ans = 0;
            if(baseSet.contains(curr)) {
                ans = 1;
            }
            sb.append(ans).append("\n");
        }

        // 3. 정답 출력
        System.out.println(sb.toString());
    }
}
