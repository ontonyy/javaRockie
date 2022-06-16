package search;

import java.util.Arrays;
import java.util.List;

public class LinearSearch {
    public static Object linearSearch(List<Object> list, Object find) {
        for (Object o : list) {
            if (o == find) {
                return list.indexOf(o);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(linearSearch(Arrays.asList(2, 4, 6, 7, 9), 7));
    }
}
