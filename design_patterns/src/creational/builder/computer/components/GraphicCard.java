package creational.builder.computer.components;

public class GraphicCard {
    private String manufacturer;

    public GraphicCard(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "GraphicCard{" +
                "manufacturer='" + manufacturer + '\'' +
                '}';
    }
}
