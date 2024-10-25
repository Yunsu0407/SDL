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
        int[] state = new int[N];   // 햄버거 2, 못 먹은 사람 1, 먹은 사람 0

        String s = br.readLine().trim();
        for (int i = 0; i < N; ++i) {
            char curr = s.charAt(i);
            if (curr == 'H') {
                state[i] = 2;
            } else {
                state[i] = 1;
            }
        }

        for (int i = 0; i < N; ++i) {
            int curr = state[i];
            if (curr == 2) {
                int front = i - K;
                int back = i + K;
                if (front < 0) {
                    front = 0;
                }
                if (back >= N) {
                    back = N - 1;
                }
                for (int j = front; j < back + 1; ++j) {
                    int person = state[j];
                    if(person == 1){
                        --state[j];
                        ++max;
                        break;
                    }
                }
            }
        }

        System.out.println(max);
    }

}
