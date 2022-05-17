package algorithms.search;

import java.util.Arrays;
import java.util.List;

public class BinarySearch {

    public static int binarySearch(List<Integer> list, int l, int r, int find) {
        if (r >= l) {
            int mid = l + (r - l) / 2;
            if (find == list.get(mid)) return mid;
            else if (find < list.get(mid)) return binarySearch(list, l, mid - 1, find);
            else return binarySearch(list, mid + 1, r, find);
        }
        return -1;
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(2, 3, 4, 10, 40);
        int n = arr.size();
        int x = 10;
        System.out.println(binarySearch(arr, 0, n - 1, x));
    }
}
