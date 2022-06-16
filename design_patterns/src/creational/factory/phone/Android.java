package creational.factory.phone;

public class Android implements Phone {
    @Override
    public void call() {
        System.out.println("Call will produced by Android");
    }

    @Override
    public void display() {
        System.out.println("Android interface displayed");
    }

    @Override
    public void dispose() {
        System.out.println("Android disposing...");
    }
}
