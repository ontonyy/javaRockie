package structural.facade.product;

public class FoodProduct implements Product {
    @Override
    public void action() {
        System.out.println("Give to person energy.");
    }

    @Override
    public String getProperty() {
        return "energy";
    }
}
