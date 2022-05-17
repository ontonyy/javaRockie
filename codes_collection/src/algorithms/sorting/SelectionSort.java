package algorithms.sorting;

import java.util.Arrays;

public class SelectionSort {

    public static int[] selectionSort(int[] list) {
        int len = list.length;
        for (int i = 0; i < len - 1; i++) {
            int index = i;
            for (int j = i; j < len; j++) {
                if (list[j] < list[index]) {
                    index = j;
                }
            }
            int num1 = list[i];
            int num2 = list[index];
            list[i] = num2;
            list[index] = num1;
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {3,60,35,2,45,320,5};
        System.out.println(Arrays.toString(selectionSort(arr)));
    }
}
