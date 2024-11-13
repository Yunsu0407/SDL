package D240802_T1700_B14891;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;


public class B14891 {
    public static void main(String[] args) throws IOException {
        getScore();
    }

    public static void getScore() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int COUNT = 4;
        Cogwheel[] cogwheels = new Cogwheel[COUNT];

        // 4개의 톱니바퀴 정보를 입력한다.
        for (int i = 0; i < COUNT; ++i) {
            String magnetics = br.readLine().trim();
            cogwheels[i] = new Cogwheel(magnetics);
        }
        final int spin = Integer.parseInt(br.readLine().trim()); // 회전 횟수 수령
        for (int i = 0; i < spin; ++i) { // 회전 횟수만큼 회전
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            final int target = Integer.parseInt(st.nextToken());
            final int direction = Integer.parseInt(st.nextToken());
            int index = target - 1;
            cogwheels[index].judgeRotating(cogwheels, index, direction);
        }

        int score = getFinalScore(cogwheels);
        System.out.print(score);
    }

    public static int getFinalScore(Cogwheel[] cogwheels) {
        int score = 0;
        for (int i = 0; i < cogwheels.length; ++i) {
            if (cogwheels[i].getTop()) {
                score = score + (int) Math.pow(2, i);
            }
        }
        return score;
    }

    public static class Cogwheel {
        private ArrayList<Boolean> state;

        public Cogwheel(String magnetics) {
            this.state = new ArrayList<>();
            for (int i = 0; i < magnetics.length(); ++i) {
                this.state.add(magnetics.charAt(i) == '1');
            }
        }

        public boolean getRight() {
            return this.state.get(2);
        }

        public boolean getLeft() {
            return this.state.get(6);
        }

        public boolean getTop() {
            return this.state.getFirst();
        }

        public void judgeRotating(Cogwheel[] cogwheels, int index, int direction) {
            final int COUNT = 4;
            final int KIND = 2;
            boolean[][] rotation = new boolean[KIND][COUNT];
            boolean isClockwise;
            if (direction == 1) {
                isClockwise = true;

            } else {
                isClockwise = false;
            }
            final int GEAR = 0;
            final int CW = 1;
            rotation[GEAR][index] = true;
            rotation[CW][index] = isClockwise;
            switch (index) {
                case 0:
                    while (index < 3 && cogwheels[index].getRight() != cogwheels[index + 1].getLeft()) {
                        isClockwise = !isClockwise;
                        rotation[GEAR][index + 1] = true;
                        rotation[CW][index + 1] = isClockwise;
                        ++index;
                    }
                    break;
                case 1, 2:
                    while (index > 0 && cogwheels[index].getLeft() != cogwheels[index - 1].getRight()) {
                        isClockwise = !isClockwise;
                        rotation[GEAR][index - 1] = true;
                        rotation[CW][index - 1] = isClockwise;
                        --index;
                    }
                    while (index < 3 && cogwheels[index].getRight() != cogwheels[index + 1].getLeft()) {
                        isClockwise = !isClockwise;
                        rotation[GEAR][index + 1] = true;
                        rotation[CW][index + 1] = isClockwise;
                        ++index;
                    }
                    break;
                case 3:
                    while (index > 0 && cogwheels[index].getLeft() != cogwheels[index - 1].getRight()) {
                        isClockwise = !isClockwise;
                        rotation[GEAR][index - 1] = true;
                        rotation[CW][index - 1] = isClockwise;
                        --index;
                    }
                    break;
            }
            for (int i = 0; i < COUNT; ++i) {
                if (rotation[GEAR][i]) {
                    cogwheels[i].rotating(cogwheels[i], rotation[CW][i]);
                }
            }
        }

        public void rotating(Cogwheel cogwheel, boolean isClock) {
            if (isClock) {
                boolean temp = cogwheel.state.removeLast();
                cogwheel.state.addFirst(temp);
            } else {
                boolean temp = cogwheel.state.removeFirst();
                cogwheel.state.add(temp);
            }
        }
    }
}
