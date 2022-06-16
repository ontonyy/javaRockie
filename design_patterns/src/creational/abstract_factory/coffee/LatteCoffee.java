package creational.abstract_factory.coffee;

public class LatteCoffee implements Coffee {
    @Override
    public void addSugar() {
        System.out.println("Sugar added to hot latte");
    }

    @Override
    public void drink() {
        System.out.println("Latte drinking process start...");
    }
}
