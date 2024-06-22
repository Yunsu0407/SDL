package Solution.S1204;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1204 {
  public static void main(String[] args) throws IOException {

  }

  public void findMode() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    final int RANGE = 101;
    final int NOS = 1000; // NOS = number of student
    int testcase;
    int[] counts = new int[RANGE];
    int[] answer;
    int score;
    int mode;

    testcase = Integer.parseInt(br.readLine().trim());
    answer = new int[testcase];

    for(int i = 0; i < testcase; ++i){
      st = new StringTokenizer(br.readLine().trim());
      
      for(int j = 0; j < NOS; ++j){
        score = Integer.parseInt(st.nextToken());
        ++counts[score];
      }

    }
  }
}