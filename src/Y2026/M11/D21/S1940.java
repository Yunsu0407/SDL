package Y2026.M11.D21;

import java.util.*;
import java.io.*;

public class S1940 {
    public static void main(String[] args) throws IOException {
        trackCar();
    }

    public static void trackCar() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < tc; ++i) {
            int time = Integer.parseInt(br.readLine().trim());
            int pos = 0;
            int vel = 0;

            for (int j = 0; j < time; ++j) {
                StringTokenizer st = new StringTokenizer(br.readLine().trim());
                int opt = Integer.parseInt(st.nextToken());
                int absAcc = opt == 0 ? 0 : Integer.parseInt(st.nextToken());
                int acc = opt == 1 ? absAcc : absAcc * (-1);

                vel = vel + acc;
                vel = vel < 0 ? 0 : vel;
                pos = pos + vel;
            }

            String line = String.format("#%d %d\n", (i + 1), pos);
            sb.append(line);
        }

        System.out.print(sb.toString());
    }
}
