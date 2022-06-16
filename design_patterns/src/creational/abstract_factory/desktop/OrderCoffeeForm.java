package creational.abstract_factory.desktop;

public class OrderCoffeeForm {
    private final TextField customTextField;
    private final Button customButton;
    private final Select customSelect;

    public OrderCoffeeForm(GUIFactory factory) {
        System.out.println("Creating order coffee form");
        customTextField = factory.createTextField();
        customButton = factory.createButton();
        customSelect = factory.createSelect();
    }
}
