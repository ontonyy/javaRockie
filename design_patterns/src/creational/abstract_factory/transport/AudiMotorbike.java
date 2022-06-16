package creational.abstract_factory.transport;

public class AudiMotorbike implements Motorbike {
    @Override
    public void drive() {
        System.out.println("Simple drive on Audi");
    }

    @Override
    public void driveOnOneWheel() {
        System.out.println("Rearing up on Audi");
    }

    @Override
    public void launch() {
        System.out.println("Monster(Audi) launching");
    }
}
