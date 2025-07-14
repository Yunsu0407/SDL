package study.Y2025.M07.D14;

import java.util.*;
import java.io.*;

public class B1476 {
    public static void main(String[] args) throws IOException {
        calcDate();
    }

    public static final int E = 15, S = 28, M = 19;

    public static void calcDate() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int earth = Integer.parseInt(st.nextToken()); // 15
        int sun = Integer.parseInt(st.nextToken()); // 28
        int moon = Integer.parseInt(st.nextToken()); // 19
        int ans;

        int target = 0, subTarget = E * S * M;
        while (true) {
            if (findDate(target, earth, sun, moon)) {
                ans = target;
                break;
            }

            if (findDate(subTarget, earth, sun, moon)) {
                ans = subTarget;
                break;
            }

            ++target;
            --subTarget;
        }

        ans = ans == 0 ? 7980 : ans;

        System.out.print(ans);
    }

    public static boolean findDate(int target, int earth, int sun, int moon) {
        boolean ret = false;
        int restEarth = getRest(target, E);
        int restSun = getRest(target, S);
        int restMoon = getRest(target, M);

        if (restEarth == earth && restSun == sun && restMoon == moon) {
            ret = true;
        }

        return ret;
    }

    public static int getRest(int target, int modulus) {
        int rest = target % modulus;
        return rest == 0 ? modulus : rest;
    }
}
