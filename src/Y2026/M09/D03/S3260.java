package Y2026.M09.D03;

import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class S3260 {
    public static void main(String[] args) throws IOException {
        addNums();
    }

    public static void addNums() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            BigInteger num1 = new BigInteger(st.nextToken());
            BigInteger num2 = new BigInteger(st.nextToken());
            BigInteger sum = num1.add(num2);

            String line = String.format("#%d %s\n", (i + 1), sum.toString());
            sb.append(line);
        }

        System.out.print(sb.toString());
    }
}
