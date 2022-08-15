package structural.composite.drink;

public class LatteCoffee extends Coffee {
    private int milk;

    public LatteCoffee(int milk) {
        super("Latte");
        this.milk = milk;
    }

    @Override
    public void drink() {
        System.out.printf("Start drink coffee with %s and %s milk litres.\n", getTaste(), getMilk());
    }

    public int getMilk() {
        return milk;
    }
}
