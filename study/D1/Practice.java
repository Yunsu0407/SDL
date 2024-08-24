package D1;

import java.util.ArrayList;

public class Practice {
    public static void main(String[] args) {
        // 2차원 ArrayList 선언
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

        // 첫 번째 행 추가 및 데이터 추가
        matrix.add(new ArrayList<Integer>());
        matrix.get(0).add(1);
        matrix.get(0).add(2);

        // 두 번째 행 추가 및 데이터 추가
        matrix.add(new ArrayList<Integer>());
        matrix.get(1).add(3);
        matrix.get(1).add(4);

        // 데이터 출력
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                System.out.print(matrix.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
