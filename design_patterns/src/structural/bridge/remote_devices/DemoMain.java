package structural.bridge.remote_devices;

public class DemoMain {
    public static void main(String[] args) {
        Device tv = new Tv();
        Device radio = new Radio();
        RemoteControl remote = new RemoteControl(tv);
        remote.power();
        remote.power();
        System.out.println(tv);

        AdvancedRemoteControl advancedRemote = new AdvancedRemoteControl(radio);
        advancedRemote.power();
        advancedRemote.mute();
        System.out.println(radio);
    }
}
