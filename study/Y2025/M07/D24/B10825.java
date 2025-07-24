package study.Y2025.M07.D24;

import java.util.*;
import java.io.*;

public class B10825 {
    public static void main(String[] args) throws IOException {
        specialArrange();
    }

    public static final int K = 0, E = 1, M = 2;

    public static class Student {
        String name;
        int[] score;

        public Student(String name, int[] score) {
            this.name = name;
            this.score = score.clone();
        }
    }

    public static void specialArrange() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine().trim());
        Student[] students = new Student[size];

        for (int i = 0; i < size; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            String name = st.nextToken();
            int[] score = new int[3];

            for (int j = 0; j < score.length; ++j) {
                score[j] = Integer.parseInt(st.nextToken());
            }

            students[i] = new Student(name, score);
        }

        String ans = arrangeStudent(students);
        System.out.print(ans);
    }

    public static String arrangeStudent(Student[] students) {
        Arrays.sort(students, (front, back) -> {
            if (front.score[K] != back.score[K]) {
                return back.score[K] - front.score[K];
            }
            if (front.score[E] != back.score[E]) {
                return front.score[E] - back.score[E];
            }
            if (front.score[M] != back.score[M]) {
                return back.score[M] - front.score[M];
            }
            return front.name.compareTo(back.name);
        });

        StringBuilder sb = new StringBuilder();
        for (Student student : students) {
            sb.append(student.name).append("\n");
        }

        return sb.toString();
    }
}
