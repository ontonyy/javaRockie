package creational.abstract_factory.transport;

public class HondaFactory implements TransportFactory {
    @Override
    public Car createCar() {
        Car honda = new HondaCar();
        honda.launch();
        return honda;
    }

    @Override
    public Motorbike createMotorbike() {
        Motorbike honda = new HondaMotorbike();
        honda.launch();
        return honda;
    }
}
