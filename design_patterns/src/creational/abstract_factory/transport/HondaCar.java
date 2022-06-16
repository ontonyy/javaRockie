package creational.abstract_factory.transport;

public class HondaCar implements Car {
    @Override
    public void drive() {
        System.out.println("Drive Honda in the usual style");
    }

    @Override
    public void launch() {
        System.out.println("Chill, just Honda running...");
    }

    @Override
    public void turnMusic() {
        System.out.println("Listen music with prof speakers in Honda");
    }
}
