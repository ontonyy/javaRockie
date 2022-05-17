package patterns.FactoryMethod.CoffeeFactoryMethod;

import patterns.Factory.CoffeeFactory.CoffeeType;

public abstract class CoffeeShop {
    public Coffee orderCoffee(CoffeeType type) {
        Coffee coffee = createCoffee(type);

        coffee.grindCoffee();
        coffee.makeCoffee();

        System.out.println("Your coffee is done!");
        return coffee;
    }

    protected abstract Coffee createCoffee(CoffeeType type);
}
