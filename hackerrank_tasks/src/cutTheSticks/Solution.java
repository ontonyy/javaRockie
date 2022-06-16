package cutTheSticks;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'cutTheSticks' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> cutTheSticks(List<Integer> arr) {
        List<Integer> heap = new LinkedList<>();
        heap.add(arr.size());
        while (arr.size() > 0) {
            int stick = arr.stream().min(Integer::compareTo).get();

            arr = arr.stream().filter(p -> p > stick).map(p -> p - stick).collect(toList());
            if (arr.size() != 0) {
                heap.add(arr.size());
            }
        }
        return heap;
    }

    public static void main(String[] args) {
        List<Integer> ints = new LinkedList<>();
        ints.add(1);
        ints.add(13);
        ints.add(8);
        ints.add(3);
        ints.add(14);
        ints.add(9);
        ints.add(4);
        ints.add(4);
        System.out.println(cutTheSticks(ints));
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.cutTheSticks(arr);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}