package D241109_T1305_B2607;

import java.util.*;
import java.io.*;

public class B2607 {
    public static void main(String[] args) throws IOException {
        similarWord();
    }

    public static void similarWord() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int CASE = Integer.parseInt(br.readLine().trim()) - 1;
        String std = br.readLine().trim();
        int std_size = std.length();
        int[] std_counts = new int[26];

        for (int i = 0; i < std_size; ++i) {
            int curr_alpha = std.charAt(i) - 'A';
            ++std_counts[curr_alpha];
        }

        int similar_word = 0;
        for (int i = 0; i < CASE; ++i) {
            String cmp = br.readLine().trim();
            int cmp_size = cmp.length();
            int[] cmp_counts = std_counts.clone();

            if (Math.abs(std_size - cmp_size) > 1) {
                continue;
            }

            for (int j = 0; j < cmp_size; ++j) {
                int curr_alpha = cmp.charAt(j) - 'A';
                --cmp_counts[curr_alpha];
            }

            int sum = 0;
            boolean pass = false;
            for(int curr : cmp_counts){
                if(Math.abs(curr) >= 2){
                    pass = true;
                    break;
                }
                sum = sum + curr;
            }

            if(pass){
                continue;
            }

            if(sum <= 1){
                ++similar_word;
            }
        }

        System.out.println(similar_word);
    }
}
