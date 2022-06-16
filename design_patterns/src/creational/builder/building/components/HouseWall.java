package creational.builder.building.components;

public class HouseWall {
    private MaterialType type;

    public HouseWall(MaterialType type) {
        this.type = type;
    }

    public void protect() {
        System.out.println("Wall protect from frost, hearing and sight");
    }

    @Override
    public String toString() {
        return "HouseWall{" +
                "type=" + type +
                '}';
    }
}
