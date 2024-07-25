package solutions.stage3.D240720_T0148_S1232;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1232 {
    public static void main(String[] args) throws IOException {
        calculator();
    }

    public static void calculator() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int TESTCASE = 1;
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < TESTCASE; ++i) {
            int quantity = Integer.parseInt(br.readLine().trim());
            String[] array = new String[quantity];

            StringTokenizer st;
            for (int j = 0; j < quantity; ++j) {
                st = new StringTokenizer(br.readLine().trim());
                st.nextToken();
                array[j] = st.nextToken();
            }

            int count = 1;
            double total = calculate(array, count, quantity + 1);
            answer.append(String.format("#%d %d\n", i + 1, Math.round(total)));
        }

        System.out.printf("%s", answer.toString());
    }

    public static boolean isOperator(String value) {
        return value.equals("+") || value.equals("-") || value.equals("/") || value.equals("*");
    }

    public static double calculate(String[] array, int count, int quantity) { // count는 1부터 들어온다.
        int stop = 0;
        double total = 0;
        if (count < quantity) {
            if (isOperator(array[count - 1])) {    // 연산자인 경우
                switch (array[count - 1]) {
                    case "+":
                        total = calculate(array, count * 2, quantity) + calculate(array, count * 2 + 1, quantity);
                        break;
                    case "-":
                        total = calculate(array, count * 2, quantity) - calculate(array, count * 2 + 1, quantity);
                        break;
                    case "*":
                        total = calculate(array, count * 2, quantity) * calculate(array, count * 2 + 1, quantity);
                        break;
                    case "/":
                        total = calculate(array, count * 2, quantity) / calculate(array, count * 2 + 1, quantity);
                        break;
                }
            } else {
                return Double.parseDouble(array[count - 1]);
            }
        }
        return total;
    }
}
