package creational.builder.computer.components;

public class Keyboard {
    private String mainLanguage;

    public Keyboard(String mainLanguage) {
        this.mainLanguage = mainLanguage;
    }

    public void clickButtons() {
        System.out.println("Keyboard was clicked!");
    }

    @Override
    public String toString() {
        return "Keyboard{" +
                "mainLanguage='" + mainLanguage + '\'' +
                '}';
    }
}
