package Y2026.M03.D13;

import java.io.*;

public class B2741 {
    public static void main(String[] args) throws IOException {
        printN();
    }

    public static void printN() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; ++i) {
            sb.append(i + 1).append("\n");
        }
        
        System.out.println(sb.toString());
    }
}
