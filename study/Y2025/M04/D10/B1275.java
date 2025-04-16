package study.Y2025.M04.D10;

import java.util.*;
import java.io.*;

public class B1275 {
    public static void main(String[] args) throws IOException {
        simulateGame();
    }

    public static String input1 = "5 2\n" +
            "1 2 3 4 5\n" +
            "2 3 3 1\n" +
            "3 5 4 1";
    // ans = 5\n 10

    public static void simulateGame() throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader(input1));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int sizeOfNum = Integer.parseInt(st.nextToken()); // 1 ~ 100_000
        int sizeOfTurn = Integer.parseInt(st.nextToken()); // 1 ~ 100_000


    }
}
