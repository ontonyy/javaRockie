package creational.abstract_factory.transport;

public class AudiFactory implements TransportFactory {
    @Override
    public Car createCar() {
        Car audi = new AudiCar();
        audi.launch();
        return audi;
    }

    @Override
    public Motorbike createMotorbike() {
        Motorbike audi = new AudiMotorbike();
        audi.launch();
        return audi;
    }
}
