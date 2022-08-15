package structural.proxy.object;

public class ExpensiveObject implements Object {

    @Override
    public void process() {
        System.out.println("Expensive object process completing");
    }
}
