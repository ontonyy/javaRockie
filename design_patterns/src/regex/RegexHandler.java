package regex;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexHandler {
    private static final String EMAIL_REGEX = "(\\S+)@(\\w+).(\\w+)";

    public static boolean matches(String compiler, String input) {
        return Pattern.matches(compiler, input);
    }

    public static List<String> getGroups(String compiler, String input) {
        Pattern pattern = Pattern.compile(compiler);
        Matcher matcher = pattern.matcher(input);
        List<String> groups = new LinkedList<>();
        while (matcher.find()) {
            groups.add(matcher.group());
        }
        return groups;
    }

    public static int[] findWordIndex(String word, String input) {
        String wordRe = "(?i)" + word + "+";
        Pattern pattern = Pattern.compile(wordRe);
        Matcher matcher = pattern.matcher(input);
        try {
            if (matcher.find()) {
                int[] index = new int[]{matcher.start(), matcher.end()};
                System.out.printf("In text index of input(%s) - %s : %s\n", word, matcher.start(), matcher.end());
                return index;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.printf("Cannot find word: %s", word);
        }
        return null;
    }

    public static String replaceWord(String word, String newWord, String input) {
        String wordRe = "(?i)" + word + "+";
        try {
            Pattern pattern = Pattern.compile(wordRe);
            Matcher matcher = pattern.matcher(input);
            input = matcher.replaceAll(newWord);
            System.out.println("New text: " + input);
            return input;
        } catch (Exception ex) {
            System.out.println(word + " is not find in text");
        }
        return null;
    }

    public static List<String> getEmails(String input) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(input);
        List<String> groups = new LinkedList<>();
        while (matcher.find()) {
            System.out.println(matcher.group(0));
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
            groups.add(matcher.group());
        }
        return groups;
    }

    public static boolean checkCorrectEmail(String email) {
        return Pattern.matches(EMAIL_REGEX, email);
    }

}
