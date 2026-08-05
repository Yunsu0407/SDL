package Y2026.M08.D05;

import java.util.*;
import java.io.*;

public class S1928 {
    public static String input = "1\r\n" + //
            "TGlmZSBpdHNlbGYgaXMgYSBxdW90YXRpb24u";

    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader(input));

        int size = Integer.parseInt(br.readLine().trim());

        String[] ans = new String[size];
        for (int i = 0; i < size; ++i) {
            String encoded = br.readLine().trim();
            ans[i] = decodeProcess(encoded);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ans.length; ++i) {
            String form = String.format("#%d ", i + 1);
            sb.append(form).append(ans[i]).append("\n");
        }

        System.out.print(sb.toString());
    }

    public static String decodeProcess(String encoded) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < encoded.length(); ++i) {
            char c = encoded.charAt(i);
            int digit = decodeChar(c);
            String bi = String.format("%6s", Integer.toBinaryString(digit)).replace(' ', '0');
            sb.append(bi);
        }

        String decoded = decode(sb.toString());

        return decoded;
    }

    public static int decodeChar(char c) {
        int ret = 0;
        if (c >= 'A' && c <= 'Z') {
            ret = c - 'A';
        } else if (c >= 'a' && c <= 'z') {
            ret = c - 'a' + 26;
        } else if (c >= '0' && c <= '9') {
            ret = c - '0' + 52;
        } else if (c == '+') {
            ret = 62;
        } else {
            ret = 63;
        }

        return ret;
    }

    public static String decode(String s) {
        final int BUFFER = 24;
        final int BYTE = 8;

        StringBuilder sb = new StringBuilder();
        int numOfThreeByte = s.length() / BUFFER;
        int numOfByte = BUFFER / BYTE;

        for (int i = 0; i < numOfThreeByte; ++i) {
            int sIdxTB = BUFFER * i;
            int eIdxTB = sIdxTB + BUFFER;
            String threeByte = s.substring(sIdxTB, eIdxTB);

            for (int j = 0; j < numOfByte; ++j) {
                int sIdxB = BYTE * j;
                int eIdxB = sIdxTB + BYTE;
                String oneByte = threeByte.substring(sIdxB, eIdxB);
                char c = (char) Integer.parseInt(oneByte, 2);
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
