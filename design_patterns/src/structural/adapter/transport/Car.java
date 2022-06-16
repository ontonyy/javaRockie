package structural.adapter.transport;

public class Car implements GroundTransport, Transport {
    private int speed;
    private String name;

    public Car() {
    }

    public Car(String name, int speed) {
        this.speed = speed;
        this.name = name;
    }

    public void speedRace(Car car) {
        if (speed >= car.getSpeed()) {
            System.out.println(getName() + " is winner!!!");
        } else {
            System.out.println(car.getName() + " is winner!!!");
        }
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void move() {
        System.out.println("Car move on ground");
    }

    @Override
    public void brake() {
        System.out.println("Car stopping");
    }

    @Override
    public void stay() {
        System.out.println("Car fully stop");
    }
}
