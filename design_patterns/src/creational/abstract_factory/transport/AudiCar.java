package creational.abstract_factory.transport;

public class AudiCar implements Car {
    @Override
    public void drive() {
        System.out.println("Drive Audi in the usual style");
    }

    @Override
    public void launch() {
        System.out.println("Chill, just Audi running...");
    }

    @Override
    public void turnMusic() {
        System.out.println("Listen music with prof speakers in Audi");
    }
}
