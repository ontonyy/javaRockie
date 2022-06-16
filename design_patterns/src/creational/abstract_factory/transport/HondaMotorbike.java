package creational.abstract_factory.transport;

public class HondaMotorbike implements Motorbike {
    @Override
    public void drive() {
        System.out.println("Simple drive on Honda");
    }

    @Override
    public void driveOnOneWheel() {
        System.out.println("Rearing up on Honda");
    }

    @Override
    public void launch() {
        System.out.println("Monster(Honda) launching");
    }
}
