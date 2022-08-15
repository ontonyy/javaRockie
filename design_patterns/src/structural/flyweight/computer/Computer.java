package structural.flyweight.computer;

public abstract class Computer {
    private String model, graphics;
    private Screen screen;

    public Computer(String model, String graphics, Screen screen) {
        this.model = model;
        this.graphics = graphics;
        this.screen = screen;
    }

    public void show() {
        System.out.println("Simple computer showing...");
        screen.show();
    }

    public abstract void start();
}
