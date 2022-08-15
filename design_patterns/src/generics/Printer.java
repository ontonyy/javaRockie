package generics;

public class Printer <T> {
    private T object;

    public Printer(T object) {
        this.object = object;
    }

    public void print() {
        System.out.println(object);
    }
}

class Main {
    public static void main(String[] args) {
        Printer<Integer> integerPrinter = new Printer<>(15);
        integerPrinter.print();
    }
}
