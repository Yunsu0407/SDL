package memorization;


public class Vacuum {
    public static void main(String[] args){
        final int SIZE = 10;
        int[] array = new int[SIZE];
        for(int i = 0; i < SIZE; ++i){
            array[i] = (int)Math.round(Math.random() * 100);
        }

        mergeSort(0, SIZE - 1, array);
        prnArray(array);
    }

    public static void mergeSort(int left, int right, int[] array){
        if(left < right){
            int middle = (left + right) / 2;

            mergeSort(left, middle, array);
            mergeSort(middle + 1, right, array);

            merge(left, middle, right, array);
        }
    }

    public static void merge(int left, int middle, int right, int[] array){
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for(int i = 0; i < n1; ++i){
            leftArray[i] = array[i + left];
        }
        for(int j = 0; j < n2; ++j){
            rightArray[j] = array[j + middle + 1];
        }

        int i = 0, j = 0, k = left;
        while(i < n1 && j < n2){
            if(leftArray[i] <= rightArray[j]){  // 오름차순
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }

        // 나머지 저장
        while (i < n1) {
            array[k++] = leftArray[i++];
        }
        while(j < n2){
            array[k++] = rightArray[j++];
        }
    }

    public static void prnArray(int[] array){
        System.out.print("Sorted Array: ");
        for(int curr : array){
            System.out.printf("%d ", curr);
        }
    }
}
