package structural.composite.drink;

import java.util.*;

public class DrinkStall implements Drink {
    private List<Drink> drinks = new LinkedList<>();

    public void add(Drink drink) {
        drinks.add(drink);
    }

    public void add(Drink... drinks) {
        this.drinks.addAll(List.of(drinks));
    }

    public void remove(Drink drink) {
        drinks.remove(drink);
    }

    @Override
    public void drink() {
        for (Drink drink : drinks) {
            drink.drink();
        }
    }

    @Override
    public String getTaste() {
        Map<String, Integer> drinksMap = new LinkedHashMap<>();
        for (Drink drink : drinks) {
            drinksMap.put(drink.getTaste(), drinksMap.getOrDefault(drink.getTaste(), 0) + 1);
        }
        return Collections.max(drinksMap.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
    }

    @Override
    public void fill() {
        for (Drink drink : drinks) {
            drink.fill();
        }
    }
}
