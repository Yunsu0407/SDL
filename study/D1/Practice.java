package D1;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Practice {
    public static void main(String[] args) throws IOException {
        prnEqually();
    }

    public static void prnEqually() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String word;
        while((word = br.readLine()) != null){
            sb.append(word).append("\n");
        }

        System.out.println(sb);
    }
}
