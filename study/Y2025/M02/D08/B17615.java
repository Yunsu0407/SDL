package study.Y2025.M02.D08;

import java.util.*;
import java.io.*;

public class B17615 {
    public static void main(String[] args) throws IOException {
        collectingBall();
    }

    public static String input1 = "9\n" +
            "RBBBRBRRR"; // 011101000
    public static String input2 = "8\n" +
            "BBRBBBBR";

    public static final int RED = 0, BLUE = 1;
    public static final char R = 'R', B = 'B';

    public static void collectingBall() throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader(input2));
        int length = Integer.parseInt(br.readLine().trim());
        StringBuilder balls = new StringBuilder(br.readLine().trim());

        // 빨강 왼쪽, 빨강 오른쪽, 파랑 왼쪽, 파랑 오른쪽
        int min = Integer.MAX_VALUE;

        min = Math.min(min, checkBalls(balls.toString(), RED));
        if(min != 0) {
            min = Math.min(min, checkBalls(balls.reverse().toString(), RED));
            min = Math.min(min, checkBalls(balls.toString(), BLUE));
            min = Math.min(min, checkBalls(balls.reverse().toString(), BLUE));
        }

        System.out.println(min);
    }

    public static int checkBalls(String balls, int inputColor) {
        char baseColor, reverseColor;
        if (inputColor == RED) {
            baseColor = R;
            reverseColor = B;
        } else {
            baseColor = B;
            reverseColor = R;
        }

        /*
        전달받은 색이 기준 색 R
        이전 색 = 0번 공; R
        if(기준 색 == 현재 색) { R, R
            if(이전 색 == 현재 색) { R R
                continue;
            } else { 이전 색 != 현재 색 R B
                ++이동횟수;
            }
        } else { 기준 색 != 현재 색 R, B
            이전 색 == !기준 색;
        }
         */

        int movement = 0;
        char prevColor = balls.charAt(0);
        for (int i = 1; i < balls.length(); ++i) {
            char currColor = balls.charAt(i);

            if (baseColor == currColor) {
                if (prevColor == currColor) {
                    continue;
                } else {
                    ++movement;
                }
            } else {
                prevColor = reverseColor;
            }
        }

        return movement;
    }
}












