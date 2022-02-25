package patterns.FactoryMethod.CoffeeFactoryMethod;

import patterns.Factory.CoffeeFactory.CoffeeType;

public class Main {
    public static void main(String[] args) {
        ItalianCoffeeShop coffeeShop = new ItalianCoffeeShop();
        coffeeShop.orderCoffee(CoffeeType.AMERICANO);
    }
}
