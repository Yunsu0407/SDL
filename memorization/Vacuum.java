package memorization;

import java.io.*;
import java.util.*;
import java.nio.file.*;

public class Vacuum {
    public static void main(String[] args) {
        String filePath = "example.txt";

        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath)); // 파일의 모든 줄 읽기
            for (String line : lines) {
                System.out.println(line); // 한 줄씩 출력
            }
        } catch (IOException e) {
            e.printStackTrace(); // 예외 발생 시 에러 출력
        }
    }
}
