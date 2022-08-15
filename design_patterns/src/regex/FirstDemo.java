package regex;

import java.util.regex.Pattern;

public class FirstDemo {
    public static void main(String[] args) {
        System.out.println(RegexHandler.checkCorrectEmail("gavranton.ee@gmail.com"));
        System.out.println(RegexHandler.matches("\\w+", "stra"));
        System.out.println(RegexHandler.getGroups("\\d+", "ma 12 va 1 getgr 156"));
        System.out.println(RegexHandler.getEmails("Emails: gavranton.ee@mail.ru, trudom@gmail.com, 1@ha.ru"));
        RegexHandler.findWordIndex("help", "ouu help me here and also and goodbye");
        RegexHandler.replaceWord("word", "book", "Word is better than whole sentence in word, new word");
    }
}
