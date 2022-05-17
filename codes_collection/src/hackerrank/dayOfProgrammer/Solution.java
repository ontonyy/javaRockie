package hackerrank.dayOfProgrammer;

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
     * Complete the 'dayOfProgrammer' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER year as parameter.
     */

    public static String dayOfProgrammer(int year) {
    // Write your code here
        int day = 256;
        int count = 0;

        List<Integer> months = Arrays.asList(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);
        if (year % 4 == 0) {
            if (year%100 == 0) {
                if(year%400 == 0 || year == 1700 || year == 1800 || year == 1900) {
                    months.set(1, months.get(1) + 1);
                }
            }
            else {
                months.set(1, months.get(1) + 1);
            }
        }
        if (year <= 1918) {
            day -= 15;
        }
        for (Integer month : months) {
            count++;
            if (day - month <= 0) {
                return day + "." + count + "." + year;
            } else {
                day -= month;
            }
        }
        return null;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.dayOfProgrammer(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}