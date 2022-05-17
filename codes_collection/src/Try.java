import java.util.ArrayList;
import java.util.List;

public class Try {
    public static List<String> s(String text, int n) {
        if (n == 0){
            return new ArrayList<>();
        }
        List<String> list = s(text.substring(1), n -1);
        list.add(text);
        return list;
    }

    public static void main(String[] args) {
        System.out.println(s("hello", 3));
    }
}
