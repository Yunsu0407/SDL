package solutions.stage3.D240711_T0932_S1230;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class S1230 {
    public static void main(String[] args) throws IOException {
        handlingCryptogram();
    }

    public static void handlingCryptogram() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int TESTCASE = 10;
        String[] answer = new String[TESTCASE];

        for (int i = 0; i < TESTCASE; ++i) {
            final int numOfOrgCryp = Integer.parseInt(br.readLine().trim());    // get number of origin cryptogram
            ArrayList<Integer> cryptogram = new ArrayList<>();

            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            for (int j = 0; j < numOfOrgCryp; ++j) {  // add cryptograms to arraylist
                int orgCryp = Integer.parseInt(st.nextToken());
                cryptogram.add(orgCryp);
            }

            int numOfOrder = Integer.parseInt(br.readLine().trim());    // get number of orders
            st = new StringTokenizer(br.readLine().trim()); // get sentence of orders
            while (numOfOrder > 0) {
                String word = st.nextToken();
                boolean insert = word.equals("I");
                boolean delete = word.equals("D");
                boolean addLast = word.equals("A");

                if (insert || delete || addLast) {
                    int location;
                    int numOfActions;
                    int newCryp;
                    if (insert) {
                        location = Integer.parseInt(st.nextToken());
                        numOfActions = Integer.parseInt(st.nextToken());
                        for (int j = 0; j < numOfActions; ++j) {
                            newCryp = Integer.parseInt(st.nextToken());
                            cryptogram.add(location + j, newCryp);
                        }
                    } else if (delete) {
                        location = Integer.parseInt(st.nextToken());
                        numOfActions = Integer.parseInt(st.nextToken());
                        for (int j = 0; j < numOfActions; ++j) {
                            cryptogram.remove(location);
                        }
                    } else {    // addLast
                        numOfActions = Integer.parseInt(st.nextToken());
                        for (int j = 0; j < numOfActions; ++j) {
                            newCryp = Integer.parseInt(st.nextToken());
                            cryptogram.add(newCryp);
                        }
                    }
                    --numOfOrder;
                }
            }

            StringBuilder sb = new StringBuilder();
            final int limit = 10;
            for (int j = 0; j < limit; ++j) {
                sb.append(cryptogram.get(j));
                sb.append(" ");
            }
            answer[i] = sb.toString();
        }
        br.close();

        for (int i = 0; i < TESTCASE; ++i) {
            System.out.printf("#%d %s\n", i + 1, answer[i]);
        }
    }
}
