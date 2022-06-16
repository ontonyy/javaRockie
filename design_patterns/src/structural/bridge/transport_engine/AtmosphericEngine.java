package structural.bridge.transport_engine;

public class AtmosphericEngine implements Engine {
    private int power;
    private String sound;

    public AtmosphericEngine(int power, String sound) {
        this.power = power;
        this.sound = sound;
    }

    @Override
    public void start() {
        System.out.println(sound + "! Engine starts work...");
    }

    @Override
    public String sound() {
        return sound;
    }

    @Override
    public int getPower() {
        return power;
    }
}
