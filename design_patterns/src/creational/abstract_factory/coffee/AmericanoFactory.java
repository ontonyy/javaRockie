package creational.abstract_factory.coffee;

public class AmericanoFactory implements CoffeeFactory {
    @Override
    public Coffee createCoffee() {
        Coffee coffee = new AmericanoCoffee();
        coffee.drink();
        return coffee;
    }

    @Override
    public ColdCoffee createColdCoffee() {
        ColdCoffee coldCoffee = new AmericanoColdCoffee();
        coldCoffee.drink();
        return coldCoffee;
    }
}
