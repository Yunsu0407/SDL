package Y2026.M06.D03;

public class P120956 {
    public static void main(String[] args) {
        String[] bab = { "aya", "yee", "u", "maa", "wyeoo" };
        checkBabbling(bab);
    }

    public static void checkBabbling(String[] babs) {
        int count = 0;
        String[] prons = { "aya", "ye", "woo", "ma" };

        for (String bab : babs) {
            for (String pron : prons) {
                while (true) {
                    if (bab.contains(pron)) {
                        bab = bab.replace(pron, " ");
                    } else {
                        break;
                    }
                }
            }

            boolean isCountable = true;
            for (int i = 0; i < bab.length(); ++i) {
                if (bab.charAt(i) != ' ') {
                    isCountable = false;
                    break;
                }
            }

            if (isCountable) {
                count = count + 1;
            }
        }

        System.out.println(count);
    }
}
