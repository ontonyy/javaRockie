package hackerrank.repeatedStringA;

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
     * Complete the 'repeatedString' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. LONG_INTEGER n
     */

    static long repeatedString(String s, long n) {
        int strLength = s.length();
        long q = 0, r = 0;
        q = n / strLength;
        r = n % strLength;
        long partialStrLen = r;
        return q * getLetterCount(s, s.length()) + getLetterCount(s, partialStrLen);
    }

    public static long getLetterCount(String s, long strLength) {
        long count = 0;
        for (int i = 0; i < strLength; i++) {
            if (s.charAt(i) == 'a') count++;
        }
        return count;
    }

    public static void main(String[] args) {
        repeatedString("aba", 10);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        long n = Long.parseLong(bufferedReader.readLine().trim());

        long result = Result.repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
