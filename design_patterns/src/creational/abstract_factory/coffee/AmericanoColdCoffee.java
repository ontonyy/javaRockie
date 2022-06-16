package creational.abstract_factory.coffee;

public class AmericanoColdCoffee implements ColdCoffee {
    @Override
    public void removeIce() {
        System.out.println("Ice removed in americano");
    }

    @Override
    public void drink() {
        System.out.println("Drink cold americano is cold");
    }
}
