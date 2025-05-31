package study.Y2025.M05.D29;

import java.util.*;
import java.io.*;

public class B10819 {
    public static void main(String[] args) throws IOException {
        makeMaxDiff();
    }

    public static void makeMaxDiff() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine().trim());

        // 1. 배열 입력 받기
        int[] num = new int[size];
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < num.length; ++i) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        // 2. 재귀적으로 local sum 계산하기
        for (int i = 0; i < num.length; ++i) {
            boolean[] used = new boolean[size];
            used[i] = true;
            recSum(num, used, i, num.length - 1, 0);
        }

        // 3. 최대값 출력
        System.out.println(max);
    }

    public static int max = Integer.MIN_VALUE;

    // 재귀적으로 local sum을 계산하는 함수
    public static void recSum(int[] num, boolean[] used, int prvIdx, int cnt, int sum) {
        if (cnt > 0) {
            int nxtCnt = cnt - 1;
            int prev = num[prvIdx];

            for (int i = 0; i < num.length; ++i) {
                if (!used[i]) {
                    used[i] = true;

                    int curr = num[i];
                    int locSum = Math.abs(prev - curr);
                    int nxtSum = sum + locSum;

                    recSum(num, used, i, nxtCnt, nxtSum);
                    used[i] = false;
                }
            }
        } else {
            max = Math.max(max, sum);
        }
    }
}
