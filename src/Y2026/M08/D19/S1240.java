package Y2026.M08.D19;

import java.util.*;
import java.io.*;

public class S1240 {
    public static void main(String[] args) throws IOException {
        simpleBiCode();
    }

    public static void simpleBiCode() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        Map<String, Integer> codeMap = makeMap();

        for (int i = 0; i < testcase; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int row = Integer.parseInt(st.nextToken());
            st.nextToken(); // col

            String encodedLine = null;
            int edx = 0;
            int idx = 0;
            while (idx < row) {
                String oneLine = br.readLine().trim();

                if (oneLine.contains("1")) {
                    edx = oneLine.lastIndexOf("1");
                    encodedLine = oneLine;
                    break;
                }
                ++idx;
            }

            for (int j = idx + 1; j < row; ++j) {
                br.readLine();
            }

            int sdx = edx - 55;

            int[] decoded = new int[8];
            for (int j = 0; j < decoded.length; ++j) {
                int fdx = j * 7 + sdx;
                int rdx = fdx + 7;
                String encoded = encodedLine.substring(fdx, rdx);
                decoded[j] = codeMap.get(encoded);
            }

            int oddSum = 0;
            int evenSum = 0;
            for (int j = 0; j < decoded.length; ++j) {
                if (j % 2 == 0) {
                    oddSum = oddSum + decoded[j];
                } else {
                    evenSum = evenSum + decoded[j];
                }
            }
            int sum = oddSum * 3 + evenSum;

            int result = 0;
            if (sum % 10 == 0) {
                result = oddSum + evenSum;
            }

            String line = String.format("#%d %d\n", (i + 1), result);
            sb.append(line);
        }

        System.out.print(sb.toString());
    }

    public static Map<String, Integer> makeMap() {
        Map<String, Integer> codeMap = new HashMap<>();
        String[] codeStrings = {
                "0001101",
                "0011001",
                "0010011",
                "0111101",
                "0100011",
                "0110001",
                "0101111",
                "0111011",
                "0110111",
                "0001011"
        };

        for (int i = 0; i < codeStrings.length; ++i) {
            codeMap.put(codeStrings[i], i);
        }

        return codeMap;
    }
}
