package Y2026.M03.D22;

import java.util.*;
import java.io.*;

public class B2609 {
    public static void main(String[] args) throws IOException {
        getGCDandLCM();
    }

    public static void getGCDandLCM() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int[] nums = new int[2]; // nums = numbers
        for (int i = 0; i < nums.length; ++i) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        if (nums[0] == 1 && nums[0] == nums[1]) {
            sb.append(1).append("\n").append(1);
        } else {
            int arrSize = Math.max(nums[0], nums[1]); // arrSize = array size
            boolean[] isPrime = new boolean[arrSize + 1];
            Arrays.fill(isPrime, true);
            isPrime[0] = isPrime[1] = false;
            for (int i = 2; i < isPrime.length; ++i) {
                if (isPrime[i]) {
                    int mul = 2; // mul = multiplier
                    int idx = i * mul; // idx = index

                    while (idx < isPrime.length) {
                        isPrime[idx] = false;
                        mul = mul + 1;
                        idx = i * mul;
                    }
                }
            }

            List<Map<Integer, Integer>> maps = new ArrayList<>();
            for (int i = 0; i < nums.length; ++i) {
                maps.add(new HashMap<>());
            }

            for (int i = 0; i < nums.length; ++i) {
                Map<Integer, Integer> currMap = maps.get(i); // currMap = current map
                int target = nums[i];
                int idx = 2;

                while (idx <= target) {
                    if (isPrime[idx] && target % idx == 0) { // 소수가 약수인 경우
                        int key = idx;
                        int value = 0;
                        while (target % key == 0) {
                            target = target / key;
                            value = value + 1;
                        }

                        currMap.put(key, value);
                    }
                    idx = idx + 1;
                }
            }

            int gcd = 1; // greatest common divisor
            int lcm = 1; // least common multiplier
            Map<Integer, Integer> map1 = maps.get(0);
            Map<Integer, Integer> map2 = maps.get(1);
            Set<Integer> cmKey = new HashSet<>(); // cmKey = common key
            for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
                int key = entry.getKey();
                int value1 = entry.getValue();

                if (map2.containsKey(key)) {
                    cmKey.add(key);
                    int value2 = map2.get(key);
                    int minExp = Math.min(value1, value2); // minimal exponent
                    int maxExp = Math.max(value1, value2); // maximum exponent
                    gcd = gcd * (int) Math.pow(key, minExp);
                    lcm = lcm * (int) Math.pow(key, maxExp);
                }
            }

            if (!cmKey.isEmpty()) {
                for (int key : cmKey) {
                    map1.remove(key);
                    map2.remove(key);
                }
            }

            for (int i = 0; i < maps.size(); ++i) {
                Map<Integer, Integer> currMap = maps.get(i);
                if (currMap.isEmpty()) {
                    continue;
                }

                for (Map.Entry<Integer, Integer> entry : currMap.entrySet()) {
                    int key = entry.getKey();
                    int value = entry.getValue();

                    lcm = lcm * (int) Math.pow(key, value);
                }
            }

            sb.append(gcd).append("\n").append(lcm);
        }

        System.out.println(sb.toString());
    }
}
