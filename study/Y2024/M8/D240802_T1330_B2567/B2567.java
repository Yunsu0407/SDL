package D240802_T1330_B2567;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2567 {
    public static void main(String[] args) throws IOException {
        getLength();
    }

    // 함수 작성부
    public static void getLength() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int count = Integer.parseInt(br.readLine().trim());
        final int HUNDRED = 100;
        final int TEN = 10;
        boolean[][] area = new boolean[HUNDRED][HUNDRED];

        // 색종이 수 만큼 반복한다.
        for (int i = 0; i < count; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int ordX = Integer.parseInt(st.nextToken());
            int ordY = Integer.parseInt(st.nextToken());
            painting(area, ordX, ordY, TEN);
        }
        br.close();

        int length = countingLength(area, HUNDRED);
        System.out.printf("%d", length);
    }

    // 흰 색종이를 칠하는 함수
    public static void painting(boolean[][] area, int ordX, int ordY, int TEN) {
        for (int row = ordY; row < ordY + TEN; ++row) {
            for (int col = ordX; col < ordX + TEN; ++col) {
                area[row][col] = true;
            }
        }
    }

    // 둘레의 길이를 구하는 함수
    public static int countingLength(boolean[][] area, int HUNDRED) {
        int length = 0;

        for (int row = 0; row < HUNDRED; ++row) {
            for (int col = 0; col < HUNDRED; ++col) {
                if (area[row][col]) {
                    length = length + checkCardinalPoints(area, row, col);
                }
            }
        }

        return length;
    }

    // 유효한 포인트에 대해 네 방향을 모두 확인, 범위를 벗어나는 경우는 예외처리를 해주며 길이를 증가시킴
    public static int checkCardinalPoints(boolean[][] area, int x, int y) {
        int length = 0;
        final int DIRECTION = 4;
        // 상, 하, 좌, 우
        int[] dirX = {0, 0, -1, 1};
        int[] dirY = {1, -1, 0, 0};

        for(int i = 0; i < DIRECTION; ++i){
            try{
                int checkX = x + dirX[i];
                int checkY = y + dirY[i];
                if(!area[checkX][checkY]){
                    ++length;
                }
            } catch (ArrayIndexOutOfBoundsException e){
                ++length;
            }
        }

        return length;
    }
}
