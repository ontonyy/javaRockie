package creational.builder.computer.components;

public class Screen {
    private int hertz;

    public Screen(int hertz) {
        this.hertz = hertz;
    }

    public void turnOn() {
        System.out.println("Screen start show something!");
    }

    @Override
    public String toString() {
        return "Screen{" +
                "hertz=" + hertz +
                '}';
    }
}
