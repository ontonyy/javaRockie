package creational.factory.gui;

public class WindowsButton implements Button {
    @Override
    public void onClick() {
        System.out.println("Clicked windows button!");
    }

    @Override
    public void render() {
        System.out.println("Button render/test (Windows)");
        onClick();
    }
}
