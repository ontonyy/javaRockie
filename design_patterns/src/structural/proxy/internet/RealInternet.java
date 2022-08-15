package structural.proxy.internet;

public class RealInternet implements Internet {
    @Override
    public void connectTo(String link) {
        System.out.println("Real internet connecting to " + link);
    }
}
