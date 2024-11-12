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
                continue; // 길이 차이가 2 이상인 경우는 유사하지 않음
            }

            for (int j = 0; j < cmp_size; ++j) {
                int curr_alpha = cmp.charAt(j) - 'A';
                --cmp_counts[curr_alpha];
            }

            int positiveDiff = 0;
            int negativeDiff = 0;

            for (int count : cmp_counts) {
                if (count > 0) positiveDiff += count;
                else if (count < 0) negativeDiff -= count;
            }

            // 유사 단어 조건 판단
            if ((positiveDiff == 1 && negativeDiff == 0) || // 한 글자 추가
                    (positiveDiff == 0 && negativeDiff == 1) || // 한 글자 제거
                    (positiveDiff == 1 && negativeDiff == 1) || // 한 글자 차이
                    (positiveDiff == 0 && negativeDiff == 0)) { // 같은 단어
                ++similar_word;
            }
        }

        System.out.println(similar_word);
    }
}
