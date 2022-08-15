package structural.composite.drink;

public class DemoMain {
    public static void main(String[] args) {
        DrinkStall stall = new DrinkStall();
        stall.add(
                new Coffee("Americano"),
                new LatteCoffee(1),
                new Tea("Green"),
                new LatteCoffee(0),
                new Tea("Black")
        );
        stall.drink();
        stall.fill();
        System.out.println(stall.getTaste());
    }
}
