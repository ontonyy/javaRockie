package structural.proxy.socket;

public class ChinaSocket implements Socket {
    private int volts;

    public ChinaSocket(int volts) {
        this.volts = volts;
    }

    @Override
    public int getVolts() {
        return volts;
    }

    @Override
    public void strain() {
        System.out.println("[China socket] - give tension of " + volts + " volts");
    }
}
