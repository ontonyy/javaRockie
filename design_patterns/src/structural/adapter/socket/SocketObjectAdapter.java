package structural.adapter.socket;

public class SocketObjectAdapter implements SocketAdapter {
    private Socket sock = new Socket();

    @Override
    public Volt get3Volt() {
        return convertVolt(sock.getVolt(), 40);
    }

    @Override
    public Volt get12Volt() {
        return convertVolt(sock.getVolt(), 10);
    }

    @Override
    public Volt get120Volt() {
        return sock.getVolt();
    }

    public Volt convertVolt(Volt volt, int i) {
        return new Volt(volt.getVolts() / i);
    }
}
