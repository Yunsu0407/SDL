package study.Y2025.M04.D06;

import java.util.*;
import java.io.*;

public class B1764 {
    public static void main(String[] args) throws IOException {
        findCommon();
    }

    public static void findCommon() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int sizeOfUnheard = Integer.parseInt(st.nextToken());
        int sizeOfUnseen = Integer.parseInt(st.nextToken());
        String[] unheard = new String[sizeOfUnheard];
        String[] unseen = new String[sizeOfUnseen];

        for (int i = 0; i < sizeOfUnheard; ++i) {
            String name = br.readLine().trim();
            unheard[i] = name;
        }

        for (int i = 0; i < sizeOfUnseen; ++i) {
            String name = br.readLine().trim();
            unseen[i] = name;
        }

        Arrays.sort(unheard);
        Arrays.sort(unseen);

        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < sizeOfUnheard; ++i) {
            String target = unheard[i];
            if(binarySearch(unseen, target, 0, sizeOfUnseen - 1)){
                ++count;
                sb.append(target).append("\n");
            }
        }

        System.out.println(count);
        System.out.println(sb.toString());
    }

    public static boolean binarySearch(String[] compares, String target, int first, int last) {
        boolean ret = false;
        int mid = (first + last) / 2;
        String compare = compares[mid];
        int result = target.compareTo(compare);
        if (last - first >= 0) {
            if (last == first) {
                ret = target.equals(compare);
            } else {
                if (result < 0) {
                    ret = binarySearch(compares, target, first, mid);
                } else if (result > 0) {
                    ret = binarySearch(compares, target, mid + 1, last);
                } else {
                    ret = true;
                }
            }
        }

        return ret;
    }
}





