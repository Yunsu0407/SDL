package stage3.D240802_T2230_S2805;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class S2805 {
    public static void main(String[] args) throws IOException {
        getPrice();
    }

    public static void getPrice() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; ++i) {
            final int size = Integer.parseInt(br.readLine().trim());
            Farm farm = new Farm(size);
            for (int j = 0; j < size; ++j) {
                String priceData = br.readLine().trim();
                farm.addPrice(j, priceData);
            }
            int price = farm.getPrice();
            sb.append(String.format("#%d %d\n", i + 1, price));
        }

        System.out.println(sb.toString());
    }

    public static class Farm {
        private final int[][] price;
        private final int size;

        public Farm(int size) {
            this.size = size;
            this.price = new int[size][size];
        }

        public void addPrice(int row, String data) {
            for (int col = 0; col < this.size; ++col) {
                this.price[row][col] = data.charAt(col) - '0';
            }
        }

        public int getPrice() {
            int total = 0;
            int startingRow = size / 2;
            int repeat = startingRow + 1;

            for (int i = 0; i < repeat; ++i) {
                int start = i;
                int end = size - i;
                if (i == 0) {
                    for (int col = start; col < end; ++col) {
                        total = total + price[startingRow][col];
                    }
                } else {
                    int upRow = startingRow + i;
                    int downRow = startingRow - i;
                    if (start == end) {
                        total = total + price[upRow][start] + price[downRow][start];
                    } else {
                        for (int col = start; col < end; ++col) {
                            total = total + price[upRow][col] + price[downRow][col];
                        }
                    }
                }
            }

            return total;
        }
    }
}
