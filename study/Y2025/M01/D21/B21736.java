package Y2025.M01.D21;

import java.util.*;
import java.io.*;

public class B21736 {
    public static void main(String[] args) throws IOException {
        findPerson();
    }

    public static String input1 = "3 5\n" +
            "OOOPO\n" +
            "OIOOX\n" +
            "OOOXP";
    public static String input2 = "3 3\n" +
            "IOX\n" +
            "OXP\n" +
            "XPP";
    public static final int ROW = 0, COL = 1;

    public static void findPerson() throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader(input1));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int[][] room = new int[row][col]; // 방의 상태
        class Ordinate { // 좌표 클래스
            int row, col;

            Ordinate(int row, int col) {
                this.row = row;
                this.col = col;
            }
        }

        Ordinate center = null; // 중심 좌표
        for (int i = 0; i < row; ++i) {
            String line = br.readLine().trim();
            for (int j = 0; j < col; ++j) {
                char curr = line.charAt(j);
                int value = setValue(curr);
                if (value == 1) {
                    center = new Ordinate(i, j);
                }
                room[i][j] = value;
            }
        } // 방 상태 갱신

        boolean[][] isVisit = new boolean[row][col]; // 방문 정보 저장
        int[][] dir = { // 4방향, 시계
                {-1, +0, +1, +0},
                {+0, +1, +0, -1}
        };

        int count = 0; // 다른 사람 수
        Queue<Ordinate> queue = new ArrayDeque<>(); // 대기열
        queue.add(center); // 대기열에 추가
        isVisit[center.row][center.col] = true; // 자신의 위치 방문 정보에 추가
        // 방문 관리, O: 0, X: -1, P: 2 I: 1
        while (!queue.isEmpty()) {
            Ordinate cOrd = queue.remove();
            for (int i = 0; i < 4; ++i) {
                int nextRow = cOrd.row + dir[ROW][i];
                int nextCol = cOrd.col + dir[COL][i];

                if (!(nextRow < 0 || nextRow >= row || nextCol < 0 || nextCol >= col)) { // 범위를 벗어나지 않고
                    if (!isVisit[nextRow][nextCol]) { // 방문 안한 곳이면, O X P
                        int currState = room[nextRow][nextCol];
                        if (currState != -1) { // 벽이 아니면 , 빈 공간이거나 사람이 있는 경우
                            if (currState == 2) { // 사람이 있으면
                                ++count; // 정답 갱신
                            }
                            queue.add(new Ordinate(nextRow, nextCol)); // 큐에 추가
                        }
                        isVisit[nextRow][nextCol] = true; // 방문 갱신
                    }
                }
            }
        }

        String ans;
        if (count == 0) {
            ans = "TT";
        } else {
            ans = String.valueOf(count);
        }
        System.out.println(ans);
    }

    public static int setValue(char curr) {
        int value;
        switch (curr) {
            case 'O':
                value = 0;
                break;
            case 'X':
                value = -1;
                break;
            case 'P':
                value = 2;
                break;
            case 'I':
                value = 1;
                break;
            default:
                value = -2;
        }
        return value;
    }
}
