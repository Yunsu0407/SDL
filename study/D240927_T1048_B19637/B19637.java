package study.D240927_T1048_B19637;

import java.io.*;
import java.util.*;

public class B19637 {
    public static void main(String[] args) throws IOException {
        classification();
    }

    public static void classification() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        final int GRADE = Integer.parseInt(st.nextToken());
        final int USER = Integer.parseInt(st.nextToken());
        // receive grade, user

        Sorter sorter = new Sorter();
        for (int i = 0; i < GRADE; ++i) {
            st = new StringTokenizer(br.readLine().trim());
            String grade = st.nextToken();
            int score = Integer.parseInt(st.nextToken());
            sorter.addGrade(grade, score);
        }   // receive grade and limit

        ArrayList<Integer> scores = new ArrayList<>();
        for (int i = 0; i < USER; ++i) {
            int score = Integer.parseInt(br.readLine().trim());
            scores.add(score);
        }   // receive score
        br.close();

        String answer = sorter.getGrades(scores);
        System.out.print(answer);
    }

    public static class Sorter {
        public ArrayList<Integer> limit;
        public ArrayList<String> grade;

        public Sorter() {
            limit = new ArrayList<>();
            grade = new ArrayList<>();
        }

        public void addGrade(String oneGrade, int oneScore) {
            if (limit.isEmpty()) {
                limit.add(oneScore);
                grade.add(oneGrade);
            } else {
                if (!(limit.get(limit.size() - 1) == oneScore)) {
                    limit.add(oneScore);
                    grade.add(oneGrade);
                }
            }
        }

        public String getGrades(ArrayList<Integer> scores) {
            StringBuilder sb = new StringBuilder();

            int currLimit = limit.remove(0);  // 점수 제한
            String currGrade = grade.remove(0);    // 점수에 따른 등급
            while (!scores.isEmpty()) {
                int currScore = scores.remove(0);   // 유저 점수
                if (!(currScore <= currLimit)) {
                    currLimit = limit.remove(0);
                    currGrade = grade.remove(0);
                }
                sb.append(currGrade).append("\n");
            }
            return sb.toString();
        }
    }
}
