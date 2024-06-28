package memorization;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MergeSort {
    public static void main(String[] args) throws IOException {
        getMax();
    }

    public static void getMax() throws IOException {    // 병합 정렬 만들어서 출력해볼까?
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());
        int[] answer = new int[testcase];

        for (int i = 0; i < testcase; ++i) {
            final int COUNT = 10;
            int[] numbers = new int[COUNT];
            StringTokenizer st = new StringTokenizer(br.readLine().trim());

            for (int j = 0; j < COUNT; ++j) {
                numbers[j] = Integer.parseInt(st.nextToken());
            }
            sort(numbers, 0, COUNT - 1);
            answer[i] = numbers[0];
        }

        for (int i = 0; i < testcase; ++i) {
            System.out.println("#" + (i + 1) + " " + answer[i]);
        }
    }

    // 배열을 정렬하는 함수
    public static void sort(int[] array, int left, int right) {
        if (left < right) {
            // 배열의 중간 지점을 계산
            int middle = (left + right) / 2;

            // 중간을 기준으로 배열을 두 부분으로 나누어 정렬
            sort(array, left, middle);
            sort(array, middle + 1, right);

            // 두 개의 정렬된 배열을 병합
            merge(array, left, middle, right);
        }
    }

    // 두개의 정렬된 배열을 병합하는 함수
    public static void merge(int[] array, int left, int middle, int right) {
        // 두 배열의 크기를 계산
        int n1 = middle - left + 1;
        int n2 = right - middle;

        // 임시 배열 생성
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        //원본 배열의 데이터를 임시 배열에 복사
        for (int i = 0; i < n1; ++i) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            rightArray[j] = array[middle + 1 + j];
        }

        // 병합 과정
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] >= rightArray[j]) {
                array[k] = leftArray[i];
                ++i;
            } else {
                array[k] = rightArray[j];
                ++j;
            }
            ++k;
        }

        // 남은 요소들을 복사
        while (i < n1) {
            array[k] = leftArray[i];
            ++i;
            ++k;
        }

        while (j < n2) {
            array[k] = rightArray[j];
            ++j;
            ++k;
        }
    }
}
