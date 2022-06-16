package magisSquare;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'formingMagicSquare' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY s as parameter.
     */

    public static int formingMagicSquare(List<List<Integer>> s) {
    // Write your code here
        ArrayList<int[][]> options = new ArrayList<>();
        int[][] tmp = new int[][]{{8, 1, 6}, {3, 5, 7}, {4, 9, 2}};
        options.add(tmp);
        tmp = new int[][]{{6, 1, 8}, {7, 5, 3}, {2, 9, 4}};
        options.add(tmp);
        tmp = new int[][]{{4, 9, 2}, {3, 5, 7}, {8, 1, 6}};
        options.add(tmp);
        tmp = new int[][]{{8, 3, 4}, {1, 5, 9}, {6, 7, 2}};
        options.add(tmp);
        tmp = new int[][]{{4, 3, 8}, {9, 5, 1}, {2, 7, 6}};
        options.add(tmp);
        tmp = new int[][]{{6, 7, 2}, {1, 5, 9}, {8, 3, 4}};
        options.add(tmp);
        tmp = new int[][]{{2, 7, 6}, {9, 5, 1}, {4, 3, 8}};
        options.add(tmp);

        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int[][] option : options) {
            sum = 0;
            for (int i = 0; i <3; i++) {
                for (int j = 0; j < 3; j++) {
                    sum += Math.abs(option[i][j] - s.get(i).get(j));
                }
            }
            min = Math.min(sum, Math.abs(sum));
        }
        return min;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<List<Integer>> s = new ArrayList<>();

        IntStream.range(0, 3).forEach(i -> {
            try {
                s.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.formingMagicSquare(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}