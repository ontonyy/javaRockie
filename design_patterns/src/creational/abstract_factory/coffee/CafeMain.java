package creational.abstract_factory.coffee;

import java.util.LinkedList;
import java.util.List;

public class CafeMain {
    private static CoffeeFactory factory;
    private static List<Coffee> coffeeList = new LinkedList<>();
    private static List<ColdCoffee> coldCoffeeList = new LinkedList<>();

    public static void addCoffee() {
        Coffee coffee = factory.createCoffee();
        coffeeList.add(coffee);
    }

    public static void addColdCoffee() {
        ColdCoffee coffee = factory.createColdCoffee();
        coldCoffeeList.add(coffee);
    }

    public static void addSugar() {
        for (Coffee coffee : coffeeList) {
            coffee.addSugar();
        }
    }

    public static void removeIce() {
        for (ColdCoffee coldCoffee : coldCoffeeList) {
            coldCoffee.removeIce();
        }
    }

    public static void massiveCoffeeDrink() {
        for (Coffee coffee : coffeeList) {
            coffee.drink();
        }
        for (ColdCoffee coldCoffee : coldCoffeeList) {
            coldCoffee.drink();
        }
    }

    public static void main(String[] args) {
        factory = new LatteFactory();
        addCoffee();
        addColdCoffee();
        addSugar();
        removeIce();
        massiveCoffeeDrink();
    }
}
