package creational.abstract_factory.coffee;

public class LatteColdCoffee implements ColdCoffee {
    @Override
    public void removeIce() {
        System.out.println("Ice removed in latte");
    }

    @Override
    public void drink() {
        System.out.println("Drink cold latte is cold");
    }
}
