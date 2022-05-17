package patterns.AbstractFactory.DesktopFactory;

public class WindowsGUIFactory implements GUIFactory {

    public WindowsGUIFactory() {
        System.out.println("Creating GUI for Windows");
    }

    @Override
    public Button createButton() {
        System.out.println("Creating Button for Windows");
        return new WindowsButton();
    }

    @Override
    public TextField createTextField() {
        System.out.println("Create TextField for Windows");
        return new WindowsTextField();
    }

    @Override
    public Select createSelect() {
        System.out.println("Create Select for Windows");
        return new WindowsSelect();
    }
}
