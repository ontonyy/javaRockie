package structural.adapter.transport;

public class DemoMain {
    public static void main(String[] args) {
        Car car = new Car("Mazda 6", 100);
        Airplane plane = new Airplane("ChiChi", 1);
        Boat boat = new Boat("StarTar", 10);
        CarAdapter carAdapter = new CarAdapter(plane);
        car.speedRace(carAdapter);
    }
}
