package D240905_T2044_B1158;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;

// 요세푸스 = josephus

public class B1158 {
    public static void main(String[] args) throws IOException {
        solveJosephusProblem();
    }

    public static void solveJosephusProblem() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        br.close();
        final int HEADCOUNT = Integer.parseInt(st.nextToken());
        final int TARGET = Integer.parseInt(st.nextToken());
        String ans = josephusSolver(HEADCOUNT, TARGET);
        System.out.println(ans);
    }

    public static String josephusSolver(int N, int K) {
        final int headcount = N;
        final int target = K;
        LinkedList<Integer> status = new LinkedList<>();

        for(int i = 0; i < headcount; ++i){
            status.add(i + 1);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int index = 0;
        int left = headcount;
        while(!status.isEmpty()){
            index = (index + target - 1) % left;
            --left;
            int absent = status.remove(index);
            sb.append(absent);

            if(!status.isEmpty()){
                sb.append(", ");
            }
        }
        sb.append(">");

        return sb.toString();
    }
}
