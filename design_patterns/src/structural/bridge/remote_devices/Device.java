package structural.bridge.remote_devices;

public interface Device {
    void enable();
    int getVolume();
    void setVolume(int percentage);
    boolean isEnabled();
}
