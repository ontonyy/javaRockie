package structural.composite.drink;

public class Tea implements Drink {
    private String taste;

    public Tea(String taste) {
        this.taste = taste;
    }

    @Override
    public void drink() {
        System.out.printf("Start drink tea with %s.\n", taste);
    }

    @Override
    public String getTaste() {
        return taste;
    }

    @Override
    public void fill() {
        System.out.println("Fill tea.");
    }
}
