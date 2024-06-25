package Solutions.Stage3.D240624_T1012_S1208;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1208 {
    public static void main(String[] args) throws IOException {
        flatten();
    }

    public static void flatten() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int WIDTH = 100;
        final int TESTCASE = 10;
        int[] answer = new int[TESTCASE];
        int[] boxes = new int[WIDTH];

        for (int i = 0; i < TESTCASE; ++i) {
            int dumpChance = Integer.parseInt(br.readLine().trim());
            StringTokenizer st = new StringTokenizer(br.readLine().trim());

            for (int j = 0; j < WIDTH; ++j) {
                boxes[j] = Integer.parseInt(st.nextToken());
            }   // 박스 높이 설정

            int heightDiff = 0;
            while (dumpChance > 0) { // 회수가 소진되거나, 평탄화가 완료되면 종료
                heightDiff = getHeightDiff(boxes);
                if (heightDiff < 2) {
                    break;
                }
                --dumpChance;
            }

            answer[i] = heightDiff;
        }

        for (int i = 0; i < TESTCASE; ++i) {
            System.out.println("#" + (i + 1) + " " + answer[i]);
        }
    }

    public static int getHeightDiff(int[] boxes) {
        Element element = new Element();

        element.setElement(boxes);
        element.flatten(boxes);
        element.setElement(boxes);

        return element.getHeightDiff(boxes);
    }

    public static class Element {
        private int maxIndex;
        private int minIndex;

        public void setElement(int[] boxes) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < boxes.length; ++i) {
                if (boxes[i] > max) {
                    max = boxes[i];
                    maxIndex = i;
                }
                if (boxes[i] < min) {
                    min = boxes[i];
                    minIndex = i;
                }
            }
        }

        public void flatten(int[] boxes) {
            if (boxes[maxIndex] - boxes[minIndex] > 2) {
                --boxes[maxIndex];
                ++boxes[minIndex];
            }
        }

        public int getHeightDiff(int[] boxes) {
            return boxes[maxIndex] - boxes[minIndex];
        }
    }
}
