package solutions.stage3.D240710_T1047_S1860;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;

public class S1860 {
    public static void main(String[] args) throws IOException {
        judgeAvailable();
    }

    public static void judgeAvailable() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int testcase = Integer.parseInt(br.readLine().trim());
        String[] answer = new String[testcase];
        String possible = "Possible";
        String impossible = "Impossible";

        for (int i = 0; i < testcase; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int customer = Integer.parseInt(st.nextToken());  // N, 구매자의 수
            final int CYCLE = Integer.parseInt(st.nextToken());  // M, 붕어빵 하나 만드는 데 걸리는 시간
            final int QUNATITY = Integer.parseInt(st.nextToken());    // K, 한 사이클 당 만드는 붕어빵의 수
            int[] arrival = new int[customer];  // 구매자 도착 시간
            boolean tooEarly = false;

            st = new StringTokenizer(br.readLine().trim());
            HashMap<Integer, Integer> customerMap = new HashMap<>();    // 도착시간 당 도착인원을 저장할 맵
            for (int j = 0; j < customer; ++j) {  // 도착시간 저장
                int arrivalTime = Integer.parseInt(st.nextToken()); // 개인의 도착시간
                if (arrivalTime == 0) {
                    tooEarly = true;
                    break;
                }
                int value;
                if (customerMap.containsKey(arrivalTime)) {   // 동일한 도착시간에 도착하는 구매자가 있는 경우
                    value = customerMap.get(arrivalTime) + 1;
                } else {    // 없는 경우
                    value = 1;
                }
                customerMap.put(arrivalTime, value);
            }

            boolean isPossible = true;  // 임무 성공 여부
            if (tooEarly) {
                isPossible = false;
            } else {
                int time = 0;   // 누적시간
                int bread = 0;  // 누적 빵 개수
                while (customer > 0) {
                    ++time;
                    if (time % CYCLE == 0) { // 빵 생산
                        bread = bread + QUNATITY;
                        if (bread >= customer) {  // 현재 빵의 양이 남은 고객의 수보다 많거나 같으면
                            break;
                        }
                    }
                    if (customerMap.containsKey(time)) {  // 현재 시간에 방문할 손님이 있는 경우
                        if (bread > 0) {  // 빵이 있는 경우
                            int purchase = customerMap.remove(time);    // 손님의 수 추출
                            if (bread >= purchase) {  // 빵이 충분한 경우
                                bread = bread - purchase;
                                customer = customer - purchase;
                            } else {    // 모자르는 경우
                                isPossible = false;
                                break;
                            }
                        } else {    // 빵이 없는 경우
                            isPossible = false;
                            break;
                        }
                    }
                }
            }

            if (isPossible) {
                answer[i] = possible;
            } else {
                answer[i] = impossible;
            }
        }
        br.close();

        for (int i = 0; i < testcase; ++i) {
            System.out.printf("#%d %s\n", i + 1, answer[i]);
        }
    }
}
