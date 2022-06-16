package climbingLeaderboard;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'climbingLeaderboard' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ranked
     *  2. INTEGER_ARRAY player
     */

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        // Write your code here
        Map<Integer, Integer> map = new TreeMap<>();
        List<Integer> indexes = new LinkedList<>();
        int i = 1;
        for (Integer integer : ranked) {
            if (!map.containsKey(integer)) {
                map.put(integer, i);
                i++;
            }
        }
        for (Integer integer : player) {
            boolean indexAdd = true;
            for (Integer num : map.keySet()) {
                if (indexAdd) {
                    if (integer >= num) {
                        indexes.add(map.get(num));
                        indexAdd = false;
                    }
                    else if (ranked.indexOf(num) == ranked.size() - 1) {
                        indexes.add(map.size() + 1);
                        indexAdd = false;
                    }
                }
            }
        }
        return indexes;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.climbingLeaderboard(ranked, player);

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