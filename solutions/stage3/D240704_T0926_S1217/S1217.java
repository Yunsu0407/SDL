package solutions.stage3.D240704_T0926_S1217;

import java.util.Scanner;

public class S1217 {
    public static void main(String[] args) {
        square();
    }

    public static void square() {
        Scanner oInDev = new Scanner(System.in);
        final int TESTCASE = 10;
        int[] answer = new int[TESTCASE];

        for (int i = 0; i < TESTCASE; ++i) {
            oInDev.nextInt();
            int bottom = oInDev.nextInt();
            int exponent = oInDev.nextInt();
            Value value = new Value(bottom, exponent);
            checkExponent(value);
            answer[i] = value.getValue();
        }
        oInDev.close();

        for (int i = 0; i < TESTCASE; ++i) {
            System.out.printf("#%d %d\n", i + 1, answer[i]);
        }
    }

    public static void checkExponent(Value value) {
        if (value.zeroCheck()) {
            value.zeroSituation();
        } else {
            squareRecursion(value);
        }
    }


    public static void squareRecursion(Value value) {
        if (value.isExponentPositive()) {
            value.multiValue();
            value.reduceExponent();
            squareRecursion(value);
        }
    }

    public static class Value {
        private int value;
        private int bottom;
        private int exponent;

        public Value(int bottom, int exponent) {
            this.value = 1;
            this.bottom = bottom;
            this.exponent = exponent;
        }

        public boolean zeroCheck() {
            return exponent == 0;
        }

        public void zeroSituation() {
            this.value = 1;
        }

        public boolean isExponentPositive() {
            return exponent > 0;
        }

        public void multiValue() {
            this.value = this.value * this.bottom;
        }

        public void reduceExponent() {
            --this.exponent;
        }

        public int getValue() {
            return this.value;
        }
    }
}
