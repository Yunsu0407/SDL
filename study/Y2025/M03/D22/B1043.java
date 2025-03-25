package study.Y2025.M03.D22;

import java.util.*;
import java.io.*;

/*
사람의 수 N이 주어진다.
그리고 그 이야기의 진실을 아는 사람이 주어진다.
각 파티에 오는 사람들은 번호가 주어진다.
지민이는 모든 파티에 참가해야 한다.
뻥칠 수 있는 파티의 최대 개수를 구하여라.

입력:
 N M
 (사람의 수 N과 파티의 수 M)
 Known(K) Person1 Person2 ... PersonK
 Participant1(X) Attendee1 Attendee2 ... AttendeeX
 Participant2(X) Attendee1 Attendee2 ... AttendeeX
 ...
 ParticipantM(X) Attendee1 Attendee2 ... AttendeeX

N과 M은 50 이하의 자연수
선각자 0이상 50이하
파티 참석자 50 이하의 자연수
 */

public class B1043 {
    public static void main(String[] args) throws IOException {
        dodgeTrue();
    }

    public static String input1 = "4 3\n" +
            "0\n" +
            "2 1 2\n" +
            "1 3\n" +
            "3 2 3 4"; // ans = 3

    public static String input2 = "4 1\n" +
            "1 1\n" +
            "4 1 2 3 4"; // ans = 0

    public static String input3 = "4 1\n" +
            "0\n" +
            "4 1 2 3 4"; // ans = 1

    public static String input4 = "4 5\n" +
            "1 1\n" +
            "1 1\n" +
            "1 2\n" +
            "1 3\n" +
            "1 4\n" +
            "2 4 1"; // ans = 2

    public static String input5 = "10 9\n" +
            "4 1 2 3 4\n" +
            "2 1 5\n" +
            "2 2 6\n" +
            "1 7\n" +
            "1 8\n" +
            "2 7 8\n" +
            "1 9\n" +
            "1 10\n" +
            "2 3 10\n" +
            "1 4"; // ans = 4

    public static String input6 = "8 5\n" +
            "3 1 2 7\n" +
            "2 3 4\n" +
            "1 5\n" +
            "2 5 6\n" +
            "2 6 8\n" +
            "1 8"; // ans = 5

    // ans = 3, 0, 1, 2, 4, 5
    public static void dodgeTrue() throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader(input4));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int numOfPeople = Integer.parseInt(st.nextToken());
        int numOfParty = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine().trim());
        int numOfPioneer = Integer.parseInt(st.nextToken());
        Set<Integer> pioneers = new HashSet<>();
        for (int i = 0; i < numOfPioneer; ++i) {
            pioneers.add(Integer.parseInt(st.nextToken()));
        }

        Set<Integer>[] party = new Set[numOfParty];
        for (int i = 0; i < numOfParty; ++i) {
            party[i] = new HashSet<>();

            st = new StringTokenizer(br.readLine().trim());
            int numOfAttendee = Integer.parseInt(st.nextToken());
            for (int j = 0; j < numOfAttendee; ++j) {
                party[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        int disable ;
        Set<Integer> morePioneer;
        while (true) {
            disable = 0;
            morePioneer = new HashSet<>();

            for (Set<Integer> currParty : party) {
                for (int curr : pioneers) {
                    if(currParty.contains(curr)){
                        morePioneer.addAll(currParty);
                        ++disable;
                        break;
                    }
                }
            }

            if(morePioneer.isEmpty()){
                break;
            } else {
                pioneers.addAll(morePioneer);
            }
        }

        System.out.println(disable);
    }
}
