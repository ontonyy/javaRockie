package structural.proxy.image;

public class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        load();
    }

    @Override
    public void load() {
        System.out.println("[Real image] - load");
    }

    @Override
    public void show() {
        System.out.println("[Real image] - show");
    }

    @Override
    public String getFilename() {
        return filename;
    }
}
