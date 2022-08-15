package structural.flyweight.computer;

public class Laptop extends Computer {
    private int workHours;

    public Laptop(String model, String graphics, Screen screen, int workHours) {
        super(model, graphics, screen);
        this.workHours = workHours;
    }

    @Override
    public void start() {
        System.out.println("Laptop start working");
    }
}
