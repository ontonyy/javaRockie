package creational.factory.gui;

public class GuiMain {
    private static Dialog dialog;

    public static void main(String[] args) {
        configure();
        dialog.renderWindow();
    }

    private static void configure() {
        if (System.getProperty("os.name").equalsIgnoreCase("Windows 10")) {
            dialog = new WindowsDialog();
        } else {
            dialog = new HtmlDialog();
        }
    }
}
