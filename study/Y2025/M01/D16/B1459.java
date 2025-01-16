package Y2025.M01.D16;

import java.util.*;
import java.io.*;

public class B1459 {
    public static void main(String[] args) throws IOException {
        walking();
    }

    public static void walking() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        long ordX = Integer.parseInt(st.nextToken());
        long ordY = Integer.parseInt(st.nextToken());
        long straight = Integer.parseInt(st.nextToken()); // s = straight = 직선
        long diagonal = Integer.parseInt(st.nextToken()); // d = diagonal = 대각선

        long ans = 0;
        if (diagonal < 2 * straight) {
            long max = Math.max(ordX, ordY);
            long min = Math.min(ordX, ordY);
            long diff = max - min;
            ans = min * diagonal;
            if (diff > 0) {
                if (diff == 1) {
                    ans = ans + diff * straight;
                } else {
                    if (straight < diagonal) {
                        ans = ans + diff * straight;
                    } else {
                        if (diff % 2 == 0) { // 짝수
                            ans = ans + diff * diagonal;
                        } else { // 홀수
                            ans = ans + straight + (diff - 1) * diagonal;
                        }
                    }
                }
            }
        } else {
            ans = (ordX + ordY) * straight;
        }
        System.out.println(ans);
    }
}
