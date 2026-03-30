package Y2026.M03.D30;

import java.util.*;
import java.io.*;

public class B1436 {
    public static void main(String[] args) throws IOException {
        movie666();
    }

    public static void movie666() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine().trim());
        int value = 666;
        int count = 0;

        while (true) {
            if (String.valueOf(value).contains("666")) {
                count = count + 1;
            }

            if (count == target) {
                break;
            } else {
                value = value + 1;
            }
        }

        System.out.println(value);
    }
}
