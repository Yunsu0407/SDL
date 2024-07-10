package solutions.stage3.D240710_T0923_S1966;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1966 {
    public static void main(String[] args) throws IOException {
        sorting();
    }

    public static void sorting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int testcase = Integer.parseInt(br.readLine().trim());
        String[] answer = new String[testcase];

        for (int i = 0; i < testcase; ++i) {
            final int length = Integer.parseInt(br.readLine().trim());
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int[] array = new int[length];

            for (int j = 0; j < length; ++j) {
                array[j] = Integer.parseInt(st.nextToken());
            }
            mergeSort(0, length - 1, array);

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < length; ++j) {
                sb.append(array[j]);
                sb.append(" ");
            }
            answer[i] = sb.toString();
        }

        for (int i = 0; i < testcase; ++i) {
            System.out.printf("#%d %s\n", i + 1, answer[i]);
        }
    }

    // 배열을 정렬하는 함수
    public static void mergeSort(int left, int right, int[] array) {
        if (left < right) {
            // 배열의 중간 지점을 계산
            int middle = (left + right) / 2;

            // 중간을 기준으로 배열을 두 부분으로 나누어 정렬
            mergeSort(left, middle, array);
            mergeSort(middle + 1, right, array);

            // 두 개의 정렬된 배열을 병합
            merge(left, middle, right, array);
        }
    }

    // 두 개의 정렬된 배열을 병합하는 함수
    public static void merge(int left, int middle, int right, int[] array) {
        // 두 배열의 크기를 계산
        int n1 = middle - left + 1;
        int n2 = right - middle;

        // 임시 배열 생성
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // 원본 배열의 데이터를 임시 배열에 복사
        for (int i = 0; i < n1; ++i) {
            leftArray[i] = array[i + left];
        }
        for (int j = 0; j < n2; ++j) {
            rightArray[j] = array[j + middle + 1];
        }

        // 병합 과정
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }

        // 남은 요소들을 복사
        while (i < n1) {
            array[k++] = leftArray[i++];
        }
        while (j < n2) {
            array[k++] = rightArray[j++];
        }
    }
}
