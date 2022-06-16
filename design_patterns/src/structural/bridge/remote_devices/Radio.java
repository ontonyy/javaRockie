package structural.bridge.remote_devices;

public class Radio implements Device {
    private boolean powerOn;
    private int volume;

    @Override
    public void enable() {
        powerOn = !powerOn;
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int percentage) {
        volume = percentage;
    }

    @Override
    public boolean isEnabled() {
        return powerOn;
    }

    @Override
    public String toString() {
        return "[Radio - playing music...]: powerOn=" + powerOn + ", volume=" + volume;
    }
}
