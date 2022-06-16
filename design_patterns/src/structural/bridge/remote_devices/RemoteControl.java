package structural.bridge.remote_devices;

public class RemoteControl implements Remote {
    protected Device device;

    public RemoteControl(Device device) {
        this.device = device;
    }

    @Override
    public void power() {
        if (!device.isEnabled()) {
            System.out.println("[Remote] Power on.");
        } else {
            System.out.println("[Remote] Power off.");
        }
        device.enable();
    }

    @Override
    public void volumeUp() {
        System.out.println("[Remote] Volume up");
        device.setVolume(device.getVolume() + 10);
    }

    @Override
    public void volumeDown() {
        System.out.println("[Remote] Volume down");
        device.setVolume(device.getVolume() - 10);
    }
}
