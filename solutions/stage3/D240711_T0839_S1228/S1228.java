package solutions.stage3.D240711_T0839_S1228;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class S1228 {
    public static void main(String[] args) throws IOException {
        reviseCryptogram();
    }

    public static void reviseCryptogram() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int TESTCASE = 1;
        String[] answer = new String[TESTCASE];

        for (int i = 0; i < TESTCASE; ++i) {
            final int count = Integer.parseInt(br.readLine().trim());
            ArrayList<Integer> cryptogram = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine().trim());

            for (int j = 0; j < count; ++j) {
                int value = Integer.parseInt(st.nextToken());
                cryptogram.add(value);
            }

            int totalOrder = Integer.parseInt(br.readLine().trim());
            st = new StringTokenizer(br.readLine().trim());
            while (totalOrder > 0) {
                String token = st.nextToken();
                if (token.equals("I")) {
                    --totalOrder;
                    final int insertLocation;
                    final int countOfNewCryps;
                    insertLocation = Integer.parseInt(st.nextToken());
                    countOfNewCryps = Integer.parseInt(st.nextToken());
                    for (int j = 0; j < countOfNewCryps; ++j) {
                        int newCryp = Integer.parseInt(st.nextToken());
                        cryptogram.add(insertLocation + j, newCryp);
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            int limit = 10;
            for (int j = 0; j < limit; ++j) {
                int removed = cryptogram.get(j);
                sb.append(removed);
                sb.append(" ");
            }
            answer[i] = sb.toString();
        }

        for (int i = 0; i < TESTCASE; ++i) {
            System.out.printf("#%d %s\n", i + 1, answer[i]);
        }
    }
}
