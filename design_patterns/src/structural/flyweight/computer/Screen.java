package structural.flyweight.computer;

public class Screen {
    private String type;
    private int hz;

    public Screen(String type, int hz) {
        this.type = type;
        this.hz = hz;
    }

    public void show() {
        System.out.println("Screen showing on...");
    }
}
