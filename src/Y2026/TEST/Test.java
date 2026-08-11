package Y2026.TEST;

public class Test {
    public static void main(String[] args) {
        double x = 16.0;
        double y = Math.sqrt(x);
        boolean isSame = (int) y == y;

        System.out.println(isSame);
    }
}
