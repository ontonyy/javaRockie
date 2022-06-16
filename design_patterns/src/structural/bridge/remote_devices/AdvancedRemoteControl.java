package structural.bridge.remote_devices;

public class AdvancedRemoteControl extends RemoteControl {

    public AdvancedRemoteControl(Device device) {
        super(device);
    }

    public void mute() {
        System.out.println("[Advanced remote] Mute");
        device.setVolume(0);
    }
}
