package creational.prototype.drinks;

import java.util.LinkedList;
import java.util.List;

public class DemoMain {
    public static void main(String[] args) {
        List<DrinkBottle> drinks = new LinkedList<>();

        WaterBottle waterBottle = new WaterBottle();
        waterBottle.liters = 5;

        drinks.add(waterBottle);
        drinks.add(waterBottle.clone());

        JuiceBottle juiceBottle = new JuiceBottle();
        juiceBottle.liters = 1;
        juiceBottle.sugarAmount = 5;

        drinks.add(juiceBottle);

        compareDrinks(drinks);
    }

    private static void compareDrinks(List<DrinkBottle> drinks) {
        List<DrinkBottle> drinksCopy = new LinkedList<>();
        for (DrinkBottle drink : drinks) {
            drinksCopy.add(drink.clone());
        }

        for (int i = 0; i < drinks.size(); i++) {
            if (drinks.get(i) != drinksCopy.get(i)) {
                if (drinks.get(i).equals(drinksCopy.get(i))) {
                    System.out.println("identical");
                }
            }
        }

    }
}
