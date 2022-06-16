package biggerIsGreater;

import java.io.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;

class Result {

    /*
     * Complete the 'biggerIsGreater' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING w as parameter.
     */

    public static String biggerIsGreater(String s) {
    // Write your code here
        char[] chars = s.toCharArray();
        int i = chars.length - 1;

        while (i > 0 && chars[i - 1] >= chars[i]) {
            i -= 1;
        }
        if (i <= 0) return "no answer";

        int j = chars.length - 1;

        while (chars[j] <= chars[i - 1]) {
            j -= 1;
        }

        chars[i - 1] = chars[j];
        chars[j] = chars[i - 1];

        // bruh...
        return "";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                String w = bufferedReader.readLine();

                String result = Result.biggerIsGreater(w);

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