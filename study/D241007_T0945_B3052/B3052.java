package study.D241007_T0945_B3052;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B3052 {
    public static void main(String[] args) throws IOException {
        getSpare();
    }

    public static void getSpare() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        final int SIZE = 10;
        final int DIVISOR = 42;

        for(int i = 0; i < SIZE; ++i){
            int curr = Integer.parseInt(br.readLine().trim());
            curr = curr % DIVISOR;
            if(list.isEmpty()){
                list.add(curr);
            } else {
                if(!list.contains(curr)){
                    list.add(curr);
                }
            }
        }
        br.close();

        System.out.println(list.size());
    }
}
