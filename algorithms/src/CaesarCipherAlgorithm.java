public class CaesarCipherAlgorithm {

    public static String caesarCipher(String text, int shift) {
        String ciphered = "";
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            int byt = ((int) c) - 97; // index in alphabet
            if (byt >= 0 && byt <= 26) c = (char) ((byt + shift) % 26 + 97);
            ciphered += c;
        }
        return ciphered;
    }

    public static void main(String[] args) {
        System.out.println(caesarCipher("abc dezw", 3));
    }
}
