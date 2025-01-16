package Y2025.M01.D16;

import java.util.*;
import java.io.*;

public class B1063 {
    public static void main(String[] args) throws IOException {
        checkThings();
    }

    public static String input1 = "A1 A2 5\nB\nL\nLB\nRB\nLT";
    public static String input4 = "A1 A2 2\nT\nR";
    public static final int SIZE = 8, ROW = 0, COL = 1;

    public static void checkThings() throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader(input4));
        int[][] board = new int[SIZE][SIZE];
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        String iKing = st.nextToken(); // initial king
        String iStone = st.nextToken(); // initial stone
        int count = Integer.parseInt(st.nextToken());
        int[] ordKing = new int[2];
        int[] ordStone = new int[2];

        setOrd(ordKing, iKing);
        setOrd(ordStone, iStone);

        Queue<Integer> orders = new ArrayDeque<>();
        for (int i = 0; i < count; ++i) {
            String order = br.readLine().trim();
            int dir = setDir(order);
            orders.add(dir);
        }

        int[][] allDir = {
                {-1, -1, +0, +1, +1, +1, +0, -1},
                {+0, +1, +1, +1, +0, -1, -1, -1}
        };

        board[ordKing[ROW]][ordKing[COL]] = 1;
        board[ordStone[ROW]][ordStone[COL]] = 2;
        while (!orders.isEmpty()) {
            int currDir = orders.remove();
            int[] ordNextKing = new int[2];

            ordNextKing[ROW] = ordKing[ROW] + allDir[ROW][currDir];
            ordNextKing[COL] = ordKing[COL] + allDir[COL][currDir];
            if (!isOut(ordNextKing)) { // 이동 후 킹이 판 안에 있으면
                if (ordStone[ROW] == ordNextKing[ROW] && ordStone[COL] == ordNextKing[COL]) { // 킹이 이동할 자리에 돌이 있는 경우
                    int[] ordNextStone = new int[2];

                    ordNextStone[ROW] = ordStone[ROW] + allDir[ROW][currDir];
                    ordNextStone[COL] = ordStone[COL] + allDir[COL][currDir];
                    if (!isOut(ordNextStone)) { // 돌이 이동한 자리가 판 안이면
                        ordStone[ROW] = ordNextStone[ROW];
                        ordStone[COL] = ordNextStone[COL];
                    } else { // 판 안이 아니라면 이동을 취소해야함
                        continue;
                    }
                }
                ordKing[ROW] = ordNextKing[ROW];
                ordKing[COL] = ordNextKing[COL];
            }
        }

        StringBuilder sb = new StringBuilder();
        setAns(sb, ordKing);
        setAns(sb, ordStone);
        System.out.println(sb.toString());
    }

    public static void setAns(StringBuilder sb, int[] ord) {
        int finalRow = SIZE - ord[ROW];
        char finalCol = (char) (ord[COL] + 'A');
        sb.append(finalCol).append(finalRow).append("\n");
    }

    public static boolean isOut(int[] ordNext) {
        return ordNext[ROW] < 0 || ordNext[ROW] > SIZE - 1 || ordNext[COL] < 0 || ordNext[COL] > SIZE - 1;
    }

    public static int setDir(String order) {
        int ret;
        switch (order) {
            case "T":
                ret = 0;
                break;
            case "RT":
                ret = 1;
                break;
            case "R":
                ret = 2;
                break;
            case "RB":
                ret = 3;
                break;
            case "B":
                ret = 4;
                break;
            case "LB":
                ret = 5;
                break;
            case "L":
                ret = 6;
                break;
            case "LT":
                ret = 7;
                break;
            default:
                ret = -1;
        }
        return ret;
    }

    public static void setOrd(int[] ord, String init) {
        int row = '8' - init.charAt(1);
        int col = init.charAt(0) - 'A';
        ord[ROW] = row;
        ord[COL] = col;
    }
}
