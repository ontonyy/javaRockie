package structural.proxy.socket;

public class AmericanSocket implements Socket {
    private int volts;

    public AmericanSocket(int volts) {
        this.volts = volts;
    }

    @Override
    public int getVolts() {
        return volts;
    }

    @Override
    public void strain() {
        System.out.println("[American socket] - give tension of " + volts + " volts");
    }
}
