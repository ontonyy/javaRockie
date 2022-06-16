package creational.abstract_factory.desktop;

public class MacGUIFactory implements GUIFactory {

    public MacGUIFactory() {
        System.out.println("Creating GUI for MacOS");
    }

    @Override
    public Button createButton() {
        System.out.println("Creating Button for MacOS");
        return new MacButton();
    }

    @Override
    public TextField createTextField() {
        System.out.println("Create TextField for MacOS");
        return new MacTextField();
    }

    @Override
    public Select createSelect() {
        System.out.println("Create Select for MacOS");
        return new MacSelect();
    }
}
