package structural.adapter.transport;

public class CarAdapter extends Car implements Transport {
    private Transport transport;

    public CarAdapter(Transport transport) {
        super();
        this.transport = transport;
    }

    @Override
    public void move() {
        System.out.println("Adapter(" + getName()+ ") moving in ground");
    }

    @Override
    public void brake() {
        System.out.println("Adapter(" + getName() + ") try stop in ground");
    }

    @Override
    public void stay() {
        System.out.println("Adapter(" + getName() + ") seems that it stay in ground");
    }

    @Override
    public int getSpeed() {
        int speed = 0;
        if (transport instanceof FlyTransport) {
            speed = transport.getSpeed() * 60;
        } else if (transport instanceof WaterTransport) {
            speed = (int) (((double) transport.getSpeed() / 1000) / ((double) 1 / 3600));
        }
        return speed;
    }

    @Override
    public String getName() {
        return transport.getName() + " boosted monster Type R";
    }
}
