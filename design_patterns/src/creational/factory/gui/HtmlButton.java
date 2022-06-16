package creational.factory.gui;

public class HtmlButton implements Button {
    @Override
    public void onClick() {
        System.out.println("Html button clicked!");
    }

    @Override
    public void render() {
        System.out.println("Button render/test (Html)");
        onClick();
    }
}
