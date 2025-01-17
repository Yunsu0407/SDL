package Y2025.M01.D17;

import java.util.*;
import java.io.*;

public class B1253 {
    public static void main(String[] args) throws IOException {
        good();
    }

    public static HashMap<Integer, Integer> set = new HashMap<>(); // 중복 제거된 전체 수열

    public static void good() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        for (int i = 0; i < count; ++i) {
            int key = Integer.parseInt(st.nextToken());

            if (set.containsKey(key)) { // 중복되는 경우
                int value = set.get(key) + 1;
                set.replace(key, value);
            } else { // 아닌 경우
                set.put(key, 1);
            }
        }

        int ans = 0;
        for (int curr : set.keySet()) {
            if (check(curr)) {
                ans = ans + set.get(curr);
            }
        }
        System.out.println(ans);
    }

    public static boolean check(int target) { // 합이 되는 두 수 확인하는 함수
        for(int base : set.keySet()){
            int diff = target - base; // 차이

            if (set.containsKey(diff)) {
                if ((target == diff && diff == base && base == 0)) {
                    if (set.get(target) >= 3) {
                        return true;
                    } else {
                        continue;
                    }
                }
                if (diff == 0 || base == 0) {
                    if (set.get(target) > 1) {
                        return true;
                    }
                }
                if (target != base && base != diff && diff != target) {
                    return true;
                }
            }
        }
        return false; // 다 돌아서 안되면 표현 불가능
    }
}
