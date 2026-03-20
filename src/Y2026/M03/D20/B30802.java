package Y2026.M03.D20;

import java.util.*;
import java.io.*;

public class B30802 {
    public static void main(String[] args) throws IOException {
        welcomeKit();
    }

    public static void welcomeKit() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int part; // part = participant
        int[] demands = new int[6];
        int[] ranges = new int[2];

        part = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < demands.length; ++i) {
            demands[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < ranges.length; ++i) {
            ranges[i] = Integer.parseInt(st.nextToken());
        }

        int shirtBundle = 0;
        for (int curr : demands) {
            shirtBundle = shirtBundle + curr / ranges[0];
            if (curr % ranges[0] != 0) {
                shirtBundle = shirtBundle + 1;
            }
        }
        int penBundle = part / ranges[1];
        int penPiece = part % ranges[1];

        StringBuilder sb = new StringBuilder();
        sb.append(shirtBundle).append("\n");
        sb.append(penBundle).append(" ").append(penPiece);
        System.out.println(sb.toString());
    }
}
