package study.Y2025.M05.D10;

import java.util.*;
import java.io.*;

public class B1956 {
    public static void main(String[] args) throws IOException {
        pushBox();
    }

    public static void pushBox() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine().trim());
        List<Integer> baseSeq = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        // 1. 문제에서 주어지는 수열을 동적 배열에 입력한다.
        receiveSequence(size, st, baseSeq);

        // 2. 최대 연속 수열의 길이를 구하는 알고리즘을 이용해 그 값을 구한다.
        int ans = getMaxLength(baseSeq);

        // 3. 정답 출력
        System.out.println(ans);
    }

    // 주어지는 수열을 동적 배열에 입력하는 함수
    public static void receiveSequence(int size, StringTokenizer st, List<Integer> baseSeq) {
        for (int i = 0; i < size; ++i) {
            int curr = Integer.parseInt(st.nextToken());
            baseSeq.add(curr);
        }
    }

    // 최대 연속 수열의 길이를 구하는 알고리즘이 구현된 함수
    public static int getMaxLength(List<Integer> baseSeq) {
        List<Integer> maxSeq = new ArrayList<>();

        // 반복문 실행을 위해 기본 수열의 첫 번째 인자를 최장 길이 수열에 넣는다.
        maxSeq.add(baseSeq.get(0));

        // 기본 수열에 대해 다음을 반복한다.
        for (int target : baseSeq) {
            int idx = maxSeq.size() - 1;

            // target을 가지고 최장 길이 수열에서 다음을 반복한다.
            while (true) {
                // 만약 target이 수열에서 가장 작은 수라면
                if (idx < 0) {
                    // 맨 앞의 수를 제거하고, 맨 앞에 추가한다.
                    maxSeq.remove(0);
                    maxSeq.add(0, target);
                    break;
                }

                // 비교 대상 comp를 가져와서 target과 비교한다.
                int comp = maxSeq.get(idx);
                // 만약 target이 comp보다 작으면, 인덱스를 감소시키고 반복을 계속한다.
                if (target < comp) {
                    --idx;
                }
                // 그렇지 않고 target이 comp보다 크거나 같다면,
                else {
                    if (target > comp) {
                        // target이 comp보다 큰 경우, comp의 idx + 1 자리에 target 추가한다.
                        maxSeq.add(idx + 1, target);
                        // 하지만 만약 target이 수열의 중간에 추가된다면, 단순 추가가 아닌 교체를 해준다.
                        if (maxSeq.size() - 1 > idx + 1) {
                            // 원래 idx + 1 자리에 있던 수를 지워서 교체로 만든다.
                            maxSeq.remove(idx + 2);
                        }
                    }
                    break;
                }
            }
        }

        return maxSeq.size();
    }
}
