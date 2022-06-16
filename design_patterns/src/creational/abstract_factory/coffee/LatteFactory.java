package creational.abstract_factory.coffee;

public class LatteFactory implements CoffeeFactory {
    @Override
    public Coffee createCoffee() {
        Coffee coffee = new LatteCoffee();
        coffee.drink();
        return coffee;
    }

    @Override
    public ColdCoffee createColdCoffee() {
        ColdCoffee coldCoffee = new LatteColdCoffee();
        coldCoffee.drink();
        return coldCoffee;
    }
}
