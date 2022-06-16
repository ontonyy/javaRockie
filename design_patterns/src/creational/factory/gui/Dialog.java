package creational.factory.gui;

public abstract class Dialog {
    public void renderWindow() {
        Button btn = createButton();
        btn.render();
    }

    public abstract Button createButton();
}
