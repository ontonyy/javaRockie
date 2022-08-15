package structural.flyweight.computer;

public class Desktop extends Computer {
    private int cores;
    private String keyboard;

    public Desktop(String model, String graphics, Screen screen, int cores, String keyboard) {
        super(model, graphics, screen);
        this.cores = cores;
        this.keyboard = keyboard;
    }

    @Override
    public void start() {
        System.out.println("Desktop start working");
    }
}
