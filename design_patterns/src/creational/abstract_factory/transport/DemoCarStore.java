package creational.abstract_factory.transport;

public class DemoCarStore {
    private static TransportFactory factory;
    private static Car car;
    private static Motorbike bike;

    public static Car createCar() {
        car = factory.createCar();
        return car;
    }

    public static Motorbike createMotorbike() {
        bike = factory.createMotorbike();
        return bike;
    }

    public static void launchTransports() {
        car.launch();
        bike.launch();
    }

    public static void transportTestDrive() {
        car.drive();
        bike.drive();
    }

    public static void main(String[] args) {
        factory = new AudiFactory();
        createCar();
        createMotorbike();
        launchTransports();
        transportTestDrive();
    }
}
