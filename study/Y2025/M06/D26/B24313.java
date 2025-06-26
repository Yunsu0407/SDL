package study.Y2025.M06.D26;

import java.util.*;
import java.io.*;

public class B24313 {
    public static void main(String[] args) throws IOException {
        asymptoticNotation();
    }

    // f(x) = ax + b
    // g(x) = cx
    // d = n0
    // e = b / (c - a)
    public static void asymptoticNotation() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(br.readLine().trim());
        int d = Integer.parseInt(br.readLine().trim());
        int ans;

        if(a < c) {
            double e = (double)b / (c - a);
            if((double)d >= e) {
                ans = 1;
            } else {
                ans = 0;
            }
        } else if(a == c) {
            if(b <= 0) {
                ans = 1;
            } else {
                ans = 0;
            }
        } else { // a > c
            ans = 0;
        }

        System.out.println(ans);
    }
}
