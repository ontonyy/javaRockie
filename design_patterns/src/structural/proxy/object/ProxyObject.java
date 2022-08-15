package structural.proxy.object;

public class ProxyObject implements Object {
    private Object object;

    @Override
    public void process() {
        if (object == null) {
            object = new ExpensiveObject();
        }
        object.process();
    }

    public void clear() {
        object = null;
    }
}
