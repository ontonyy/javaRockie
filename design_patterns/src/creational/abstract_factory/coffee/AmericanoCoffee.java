package creational.abstract_factory.coffee;

public class AmericanoCoffee implements Coffee {
    @Override
    public void addSugar() {
        System.out.println("Sugar added to hot americano");
    }

    @Override
    public void drink() {
        System.out.println("Americano drinking process start...");
    }
}
