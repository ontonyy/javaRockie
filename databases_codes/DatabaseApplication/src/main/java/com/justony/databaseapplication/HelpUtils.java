package com.justony.databaseapplication;

public class HelpUtils {

    public static int countStringRows(String text) {
        String[] str = text.split("\n");
        return str.length;
    }

    public static int countStringColumns(String text) {
        String[] str = text.split("\n");
        int maxCount = 0;
        for (String s : str) {
            if (s.length() > maxCount) {
                maxCount = s.length();
            }
        }
        return maxCount;
    }

}
