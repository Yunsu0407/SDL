package memorization;

public class Vacuum {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int n = 50;
        long result = function(n);
        long end = System.currentTimeMillis();
        double run_time = (end - start) / 1000.0;
        System.out.printf("Result: %d, run-time: %.3fms\n", result, run_time);
    }

    // f(n) = f(n-1) + f(n-2), f(1) = f(2) = 1
    public static long function(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return function(n - 1) + function(n - 2);
        }
    }
}
