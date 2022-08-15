package structural.facade.product;

public class PhysicalProduct implements Product {
    @Override
    public void action() {
        System.out.println("Make something physical.");
    }

    @Override
    public String getProperty() {
        return "physical";
    }
}
