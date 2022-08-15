package generics;

import generics.animals.Cat;
import generics.animals.Dog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MethodsTest {
    public static <T extends Comparable<T>> int countGreater(T[] array, T elem) {
        int count = 0;
        for (T t : array) {
            if (t.compareTo(elem) > 0) {
                ++count;
            }
        }
        return count;
    }

    public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
        T max = x;
        if (y.compareTo(max) > 0) {
            max = y;
        }

        if (z.compareTo(max) > 0) {
            max = z;
        }

        return max;
    }

    public static <T extends Number> double sum(List<? extends Number> list) {
        double total = 0;
        for (Number number : list) {
            total += number.doubleValue();
        }
        return total;
    }

    public static void printList(List<?> list) {
        for (Object o : list) {
            System.out.println("Elem: " + o);
        }
    }

    public static <E> void addClassInstance(List<E> list, Class<E> cls) throws Exception {
        list.add(cls.newInstance());
    }

    public static <T> int countItems(List<T> list) {
        int count = 0;
        for (T t : list) {
            count++;
        }
        return count;
    }

    /*
    Bubble sort generics method.
     */
    public static <T extends Comparable<T>> List<T> sortList(List<T> list) {
        int len = list.size();
        List<T> retList = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            for (int j = 1; j < len; j++) {
                T item = list.get(j - 1);
                T item2 = list.get(j);
                if (item.compareTo(item2) > 0) {
                    list.set(j - 1, item2);
                    list.set(j, item);
                }
            }
        }
        return list;
    }

    public static <T extends Comparable<T>> T findMax(List<T> list, int begin, int end) {
        T max = list.get(begin);
        for (int i = begin + 1; i < end; i++) {
            T item = list.get(i);
            if (max.compareTo(item) < 0) {
                max = item;
            }
        }
        return max;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Maximum method: ");
        System.out.printf("Max of %d, %d and %d is %d\n", 3, 4, 5, maximum(3, 4, 5));
        System.out.printf("Max of %.1f, %.1f and %.1f is %.1f\n", 4.689, 2.314, 5.213, maximum(4.689, 2.314, 5.213));
        System.out.printf("Max of %s, %s and %s is %s\n\n", "pear", "apple", "watermelon", maximum("pear", "apple", "watermelon"));

        // Animal test also, because they implement Comparable
        System.out.println("Count greater:");
        System.out.printf("More stronger animal is %s\n", maximum(new Cat("Barsik"), new Dog("Sharrik"), new Cat("Petja")));
        System.out.println(countGreater(new String[]{"vasja", "pet", "move", "run"} , "move"));

        System.out.println("\nSum of list: ");
        System.out.println(sum(List.of(1, 4, 6, 10)));

        System.out.println("\nPrint list:");
        printList(List.of(1, 2));
        printList(List.of("Cat", "Medved"));

        List<String> list = new LinkedList<>(List.of("Name", "Family"));
        addClassInstance(list, String.class);
        System.out.println("\nAdd class new instance:\n" + list);

        System.out.println("\nCount items:");
        List<Integer> intList = List.of(1, 2, 3);
        System.out.println(intList + " have length: " + countItems(intList));

        System.out.println("Sort items:");
        List<String> strings = new LinkedList<>(List.of("sort", "generics", "new", "h", "GUCCIMUCCI"));
        List<Integer> integers = new LinkedList<>(List.of(12, 1, 5, 8, 4));
        System.out.println("Initial list: " + strings);
        System.out.println("Sorted: " + sortList(strings));
        System.out.println("Initial list: " + integers);
        System.out.println("Sorted: " + sortList(integers));

        System.out.println("Find max: ");
        List<String> strings1 = new LinkedList<>(List.of("Maka", "baka", "on", "Phone"));
        List<Integer> integers1 = new LinkedList<>(List.of(10, 20, 5, 18));
        System.out.println(findMax(strings1, 0, strings1.size()));
        System.out.println(findMax(integers1, 3, integers1.size()));
    }
}
