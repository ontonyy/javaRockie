package structural.bridge.transport_engine;

public class Car extends Transport {
    public Car(Engine engine) {
        super(engine);
    }

    @Override
    public void goTo() {
        engine.start();
        System.out.println("Car is ready to go");
    }
}
