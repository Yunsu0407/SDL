package D241109_T1201_B9655;

import java.util.*;
import java.io.*;

public class B9655 {
    public static void main(String[] args) throws IOException {
        stoneGame();
    }
    public static void stoneGame() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine().trim());
        if(size % 2 != 0){
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }
    }
}
