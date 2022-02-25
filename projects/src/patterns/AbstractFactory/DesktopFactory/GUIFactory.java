package patterns.AbstractFactory.DesktopFactory;

public interface GUIFactory {
    Button createButton();
    TextField createTextField();
    Select createSelect();
}
