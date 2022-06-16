package structural.adapter.transport;

public class Boat implements WaterTransport, Transport {
    private String name;
    private int speed; // speed in M/S

    public Boat(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    @Override
    public void swim() {
        System.out.println("Boat swim with the flow");
    }

    @Override
    public void dropAnchor() {
        System.out.println("Boat stops dropping anchor");
    }

    @Override
    public void spreadSails() {
        System.out.println("Boat want to be faster, and spread sails");
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public String getName() {
        return name;
    }
}
