package structural.proxy.socket;

public class MultiSocket implements Socket {
    private Socket socket;

    public MultiSocket(Socket socket) {
        this.socket = socket;
    }

    public MultiSocket(SocketType type) {
        socket = switch (type) {
            case CHINA -> new ChinaSocket(12);
            case AMERICAN -> new AmericanSocket(12);
            default -> new EuropeanSocket(12);
        };
    }

    @Override
    public int getVolts() {
        return socket.getVolts();
    }

    @Override
    public void strain() {
        socket.strain();
    }
}
