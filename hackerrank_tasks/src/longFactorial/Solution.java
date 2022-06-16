package longFactorial;

import java.io.*;
import java.math.*;

import static java.util.stream.Collectors.joining;

class Result {

    /*
     * Complete the 'extraLongFactorials' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void extraLongFactorials(int n) {
        BigInteger b = new BigInteger(String.valueOf(n));
        System.out.print(fact(b, n));
    }

    static BigInteger fact(BigInteger n, int t){
        BigInteger result = new BigInteger(String.valueOf(1));
        for(int i = 1; i <= t; i++){
            result = result.multiply(new BigInteger(String.valueOf(i)));
        }
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        Result.extraLongFactorials(n);

        bufferedReader.close();
    }
}