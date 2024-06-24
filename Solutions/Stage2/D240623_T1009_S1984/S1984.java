package Solutions.Stage2.D240623_T1009_S1984;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1984{
    public static void main(String[] args) throws IOException{
        calculateMidAvg();
    }
    public static void calculateMidAvg() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        final int ARRAY_SIZE = 10;
        int testcase = Integer.parseInt(br.readLine().trim());  // 테스트케이스 입력
        int[] answer = new int[testcase];

        for(int i = 0; i < testcase; ++i){
            int sum = 0;
            int maxValue = Integer.MIN_VALUE;
            int minValue = Integer.MAX_VALUE;
            st = new StringTokenizer(br.readLine().trim()); // 다음 문장 입력

            for(int j = 0; j < ARRAY_SIZE; ++j){
                int currValue = Integer.parseInt(st.nextToken());
                if(currValue > maxValue){
                    maxValue = currValue;
                }
                if(currValue < minValue){
                    minValue = currValue;
                }
                sum = sum + currValue;
            }
            double midAvg = (sum - (minValue + maxValue)) / (double)(ARRAY_SIZE - 2);
            answer[i] = (int)Math.round(midAvg);
        }

        for(int i = 0; i < testcase; ++i){
            System.out.println("#" + (i + 1) + " " + answer[i]);
        }
    }
}
