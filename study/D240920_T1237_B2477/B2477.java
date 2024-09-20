package D240920_T1237_B2477;

import java.io.*;
import java.util.*;

public class B2477 {
    public static void main(String[] args) throws IOException {
        getMelon();
    }

    public static void getMelon() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int UNIT = Integer.parseInt(br.readLine().trim());
        Farm farm = new Farm(UNIT);
        for (int i = 0; i < 6; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int direction = Integer.parseInt(st.nextToken()) - 1;
            int length = Integer.parseInt(st.nextToken());
            farm.getInfo(i, direction, length);
        }
        int melon = farm.getMelon();
        System.out.println(melon);
    }

    public static class Farm {
        int width, height;
        int emptyWidth, emptyHeight;
        int[][] paths;
        int mpu;    // mellon per unit

        public Farm(int mpu) {
            paths = new int[6][2];
            this.mpu = mpu;
            width = 0;
            height = 0;
        }

        public void getInfo(int index, int direction, int length) {
            paths[index][0] = direction;
            paths[index][1] = length;
            if (direction == 0 || direction == 1) {
                if (length > width) {
                    width = length;
                }
            } else {
                if (length > height) {
                    height = length;
                }
            }
        }

        public void getEmpty() {
            for (int i = 0; i < 6; ++i) {
                int prev = ((i - 1) + 6) % 6;
                int next = (i + 1) % 6;
                if (paths[prev][0] == paths[next][0]) {
                    if (paths[i][0] == 0 || paths[i][0] == 1) {
                        emptyWidth = paths[i][1];
                    } else {
                        emptyHeight = paths[i][1];
                    }
                }
            }
        }

        public int getMelon() {
            getEmpty();
            return (width * height - emptyWidth * emptyHeight) * mpu;
        }
    }
}
