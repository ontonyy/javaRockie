package structural.decorator.source;

public class SourceDecorator implements DataSource {
    private DataSource wrappee;

    public SourceDecorator(DataSource wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public void writeData(String data) {
        wrappee.writeData(data);
    }

    @Override
    public String readData() {
        return wrappee.readData();
    }
}
