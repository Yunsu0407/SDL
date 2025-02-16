package Y2025.M02.D16;

import java.util.*;
import java.io.*;

public class B1475 {
    public static void main(String[] args) throws IOException {
        roomNumber();
    }

    public static String input1 = "9999";
    public static String input2 = "12635";
    public static String input3 = "888888";

    public static void roomNumber() throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader(input3));

        HashMap<Integer, Integer> set = new HashMap<>();
        String number = br.readLine().trim();

        for (int i = 0; i < 9; ++i) {
            if (i == 6) {
                set.put(i, 2);
            } else {
                set.put(i, 1);
            }
        }
        int setCount = 1;

        for (int i = 0; i < number.length(); ++i) {
            int currDigit = number.charAt(i) - '0';

            if (currDigit == 6 || currDigit == 9) {
                currDigit = 6;
                int rest = set.get(currDigit);
                if (rest > 0) {
                    set.put(currDigit, rest - 1);
                } else { // rest = 0;
                    Set<Integer> mySet = set.keySet();
                    for (int currKey : mySet) {
                        int currRest = set.get(currKey);
                        set.replace(currKey, currRest + 1);
                    }
                    ++setCount;
                }
            } else {
                int rest = set.get(currDigit);
                if (rest > 0) {
                    set.replace(currDigit, rest - 1);
                } else {
                    Set<Integer> mySet = set.keySet();
                    for (int currKey : mySet) {
                        int currRest = set.get(currKey);
                        if (currKey == currDigit) {
                            set.replace(currKey, 0);
                        } else if (currKey == 6) {
                            set.replace(currKey, currRest + 2);
                        } else {
                            set.replace(currKey, currRest + 1);
                        }
                    }
                    ++setCount;
                }
            }
        }

        System.out.println(setCount);
    }
}
