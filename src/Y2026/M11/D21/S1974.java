package Y2026.M11.D21;

import java.util.*;
import java.io.*;

public class S1974 {
    public static void main(String[] args) throws IOException {
        verifySdoku();
    }

    public static void verifySdoku() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < tc; ++i) {
            int size = 9;
            int[][] arr = new int[size][size];
            for (int r = 0; r < size; ++r) {
                StringTokenizer st = new StringTokenizer(br.readLine().trim());
                for (int c = 0; c < size; ++c) {
                    arr[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            int ans = checkRow(size, arr) && checkRect(size, arr) && checkCol(size, arr) ? 1 : 0;
            String line = String.format("#%d %d\n", (i + 1), ans);
            sb.append(line);
        }

        System.out.print(sb.toString());
    }

    public static boolean checkRow(int size, int[][] arr) {
        boolean ret = true;

        loop: for (int r = 0; r < size; ++r) {
            boolean[] digits = new boolean[10];

            for (int c = 0; c < size; ++c) {
                int num = arr[r][c];
                digits[num] = true;
            }

            for (int i = 1; i < digits.length; ++i) {
                if (!digits[i]) {
                    ret = false;
                    break loop;
                }
            }
        }

        return ret;
    }

    public static boolean checkRect(int size, int[][] arr) {
        boolean ret = true;
        int diff = size / 3;

        loop: for (int r = 0; r < size; r = r + diff) {
            for (int c = 0; c < size; c = c + diff) {
                boolean[] digits = new boolean[10];

                for (int sr = r; sr < r + diff; ++sr) {
                    for (int sc = c; sc < c + diff; ++sc) {
                        int num = arr[sr][sc];
                        digits[num] = true;
                    }
                }

                for (int i = 1; i < digits.length; ++i) {
                    if (!digits[i]) {
                        ret = false;
                        break loop;
                    }
                }
            }
        }

        return ret;
    }

    public static boolean checkCol(int size, int[][] arr) {
        boolean ret = true;

        loop: for (int c = 0; c < size; ++c) {
            boolean[] digits = new boolean[10];

            for (int r = 0; r < size; ++r) {
                int num = arr[r][c];
                digits[num] = true;
            }

            for (int i = 1; i < digits.length; ++i) {
                if (!digits[i]) {
                    ret = false;
                    break loop;
                }
            }
        }

        return ret;
    }
}
