package hackerrank.jumpingOnClouds;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c, int k) {
        int energy = 100;
        int cloud = 0;
        int n = c.length;
        do
        {
            energy--; //You performed a jump

            cloud = (cloud + k) % n;

            if(c[cloud] == 1)
            {
                energy -= 2;
            }
        }
        while(cloud != 0);
        return energy;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        System.out.println(jumpingOnClouds(new int[]{0, 0, 1, 0, 0, 1, 1, 0}, 2));
    }
}