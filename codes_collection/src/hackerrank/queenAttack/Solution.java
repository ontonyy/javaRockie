package hackerrank.queenAttack;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'queensAttack' function below.
     *
     * The function is expected to  return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     *  3. INTEGER r_q
     *  4. INTEGER c_q
     *  5. 2D_INTEGER_ARRAY obstacles
     */

    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
    // Write your code here
        int rRObstacle = -1;
        int cRObstacle = -1;
        int rBRObstacle = -1;
        int cBRObstacle = -1;
        int rBObstacle = -1;
        int cBObstacle = -1;
        int rBLObstacle = -1;
        int cBLObstacle = -1;
        int rLObstacle = -1;
        int cLObstacle = -1;
        int rTLObstacle = -1;
        int cTLObstacle = -1;
        int rTObstacle = -1;
        int cTObstacle = -1;
        int rTRObstacle = -1;
        int cTRObstacle = -1;

        //Total squares attacked by the queen
        int reachableSquares = 0;

        //Finds the closest object in each direction
        for(int a0 = 0; a0 < k; a0++){
            int rObstacle = obstacles.get(a0).get(0);
            int cObstacle = obstacles.get(a0).get(1);

            //Right
            if((cObstacle < cRObstacle || rRObstacle == -1) && cObstacle > c_q && rObstacle == r_q)
            {
                rRObstacle = rObstacle;
                cRObstacle = cObstacle;
            }

            //Bottom Right
            if(r_q - rObstacle == cObstacle - c_q && cObstacle > c_q && rObstacle < r_q
                    && ((rObstacle > rBRObstacle && cObstacle < cBRObstacle) || rBRObstacle == -1))
            {
                rBRObstacle = rObstacle;
                cBRObstacle = cObstacle;
            }

            //Bottom
            if((rObstacle > rBObstacle || rBObstacle == -1) && rObstacle < r_q && cObstacle == c_q)
            {
                rBObstacle = rObstacle;
                cBObstacle = cObstacle;
            }

            //Bottom Left
            if(r_q - rObstacle == c_q - cObstacle && cObstacle < c_q && rObstacle < r_q
                    && ((rObstacle > rBLObstacle && cObstacle > cBLObstacle) || rBLObstacle == -1))
            {
                rBLObstacle = rObstacle;
                cBLObstacle = cObstacle;
            }

            //Left
            if((cObstacle > cLObstacle || rLObstacle == -1) && cObstacle < c_q && rObstacle == r_q)
            {
                rLObstacle = rObstacle;
                cLObstacle = cObstacle;
            }

            //Top Left
            if(c_q - cObstacle == rObstacle - r_q && cObstacle < c_q && rObstacle > r_q
                    && ((rObstacle < rTLObstacle && cObstacle > cTLObstacle) || rTLObstacle == -1))
            {
                rTLObstacle = rObstacle;
                cTLObstacle = cObstacle;
            }

            //Top
            if((rObstacle < rTObstacle || rTObstacle == -1) && rObstacle > r_q && cObstacle == c_q)
            {
                rTObstacle = rObstacle;
                cTObstacle = cObstacle;
            }

            //Top Right
            if(rObstacle - r_q == cObstacle - c_q && cObstacle > c_q
                    && rObstacle > r_q && ((rObstacle < rTRObstacle && cObstacle < cTRObstacle) || rTRObstacle == -1))
            {
                rTRObstacle = rObstacle;
                cTRObstacle = cObstacle;
            }

        }

        //Calculates the distance to the closest obstacle in each direction and adds it to reachableSquares
        //R B L T
        reachableSquares += (cRObstacle != -1) ? (cRObstacle - c_q -1) : n - c_q;
        reachableSquares += (rBObstacle != -1) ? (r_q - rBObstacle - 1) : r_q - 1;
        reachableSquares += (cLObstacle != -1) ? (c_q - cLObstacle -1) : c_q - 1;
        reachableSquares += (rTObstacle != -1) ? (rTObstacle - r_q - 1) : n - r_q;

        //BR BL TL TR
        reachableSquares += (cBRObstacle != -1) ? (cBRObstacle - c_q -1) : Math.min(n - c_q, r_q - 1);
        reachableSquares += (rBLObstacle != -1) ? (c_q - cBLObstacle - 1) : Math.min(c_q - 1, r_q - 1);
        reachableSquares += (cTLObstacle != -1) ? (c_q - cTLObstacle -1) : Math.min(c_q - 1, n - r_q);
        reachableSquares += (rTRObstacle != -1) ? (cTRObstacle - c_q - 1) : Math.min(n - c_q, n - r_q);
        return reachableSquares;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int r_q = Integer.parseInt(secondMultipleInput[0]);

        int c_q = Integer.parseInt(secondMultipleInput[1]);

        List<List<Integer>> obstacles = new ArrayList<>();

        IntStream.range(0, k).forEach(i -> {
            try {
                obstacles.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.queensAttack(n, k, r_q, c_q, obstacles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}