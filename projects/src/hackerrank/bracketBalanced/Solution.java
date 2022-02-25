package bracketBalanced;

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
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isBalanced(String s) {
    // Write your code here
        char[] brackets = s.toCharArray();
        String first = "{}";
        String second = "[]";
        String third = "()";
        int quan = brackets.length / 2;
        if (brackets.length % 2 != 0){
            return "NO";
        }

        int countAll = 0;
        int countBet = 0;

        for (int i = 0; i < brackets.length; i++) {
            countBet = 0;
            for (int j = i + 1; j < brackets.length; j++) {
                String bracket = Character.toString(brackets[i]) + Character.toString(brackets[j]);
                if ((bracket.equals(first) || bracket.equals(second) || bracket.equals(third)) && countBet % 2 == 0 && countBet != 1 ) {
                    countAll++;
                    break;
                }
                countBet++;
            }
        }
        if (countAll == quan) return "YES";
        return "NO";

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = Result.isBalanced(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}