package structural.proxy.socket;

public class EuropeanSocket implements Socket {
    private int volts;

    public EuropeanSocket(int volts) {
        this.volts = volts;
    }

    @Override
    public int getVolts() {
        return volts;
    }

    @Override
    public void strain() {
        System.out.println("[European socket] - give tension of " + volts + " volts");
    }
}
