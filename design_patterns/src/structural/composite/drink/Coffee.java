package structural.composite.drink;

public class Coffee implements Drink {
    private String taste;

    public Coffee(String taste) {
        this.taste = taste;
    }

    @Override
    public void drink() {
        System.out.printf("Start drink coffee with %s.\n", taste);
    }

    @Override
    public String getTaste() {
        return taste;
    }

    @Override
    public void fill() {
        System.out.println("Fill coffee.");
    }
}
