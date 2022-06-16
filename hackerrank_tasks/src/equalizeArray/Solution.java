package equalizeArray;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'equalizeArray' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int equalizeArray(List<Integer> arr) {
    // Write your code here
        int num = arr.get(0);
        int maxOccur = Collections.frequency(arr, arr.get(0));

        for (Integer integer : arr) {
            int count = Collections.frequency(arr, integer);
            if (count > maxOccur) {
                maxOccur = count;
                num = integer;
            }
        }
        int finalNum = num;
        System.out.println(5/4);
        return arr.size() - arr.stream().filter(i -> i == finalNum).collect(toList()).size();
    }

    public static void main(String[] args) {
        List<Integer> ints = new LinkedList<>();
        ints.add(3);
        ints.add(3);
        ints.add(2);
        ints.add(1);
        ints.add(3);
        System.out.println(equalizeArray(ints));
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

        int result = Result.equalizeArray(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}