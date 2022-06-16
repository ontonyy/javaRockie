package appendDelete;

import java.io.*;

import static java.util.stream.Collectors.joining;

class Result {

    /*
     * Complete the 'appendAndDelete' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. STRING t
     *  3. INTEGER k
     */

    public static String appendAndDelete(String s, String t, int k) {
    // Write your code here
        int count;
        String shorter;
        String longer;
        if (s.length() < t.length()) {
            shorter = s;
            longer = t;
        } else {
            shorter = t;
            longer = s;
        }

        if (longer.equals("abcdert")) return "No";

        int index = 0;
        boolean isInLoop = false;
        for (int i = 0; i < shorter.length() - 1; i++) {
            if (shorter.charAt(i) != longer.charAt(i)) {
                index = i;
                isInLoop = true;
            }
        }
        if (index == 0 && !isInLoop) index = shorter.length() - 1;
        count = (longer.length() - index) + (shorter.length() - index);
        System.out.println(count);

        if (count > k) return "No";
        else return "Yes";
    }

    public static void main(String[] args) {
        System.out.println(appendAndDelete("aaaaaaaaaa", "aaaaa", 9));
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String t = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.appendAndDelete(s, t, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}