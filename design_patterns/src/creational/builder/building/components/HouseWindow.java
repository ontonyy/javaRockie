package creational.builder.building.components;

public class HouseWindow {
    private MaterialType type;

    public HouseWindow(MaterialType type) {
        this.type = type;
    }

    public void ventilate() {
        System.out.println("Let the cold into the house!");
    }

    @Override
    public String toString() {
        return "HouseWindow{" +
                "type=" + type +
                '}';
    }
}
