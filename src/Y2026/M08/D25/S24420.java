package Y2026.M08.D25;

import java.util.*;
import java.io.*;

public class S24420 {
    public static void main(String[] args) throws IOException {
        compareSet();
    }

    public static void compareSet() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int sizeA = Integer.parseInt(st.nextToken());
            int sizeB = Integer.parseInt(st.nextToken());

            Set<Integer> setA = new HashSet<>();
            st = new StringTokenizer(br.readLine().trim());
            for (int j = 0; j < sizeA; ++j) {
                int numA = Integer.parseInt(st.nextToken());
                setA.add(numA);
            }

            Set<Integer> setB = new HashSet<>();
            st = new StringTokenizer(br.readLine().trim());
            for (int j = 0; j < sizeB; ++j) {
                int numB = Integer.parseInt(st.nextToken());
                setB.add(numB);
            }

            boolean isAContainB = setA.containsAll(setB);
            boolean isBContainA = setB.containsAll(setA);
            char res;
            if (isAContainB && isBContainA) {
                res = '=';
            } else if (isAContainB && !isBContainA) {
                res = '>';
            } else if (!isAContainB && isBContainA) {
                res = '<';
            } else {
                res = '?';
            }

            sb.append(res).append("\n");
        }

        System.out.print(sb.toString());
    }
}