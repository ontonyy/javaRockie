package creational.builder.building.house;

import creational.builder.building.Building;
import creational.builder.building.BuildingBuilder;
import creational.builder.building.BuildingType;
import creational.builder.building.components.*;

import java.util.LinkedList;
import java.util.List;

public class HouseBuilder implements BuildingBuilder {
    private BuildingType type;
    private HouseRoof roof;
    private HouseGarage garage;
    private List<HouseWall> walls = new LinkedList<>();
    private List<HouseDoor> doors = new LinkedList<>();
    private List<HouseWindow> windows = new LinkedList<>();

    @Override
    public void setType(BuildingType type) {
        this.type = type;
    }

    @Override
    public void setRoof(HouseRoof roof) {
        this.roof = roof;
    }

    @Override
    public void setGarage(HouseGarage garage) {
        this.garage = garage;
    }

    @Override
    public void setDoors(int doors) {
        for (int i = 0; i < doors; i++) {
            this.doors.add(new HouseDoor(MaterialType.PLASTIC));
        }
    }

    @Override
    public void setWindows(int windows) {
        for (int i = 0; i < windows; i++) {
            this.windows.add(new HouseWindow(MaterialType.GLASS));
        }
    }

    @Override
    public void setWalls(int walls) {
        for (int i = 0; i < walls; i++) {
            this.walls.add(new HouseWall(MaterialType.BRICK));
        }
    }

    @Override
    public Building build() {
        return new House(type, roof, garage, walls, doors, windows);
    }
}
