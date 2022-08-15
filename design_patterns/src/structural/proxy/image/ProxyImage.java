package structural.proxy.image;

public class ProxyImage implements Image {
    private String filename;
    private Image image;
    private boolean remoteConnect = false;

    public ProxyImage(String filename, boolean remoteConnect) {
        this(filename);
        this.remoteConnect = remoteConnect;
    }

    public ProxyImage(String filename) {
        this.filename = filename;
        load();
    }


    @Override
    public void load() {
        if (remoteConnect) {
            image = new RemoteImage(filename);
        } else {
            image = new RealImage(filename);
        }
    }

    @Override
    public void show() {
        image.show();
    }

    @Override
    public String getFilename() {
        return null;
    }
}
