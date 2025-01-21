package Y2025.M01.D21;

import java.util.*;
import java.io.*;

public class B30804 {
    public static void main(String[] args) throws IOException {
        checkFruit();
    }

    public static void checkFruit() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int quantity = Integer.parseInt(br.readLine().trim());

        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int front = 0, frontCount = 0, frontMemory = 0;
        int back = 0, backCount = 0, backMemory = 0;
        int max = 0;
        for (int i = 0; i < quantity; ++i) {
            int now = Integer.parseInt(st.nextToken());
            if (front == 0) {
                front = now;
                frontCount = 1;
            } else { // front != 0
                if (back == 0) {
                    if(now == front) {
                        ++frontCount;
                    } else {
                        back = now;
                        backCount = 1;
                    }
                } else { // front != 0, back != 0
                    if (now == front) { // swap
                        if (backMemory == 0) { // 처음 뒤바뀐 경우, 2 4 2
                            backMemory = frontCount; // 이전 값 저장

                            front = back;
                            frontCount = backCount;

                            back = now;
                            backCount = 1;
                        } else { // bm != 0
                            if (frontMemory == 0) { // 다시 바뀐 경우, 2 4 2 4
                                frontMemory = backMemory;
                                backMemory = frontCount;

                                front = back;
                                frontCount = 1;

                                back = now;
                                backCount = 1;
                            } else { // 2 4 2 4 2
                                int tempMemory = frontMemory;
                                frontMemory = backMemory;
                                backMemory = tempMemory + frontCount;

                                front = back;
                                frontCount = 1;

                                back = now;
                                backCount = 1;
                            }
                        }
                    } else { // now != front
                        if (now == back) {
                            ++backCount;
                        } else { // now != front, now != back, 2 4 2 4 2 5
                            int sum = frontCount + frontMemory + backCount + backMemory;
                            max = Math.max(max, sum);

                            front = back;
                            frontCount = backCount;

                            back = now;
                            backCount = 1;

                            frontMemory = backMemory = 0;
                        }
                    }
                }
            }
        }
        int sum = frontCount + frontMemory + backCount + backMemory;
        max = Math.max(max, sum);

        System.out.println(max);
    }
}
