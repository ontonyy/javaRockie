package structural.bridge.transport_engine;

public abstract class Transport {
    protected Engine engine;

    public Transport(Engine engine) {
        this.engine = engine;
    }

    public void goTo() {
        engine.start();
        System.out.println("Transport is ready to go");
    }
}
