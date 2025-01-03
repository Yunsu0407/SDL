package study.Y2024.M07.D240720_T0411_B17413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
"a"-"z", "0"-"9", " ", "<", ">"
<>사이는 태그이므로 뒤집지 말아야함
<open>text2<close>
=> <open>2txet<close>

공백은 고정

 */

public class B17413 {
    public static void main(String[] args) throws IOException {
        reverseWord();
    }

    public static void reverseWord() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sentence = br.readLine().trim();
        StringBuilder answer = new StringBuilder();

        StringBuilder save = new StringBuilder();
        boolean isBracket = false;
        for (int i = 0; i < sentence.length(); ++i) {
            char curr = sentence.charAt(i);
            if (checkException(curr)) {   // 공백이나 괄호인 경우
                if (curr == ' ') {    // 공백인 경우
                    if (save.length() == 0) {    // 처음으로 공백이 나온 경우
                        answer.append(" ");
                    } else {    // 저장된 문자들이 있는 경우
                        if (isBracket) {
                            answer.append(String.format("%s ", save.toString()));
                        } else {
                            String reversed = save.reverse().toString();   // 저장된 문자들의 역순
                            answer.append(String.format("%s ", reversed));  // 정답에 공백과 함께 추가
                        }
                        save = new StringBuilder();
                    }
                } else {    // 괄호인 경우
                    if (curr == '<') {    // 개괄호인 경우
                        isBracket = true;
                        if (save.length() == 0) { // 개괄호가 처음에 나온 경우
                            answer.append("<"); // 개괄호만 추가
                        } else {    // 처음이 아닌 겨우
                            String reversed = save.reverse().toString();   // 저장된 문자들의 역순
                            answer.append(String.format("%s<", reversed));  // 정답에 공백과 함께 추가
                            save = new StringBuilder();
                        }
                    } else {    // 폐괄호인 경우
                        isBracket = false;
                        answer.append(save.toString()).append(">");
                        save = new StringBuilder();
                    }
                }
            } else {    // a-z, 0-9
                save.append(curr);
                if(i == sentence.length() - 1){
                    String reversed = save.reverse().toString();   // 저장된 문자들의 역순
                    answer.append(reversed);  // 정답에 공백과 함께 추가
                }
            }
        }
        // your <  hi  me > wow <  bye  you >
        System.out.printf("%s", answer.toString());
    }

    public static boolean checkException(char letter) {
        return letter == ' ' || letter == '<' || letter == '>';
    }
}
