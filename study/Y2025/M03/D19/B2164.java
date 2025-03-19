package study.Y2025.M03.D19;

import java.util.*;
import java.io.*;

public class B2164 {
    public static void main(String[] args) throws IOException {
        shuffleCard();
    }

    public static void shuffleCard() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine().trim());

        Queue<Integer> cards = new ArrayDeque<>();
        for (int i = 1; i < size + 1; ++i) {
            cards.add(i);
        }

        boolean addSign = false;
        while (!(cards.size() == 1)) {
            int curr = cards.remove();
            if (addSign) {
                cards.add(curr);
            }
            addSign = !addSign;
        }

        System.out.print(cards.remove());
    }
}
