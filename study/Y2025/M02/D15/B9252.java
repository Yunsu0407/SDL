package Y2025.M02.D15;

import java.util.*;
import java.io.*;

public class B9252 {
    public static void main(String[] args) throws IOException {
        getLcs();
    }

    public static String input1 = "ACAYKP\n" +
            "CAPCAK";

    public static String input2 = "DABCD\nABCD";

    public static String lcs = "";

    public static void getLcs() throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader(input2));

        String str1 = br.readLine().trim();
        String str2 = br.readLine().trim();

        checkString(str1, str2);
        checkString(str2, str1);

        System.out.println(lcs.length());
        if (!lcs.isEmpty()) {
            System.out.println(lcs);
        }
    }

    public static void checkString(String str1, String str2) {
        for (int i = 0; i < str1.length(); ++i) {
            StringBuilder sb = new StringBuilder();
            int count = 0;
            for (int j = i; j < str1.length(); ++j) {
                char curr = str1.charAt(j);
                for (int k = count; k < str2.length(); ++k) {
                    char comp = str2.charAt(k);
                    if (curr == comp) {
                        sb.append(curr);
                        count = count + k;
                        break;
                    }
                }
                String str3 = sb.toString();
                if (str3.length() > lcs.length()) {
                    lcs = str3;
                }
            }
        }
    }
}
