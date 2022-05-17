package exam_tasks;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Attempts {
    public static void main(String[] args) throws ParseException {
        encode("  ");
    }

    public static Map<String, Integer> sumScoresFromText(List<String> scores) {
        Map<String, Integer> scoresMap = new LinkedHashMap<>();
        for (String score : scores) {
            int add = Integer.parseInt(score.split(":")[0]);
            String[] s = score.replace(add + ":", "").split(",");
            for (String s1 : s) {
                if (add != 0) {
                    scoresMap.put(s1, scoresMap.getOrDefault(s1, 0) + add);
                }
            }
        }
        System.out.println(scoresMap);
        return scoresMap;
    }

    public static int combineNumbers(int[] numbers) {
        int len = numbers.length;
        if (len < 2) {
            return 0;
        }
        String largest = "";
        int max = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i != j) {
                    int num1 = numbers[i];
                    int num2 = numbers[j];
                    String sum = num1 + "" + num2;
                    int tempMax = sumOfCharArray(sum.toCharArray());
                    char[] nums = String.valueOf(tempMax).toCharArray();
                    while (nums.length != 1) {
                        num1 = Integer.parseInt(String.valueOf(nums[0]));
                        num2 = Integer.parseInt(String.valueOf(nums[1]));
                        tempMax = sumOfCharArray(nums);
                        nums = String.valueOf(tempMax).toCharArray();
                    }
                    if (tempMax > max && num1 < num2) {
                        max = tempMax;
                        largest = num1 + "" + num2;
                    }
                }
            }
        }
        System.out.println(largest);
        return Integer.parseInt(largest);
    }

    public static int sumOfCharArray(char[] arr) {
        int tempMax = 0;
        for (char num : arr) {
            tempMax += Integer.parseInt(String.valueOf(num));
        }
        return tempMax;
    }
    /* Write a  method that finds correct difference between two timestamps. Timestamps are given in format HH:MM where
     * HH is two-digit hour marker and MM is two-digit
     * minutes marker. Result must be also in format HH:MM. Difference means basically "time2" minus "time1".
            * timeDiff("10:00", "10:00") => "00:00"
            * timeDiff("10:00", "11:01") => "01:01"
            * timeDiff("10:00", "09:01") => "23:01"
            * timeDiff("10:00", "08:59") => "22:59"
            * timeDiff("10:01", "10:00") => "23:59"
            *
            * @param time1 time as HH:MM
     * @param time2 time as HH:MM
     * @return time difference as HH:MM
     */
    public static String timeDiff(String time1, String time2) throws ParseException {
        SimpleDateFormat f = new SimpleDateFormat("HH:mm");
        Date d1 = f.parse(time1);
        Date d2 = f.parse(time2);
        long diff = d2.getTime() - d1.getTime();
        int h = (int) diff / 3600000;
        int m = (int) (diff % 3600000) / 60000;
        String main = "";
        if (h <= 0) {
            h = 23 + h;
        }
        String mainH = "";
        if (h < 10) {
            mainH += "0";
        }
        mainH += String.valueOf(h);

        String mainM = "";
        if (m < 0) {
            m = 60 + m;
        }
        if (m < 10) {
            mainM += "0";
        }
        mainM += String.valueOf(m);

        main += mainH + ":" + mainM;
        System.out.println(main);
        return main;
    }
    /* Given a string, encode the string using Run-length encoding.
     * RLE is a form of data compression, where runs (consecutive data elements)
     * are replaced by just one data value and count.
     * <p>
     * encode("TalTech") => "Taltech"
            * encode("TTU") => "2TU"
            * encode("WWWABBBA") => "3WA3BA"
            * encode("  ") => "2 "
            *
            * @param data string to encode
     * @return encoded string
     */
    public static String encode(String data) {
        String main = "";
        for (int i = 0; i < data.length(); i++) {
            int count = 1;
            char c = data.charAt(i);
            boolean canAdd = true;
            if (main.contains(String.valueOf(c))) {
                if (String.valueOf(main.charAt(main.indexOf(String.valueOf(c)) - 1)).matches("\\d+")) {
                    canAdd = false;
                }
            }
            if (canAdd) {
                for (int j = i + 1; j < data.length(); j++) {
                    if (c == data.charAt(j)) count++;
                    else break;
                }
                if (count != 1) {
                    main += count + "" + c;
                } else {
                    main += c;
                }
            }
        }
        System.out.println(main);
        return main;
    }


}
