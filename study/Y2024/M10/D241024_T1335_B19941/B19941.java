package D241024_T1335_B19941;

import java.io.*;
import java.util.*;

public class B19941 {
    public static void main(String[] args) throws IOException {
        distribute();
    }

    public static int N, K;
    public static int max = 0;

    public static void distribute() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[] tables = new int[N];   // 햄버거 2, 못 먹은 사람 1, 먹은 사람 0

        String data = br.readLine().trim();    // 테이블 정보
        for (int i = 0; i < N; ++i) {           // 테이블을 순회하며 정보 저장
            char table = data.charAt(i);
            if (table == 'H') {
                tables[i] = 2;
            } else {
                tables[i] = 1;
            }
        }

        for (int i = 0; i < N; ++i) {
            int table = tables[i];
            if (table == 2) {
                int front = i - K;  // 앞 인덱스
                int back = i + K;   // 뒤 인덱스
                if (front < 0) {    // 인덱스가 0보다 작아지면 0으로 설정
                    front = 0;
                }
                if (back >= N) {    // 인덱스가 N보다 크거나 같아지면 N-1로 설정
                    back = N - 1;
                }
                for (int j = front; j < back + 1; ++j) {    // 사정거리만큼 확인
                    final int PERSON = 1;
                    int search = tables[j];
                    if(search == PERSON){   // 먹을 수 있는 사람이 있으면
                        --tables[j];
                        ++max;  // 최대 인원 증가시키고
                        break;  // 종료
                    }
                }
            }
        }

        System.out.println(max);
    }

}
