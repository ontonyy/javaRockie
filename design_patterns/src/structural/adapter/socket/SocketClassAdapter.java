package structural.adapter.socket;

public class SocketClassAdapter extends Socket implements SocketAdapter {
    @Override
    public Volt get3Volt() {
        return convertVolt(getVolt(), 40);
    }

    @Override
    public Volt get12Volt() {
        return convertVolt(getVolt(), 10);
    }

    @Override
    public Volt get120Volt() {
        return getVolt();
    }

    public Volt convertVolt(Volt volt, int i) {
        return new Volt(volt.getVolts() / i);
    }
}
