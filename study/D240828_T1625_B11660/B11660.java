package D240828_T1625_B11660;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11660 {
    public static void main(String[] args) throws IOException {
        areaSum();
    }

    public static void areaSum() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine().trim());
        final int SIZE = Integer.parseInt(st.nextToken());
        final int ORDER = Integer.parseInt(st.nextToken());
        int[][] board = new int[SIZE][SIZE + 1];

        for (int r = 0; r < SIZE; ++r) {
            st = new StringTokenizer(br.readLine().trim());
            int sum = 0;
            for (int c = 0; c < SIZE; ++c) {
                int curr = Integer.parseInt(st.nextToken());
                board[r][c] = curr;
                sum = sum + curr;
            }
            board[r][SIZE] = sum;
        }   // receive board numbers

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ORDER; ++i) {   // 1 2 1 2
            st = new StringTokenizer(br.readLine().trim());
            int x1 = Integer.parseInt(st.nextToken()) - 1;
            int y1 = Integer.parseInt(st.nextToken()) - 1;
            int x2 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = Integer.parseInt(st.nextToken()) - 1;
            int sum = 0;
            if (y2 - y1 > SIZE / 2) {
                for (int r = x1; r <= x2; ++r) {
                    sum = sum + board[r][SIZE];
                    for (int c = 0; c <= y1; ++c) {
                        sum = sum - board[r][c];
                    }
                    for (int c = y2; c < SIZE; ++c) {
                        sum = sum - board[r][c];
                    }
                }
            } else {
                for (int r = x1; r <= x2; ++r) {
                    for (int c = y1; c <= y2; ++c) {
                        sum = sum + board[r][c];
                    }
                }
            }

            sb.append(String.format("%d\n", sum));
        }
        br.close();

        System.out.print(sb.toString());
    }
}
