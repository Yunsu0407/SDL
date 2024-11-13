package study.D241113_T0958_B21921;

import java.util.*;
import java.io.*;

public class B21921 {
    public static void main(String[] args) throws IOException {
        manageBlog();
    }

    public static int operating_day, limitation_day; // 운영 기간, 제한 기간
    public static int maxVisitor = 0, maxDates = 0; // 최대 방문자 수, 최대 방문일
    public static int[] cumulativeVisitors; // 누적합 배열
    public static final String SAD = "SAD";

    public static void manageBlog() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        operating_day = Integer.parseInt(st.nextToken());
        limitation_day = Integer.parseInt(st.nextToken());

        cumulativeVisitors = new int[operating_day];
        int accumulated = 0; // 누적 방문자 총합
        st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < operating_day; ++i) {
            int curr = Integer.parseInt(st.nextToken()); // 특정일 방문자 수
            accumulated = accumulated + curr; // 누적 방문자 총합 갱신
            cumulativeVisitors[i] = accumulated; // 누적합 배열 갱신
        }

        String output;
        if (accumulated == 0) {
            output = SAD;
        } else {
            countMax();
            output = String.format("%d\n%d", maxVisitor, maxDates);
        }

        System.out.println(output);
    }

    public static void countMax() { // 누적합 배열을 이용해서 방문자 수 비교
        for (int i = limitation_day - 1; i < operating_day; ++i) {
            int currSum = cumulativeVisitors[i]; // 현재 방문자 총합
            int pastIndex = i - limitation_day; // 제한 시작일
            int pastSum; // 제한 시점 방문자 총합
            if (pastIndex < 0) {
                // 인덱스가 음수가 되면 0으로 처리
                pastSum = 0;
            } else {
                pastSum = cumulativeVisitors[pastIndex];
            }
            int tempVisitor = currSum - pastSum; // 제한 기간 내 방문자 수 계산
            if (tempVisitor >= maxVisitor) {
                if(tempVisitor > maxVisitor){
                    // 최대 방문자 수보다 크면 최대 방문자 수 갱신하고 방문일 1로 초기화
                    maxVisitor = tempVisitor;
                    maxDates = 1;
                } else {
                    // 최대 방문자 수와 같으면 최대 방문일 갱신
                    ++maxDates;
                }
            }
        }
    }
}
