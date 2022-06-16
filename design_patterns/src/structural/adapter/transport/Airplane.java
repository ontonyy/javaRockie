package structural.adapter.transport;

public class Airplane implements FlyTransport, Transport {
    private String name;
    private int speed; // speed in KM/MIN

    public Airplane(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    @Override
    public void moveFast() {
        System.out.println("Airplane seen in the clouds");
    }

    @Override
    public void getChassis() {
        System.out.println("Airplane declining...");
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
