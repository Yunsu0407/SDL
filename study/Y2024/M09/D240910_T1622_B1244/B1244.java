package D240910_T1622_B1244;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1244 {
    public static void main(String[] args) throws IOException {
        bulbControl();
    }

    public static void bulbControl() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int SIZE = Integer.parseInt(br.readLine().trim());
        boolean[] bulbs = new boolean[SIZE];
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        setBulbs(bulbs, st);

        final int ORDER = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < ORDER; ++i) {
            st = new StringTokenizer(br.readLine().trim());
            int gender = Integer.parseInt(st.nextToken());
            int location = Integer.parseInt(st.nextToken());
            updateBulbs(bulbs, gender, location);
            int stop = 0;
        }
        br.close();
        prnBulbs(bulbs);
    }

    public static void setBulbs(boolean[] bulbs, StringTokenizer st) {
        for (int i = 0; i < bulbs.length; ++i) {
            int curr = Integer.parseInt(st.nextToken());
            bulbs[i] = (curr == 1);
        }
    }

    public static void updateBulbs(boolean[] bulbs, int gender, int location) {
        final int BOY = 1;
        final int GIRL = 2;

        if (gender == BOY) {
            boyFunction(bulbs, location);
        } else {
            girlFunction(bulbs, location);
        }
    }

    // 남학생: 스위치 번호 = 받은 수 * n -> 스위치 상태 변화
    public static void boyFunction(boolean[] bulbs, int location) {
        int size = bulbs.length;
        int index = location - 1;

        while (index < size) {
            bulbs[index] = !bulbs[index];
            index = index + location;
        }
    }

    // 여학생: 자기가 받은 수와 같은 번호가 붙은 스위치를 중심으로 좌우가 대칭이면서 가장 많은 스위치를 포함하는 구간을 찾아서 그 구간과 그 구간에 속한 스위치의 상태를 모두 바꿈
    public static void girlFunction(boolean[] bulbs, int location) {
        int size = bulbs.length;
        int index = location - 1;

        bulbs[index] = !bulbs[index];
        if (location > 0 && location < size) {
            int up, down;
            up = index + 1;
            down = index - 1;
            while (up < size && down > -1) {
                if (bulbs[up] == bulbs[down]) {
                    bulbs[up] = bulbs[down] = !bulbs[up];
                } else {
                    break;
                }
                ++up;
                --down;
            }
        }
    }

    public static void prnBulbs(boolean[] bulbs) {
        final String YES = "1";
        final String NO = "0";
        StringBuilder sb = new StringBuilder();
        int size = bulbs.length;

        for (int i = 0; i < size; ++i) {
            if (bulbs[i]) {
                sb.append(YES);
            } else {
                sb.append(NO);
            }
            sb.append(" ");
            if (i > 0 && (i+1) % 20 == 0) {
                sb.append("\n");
            }
        }

        System.out.print(sb.toString());
    }
}
