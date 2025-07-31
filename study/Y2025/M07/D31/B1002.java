package study.Y2025.M07.D31;

import java.util.*;
import java.io.*;

public class B1002 {
    public static void main(String[] args) throws IOException {
        turret();
    }

    public static class Person {
        int[] data;

        public Person(int[] data) {
            this.data = data.clone();
        }
    }

    public static int A = 0, B = 1, X = 0, Y = 1, R = 2;

    public static void turret() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            Person[] person = new Person[2];

            for (int j = 0; j < person.length; ++j) {
                int[] data = new int[3];

                for (int k = 0; k < data.length; ++k) {
                    data[k] = Integer.parseInt(st.nextToken());
                }
                person[j] = new Person(data);
            }

            int dx = person[A].data[X] - person[B].data[X];
            int dy = person[A].data[Y] - person[B].data[Y];
            int distSquare = Math.abs(dx * dx + dy * dy);

            int rMax = Math.max(person[A].data[R], person[B].data[R]);
            int rMin = Math.min(person[A].data[R], person[B].data[R]);
            int rDiff = rMax - rMin;
            int rdSquare = Math.abs(rDiff * rDiff);

            int count;

            if (distSquare == 0) {
                if (rDiff == 0) {
                    count = -1;
                } else {
                    count = 0;
                }
            } else {
                if (distSquare < rdSquare) {
                    count = 0;
                } else if (distSquare == rdSquare) {
                    count = 1;
                } else {
                    int rSum = rMax + rMin;
                    int rsSquare = rSum * rSum;
                    if (distSquare == rsSquare) {
                        count = 1;
                    } else if (distSquare > rsSquare) {
                        count = 0;
                    } else {
                        count = 2;
                    }
                }
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb.toString());
    }
}
