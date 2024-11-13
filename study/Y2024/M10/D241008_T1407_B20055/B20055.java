package study.Y2024.M10.D241008_T1407_B20055;

import java.io.*;
import java.util.*;

public class B20055 {
    static ArrayList<Belt> conveyorBelt = new ArrayList<>();    // 컨베이어 벨트
    static ArrayList<Robot> robots = new ArrayList<>();         // 컨베이어 위에 올라가있는 로봇 목록
    static int length;      // 컨베이어벨트 길이 / 2
    static int broken = 0;  // 고장난 벨트의 수
    static int limitation;  // 고장난 벨트의 한계치
    static int cycle = 0;   // 반복 횟수

    public static void main(String[] args) throws IOException {
        receiving();
        do {
            rotateBelt();
            moveRobot();
            addRobot();
            ++cycle;
        } while (broken < limitation);

        System.out.println(cycle);
    }

    static void receiving() throws IOException {    // 필요 정보 수령
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        length = Integer.parseInt(st.nextToken());
        limitation = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < length * 2; ++i) {
            int lifespan = Integer.parseInt(st.nextToken());
            conveyorBelt.add(new Belt(lifespan));
        }
        br.close();
    }

    static void rotateBelt() {  // 컨베이어벨트 회전
        int lastIndex = conveyorBelt.size() - 1; // 2N번째 벨트
        Belt apartBelt = conveyorBelt.remove(lastIndex);
        int insertLocation = 0;  // 벨트를 삽입할 위치
        conveyorBelt.add(insertLocation, apartBelt);    // 컨베이어벨트 회전 완료
        for (Robot robot : robots) {    // 컨베이어벨트 회전을 로봇에도 반영
            robot.conveyorLocation = (robot.conveyorLocation + 1) % length;
        }

        boolean robotExist = !robots.isEmpty();
        if (robotExist) {   // 컨베이어벨트 위에 로봇이 있다면
            Robot passedRobot = null;   // 내리는 위치에 도달한 로봇
            for (Robot robot : robots) {
                int conveyorLocation = robot.conveyorLocation;  // 로봇이 위치하고 있는 컨베이어벨트의 위치
                if (conveyorLocation == length - 1) {   // 위치가 내리는 위치라면
                    Belt currBelt = conveyorBelt.get(conveyorLocation);
                    currBelt.removeRobot(); // 내리는 위치 이전에 벨트에서 로봇 제거
                    passedRobot = robot;    // 반복문이 끝난 후 제거하기 위해 로봇 저장
                }
            }
            if (passedRobot != null) {    // 내리는 위치에 도달한 로봇이 있으면
                robots.remove(passedRobot); // 로봇 제거
            }
        }
    }

    static void moveRobot() {
        boolean robotExist = !robots.isEmpty();
        if (robotExist) {   // 컨베이어벨트 위에 로봇이 있다면
            Robot passedRobot = null;   // 내리는 위치에 도달한 로봇
            for (Robot robot : robots) {
                Belt currBelt = conveyorBelt.get(robot.conveyorLocation);   // 이동 전 벨트
                int nextConveyorLocation = robot.conveyorLocation + 1;  // 로봇이 이동할 위치
                Belt nextBelt = conveyorBelt.get(nextConveyorLocation); // 이동할 벨트
                if (nextBelt.isEmpty() && nextBelt.isAlive()) { // 이동할 벨트가 비어있고, 살아있다면
                    currBelt.removeRobot(); // 이동 전 벨트에서 로봇 제거
                    robot.updateLocation(nextConveyorLocation); // 로봇 이동
                    nextBelt.receiveRobot(robot);   // 이동할 벨트에서 로봇 수령
                }
                if (nextConveyorLocation == length - 1) {
                    nextBelt.removeRobot();
                    passedRobot = robot;
                }
            }
            if (passedRobot != null) {    // 내리는 위치에 도달한 로봇이 있으면
                robots.remove(passedRobot); // 로봇 제거
            }
        }
    }

    static void addRobot() {
        int location = 0;
        Belt currBelt = conveyorBelt.get(location);
        if (currBelt.isAlive()) {
            Robot robot = new Robot(location);
            robots.add(new Robot(location));
            currBelt.receiveRobot(robot);
        }
    }

    static class Belt {
        int lifespan;
        Robot robot;

        Belt(int lifespan) {
            this.lifespan = lifespan;
        }

        void removeRobot() {
            robot = null;
        }

        boolean isEmpty() {
            return robot == null;
        }

        boolean isAlive() {
            return lifespan > 0;
        }

        void receiveRobot(Robot robot) {
            --lifespan;
            if (lifespan == 0) {
                ++broken;
            }
            this.robot = robot;
        }
    }

    static class Robot {
        int conveyorLocation;

        Robot(int conveyorLocation) {
            this.conveyorLocation = conveyorLocation;
        }

        void updateLocation(int nextConveyorLocation) {
            conveyorLocation = nextConveyorLocation;
        }
    }
}
