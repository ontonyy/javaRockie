package creational.abstract_factory.desktop;

public class Application {
    private OrderCoffeeForm coffeeForm;

    public void drawOrderCoffeeForm() {
        String osName = System.getProperty("os.name").toLowerCase();
        GUIFactory factory;

        if (osName.startsWith("win")) factory = new WindowsGUIFactory();
        else if (osName.startsWith("mac")) factory = new MacGUIFactory();
        else {
            System.out.println("Unknown OS!!!");
            return;
        }
        coffeeForm = new OrderCoffeeForm(factory);
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.drawOrderCoffeeForm();
    }

}
