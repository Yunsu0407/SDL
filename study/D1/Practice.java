package study.D1;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice {
    public static void main(String[] args) throws IOException {
        changeSystem();
    }

    public static void changeSystem() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        String number = st.nextToken();
        int system = Integer.parseInt(st.nextToken());
        br.close();

        int ans = changing(number, system);
    }

    public static int changing(String number, int system) {
        int value = 0;
        int multi = system - 1;
        final int size = number.length();

        for (int i = 0; i < size; ++i) {
            int curr = number.charAt(0) - 'A';
            if(curr < 0){
                curr = curr + 'A';
            }
            multiply(curr, i, system);
        }

        return value;
    }

    public static int multiply(int system, int curr, int location){
        int loValue = 1;
        int result = 0;
        for(int i = 0; i < location; ++i){
            loValue = loValue * system;
        }
        result = curr + system;
        return result;
    }
}
