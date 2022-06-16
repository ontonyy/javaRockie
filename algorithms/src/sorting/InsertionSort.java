package sorting;

import java.util.Arrays;

public class InsertionSort {

    public static int[] insertionSort(int[] list) {
        int len = list.length;
        for (int i = 0; i < len; i++) {
            int num1 = list[i];
            for (int j = i - 1; j >= 0; j--) {
                int num2 = list[j];
                if (num1 < num2) {
                    list[j + 1] = num2;
                    list[j] = num1;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 5, 6, 7, 8, 1, 3, 11, 15};
        System.out.println(Arrays.toString(insertionSort(arr)));
    }
}
