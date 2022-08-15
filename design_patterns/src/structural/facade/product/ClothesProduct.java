package structural.facade.product;

public class ClothesProduct implements Product {
    @Override
    public void action() {
        System.out.println("Make a person dress");
    }

    @Override
    public String getProperty() {
        return "dressed";
    }
}
