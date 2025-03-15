package study.Y2025.M03.D15;

import java.util.*;
import java.io.*;

/*
단어 수학 문제는 N개의 단어로 이루어져 있다.
각 단어는 알파벳 대문자로만 이루어져 있다.
단어 내의 알파벳은 0부터 9 숫자로 변환할 수 있지만, 숫자의 중복 사용은 불가능하다.
ex) AB + C = 98 + 7 = 105
N개의 단어가 주어졌을 때, 그 수의 합을 최대로 만드는 프로그램을 작성하기
단어의 개수는 1이상 10이하, 알파벳의 종류는 최대 10개, 단어의 길이는 최대 8

낱말의 위치에 가중치를 부여하는 건 어떨까?
가중치 = 10^(자릿수)
가중치대로 숫자를 배정한다.
가중치의 최대가 약 11억이니까 정수형(int) 사용가능

해쉬맵 써야할듯
B   F   C
0   100 11 ...  120
 */

public class B1339 {
    public static void main(String[] args) throws IOException {
        computeAlphabet();
    }

    public static void computeAlphabet() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine().trim());
        HashMap<Character, Integer> alphabetWeights = new HashMap<>();

        for (int i = 0; i < size; ++i) {
            String word = br.readLine().trim();

            for (int j = 0; j < word.length(); ++j) {
                char alphabet = word.charAt(j);
                int weight = (int) Math.pow(10, word.length() - (j + 1));

                if (alphabetWeights.containsKey(alphabet)) {
                    weight = alphabetWeights.get(alphabet) + weight;
                }
                alphabetWeights.put(alphabet, weight);
            }
        }

        // 리스트로 변환
        List<Map.Entry<Character, Integer>> sortedList = new ArrayList<>(alphabetWeights.entrySet());
        // value 기준 내림차순 정렬
        sortedList.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        int ans = 0;
        int digit = 9;
        for (Map.Entry<Character, Integer> entry : sortedList) {
            ans = ans + digit * entry.getValue();
            --digit;
        }
        System.out.println(ans);
    }
}
