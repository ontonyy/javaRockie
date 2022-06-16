package creational.factory.phone;

public class Iphone implements Phone {

    @Override
    public void call() {
        System.out.println("Call will produced by Iphone");
    }

    @Override
    public void display() {
        System.out.println("Iphone interface displayed");
    }

    @Override
    public void dispose() {
        System.out.println("Iphone disposing...");
    }
}
