package structural.decorator.source;

public interface DataSource {
    void writeData(String data);
    String readData();
}
