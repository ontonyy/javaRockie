package algorithms.sorting;

import java.util.Arrays;

public class BubbleSort {

    public static int[] bubbleSort(int[] list) {
        int size = list.length;
        for (int i = 0; i < size; i++) {
            for (int j = 1; j < size - i; j++) {
                int num1 = list[j - 1];
                int num2 = list[j];
                if (num1 > num2) {
                    list[j - 1] = num2;
                    list[j] = num1;
                }
            }
        }
        return list;

    }

    public static void main(String[] args) {
        int[] arr = {3,60,35,2,45,320,5};
        bubbleSort(arr);
    }
}
