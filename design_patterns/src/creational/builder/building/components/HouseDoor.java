package creational.builder.building.components;

public class HouseDoor {
    private MaterialType type;

    public HouseDoor(MaterialType type) {
        this.type = type;
    }

    public void lock() {
        System.out.println("Locking the house door...");
    }

    @Override
    public String toString() {
        return "HouseDoor{" +
                "type=" + type +
                '}';
    }
}
