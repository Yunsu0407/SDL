package Solution.D240623_T0826_S1204;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1204 {
  public static void main(String[] args) throws IOException {
    findMode();
  }

  public static void findMode() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    final int RANGE = 101;
    final int NOS = 5; // NOS = number of student
    int testcase;
    int[] counts = new int[RANGE];
    int[] answer;
    int score;
    int mode;

    testcase = Integer.parseInt(br.readLine().trim());  // 테스트케이스 입력
    answer = new int[testcase]; // 정답배열 생성

    for (int i = 0; i < testcase; ++i) {  // 테스트케이스만큼 반복
      br.readLine().trim();
      mode = Integer.MIN_VALUE;
      st = new StringTokenizer(br.readLine().trim());

      for (int j = 0; j < NOS; ++j) { // 입력되는 학생의 수 만큼 반복
        score = Integer.parseInt(st.nextToken());
        System.out.println("현재 숫자: " + score);
        ++counts[score];  // 0부터 100까지 증가
      }

      int curr;
      for (int j = 0; j < RANGE; ++j) {
        curr = counts[RANGE - (j+1)];
        if (mode < curr) {
          mode = curr;
          System.out.println("현재 최빈수: " + mode);
        }
      }

    for (int i = 0; i < testcase; ++i) {
      System.out.println("#" + (i + 1) + " " + answer[i]);
    }
  }
}