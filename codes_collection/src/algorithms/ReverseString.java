package algorithms;

public class ReverseString {

    public static String reverseString(String rev) {
        String reversed = "";
        for (int i = rev.length() - 1; i >= 0; i--) {
            reversed += rev.charAt(i);
        }
        // or
//        for (int i = 0; i < rev.length(); i++) {
//            reversed = rev.charAt(i) + reversed;
//        }
        return reversed;
    }

    public static void main(String[] args) {
        System.out.println(reverseString("karudaj"));
    }
}
