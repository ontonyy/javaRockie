package creational.builder.building.components;

public class HouseRoof {
    private MaterialType type;

    public HouseRoof(MaterialType type) {
        this.type = type;
    }

    public void protectRain() {
        System.out.println("Roof protect from rain");
    }

    public void insulate() {
        System.out.println("Insulate human inside in winter");
    }

    @Override
    public String toString() {
        return "HouseRoof{" +
                "type=" + type +
                '}';
    }
}
