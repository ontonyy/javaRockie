package textEncryption;

import java.io.*;
import java.util.*;

import static java.util.stream.Collectors.joining;

class Result {

    /*
     * Complete the 'encryption' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String encryption(String s) {
    // Write your code here
        s = s.replaceAll(" ", "");
        double L = Math.sqrt(s.length());
        int R = (int) Math.floor(L);
        int C = (int) Math.ceil(L);
        List<String> rows = new LinkedList<>();

        if (R * C < s.length()) R++;

        for (int i = 0; i < R; i++) {
            int end = C * (i + 1);
            if (end < s.length()) rows.add(s.substring(i * C, end));
            else rows.add(s.substring(i * C));
        }
        String main = "";
        for (int i = 0; i < C; i++) {
            String r = "";
            for (String row : rows) {
                if (i < row.length()) {
                    r += row.charAt(i);
                } else break;
            }
            r += " ";
            main += r;
        }
        return main.substring(0, main.length() - 1);

    }

    public static void main(String[] args) {
        System.out.println(encryption("mama ja na bahilax"));
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}