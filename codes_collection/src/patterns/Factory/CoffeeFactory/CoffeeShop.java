package patterns.Factory.CoffeeFactory;

public class CoffeeShop {

    private final SimpleCoffeeFactory coffeeFactory;

    public CoffeeShop(SimpleCoffeeFactory coffeeFactory) {
        this.coffeeFactory = coffeeFactory;
    }

    public Coffee orderCoffee(CoffeeType type) {
        Coffee coffee = coffeeFactory.createCoffee(type);

        if (coffee != null) {
            coffee.grindCoffee();
            coffee.makeCoffee();
            coffee.pourToCoup();
        }
        System.out.println("Here is your coffee, sir!");
        return coffee;

    }

}
