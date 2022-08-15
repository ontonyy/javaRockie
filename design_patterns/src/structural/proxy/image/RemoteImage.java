package structural.proxy.image;

public class RemoteImage implements Image {
    private String filename;

    public RemoteImage(String filename) {
        this.filename = filename;
        load();
    }

    @Override
    public void load() {
        System.out.println("[Remote image] - load");
    }

    @Override
    public void show() {
        System.out.println("[Remote image] - show");
    }

    @Override
    public String getFilename() {
        return filename;
    }
}
