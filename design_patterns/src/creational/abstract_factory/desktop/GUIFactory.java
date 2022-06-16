package creational.abstract_factory.desktop;

public interface GUIFactory {
    Button createButton();
    TextField createTextField();
    Select createSelect();
}
