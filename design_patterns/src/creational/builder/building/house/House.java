package creational.builder.building.house;

import creational.builder.building.Building;
import creational.builder.building.BuildingType;
import creational.builder.building.components.*;

import java.util.List;

public class House implements Building {
    private final BuildingType type;
    private final HouseRoof roof;
    private final HouseGarage garage;
    private final List<HouseWall> walls;
    private final List<HouseDoor> doors;
    private final List<HouseWindow> windows;

    public House(BuildingType type, HouseRoof roof, HouseGarage garage, List<HouseWall> walls, List<HouseDoor> doors, List<HouseWindow> windows) {
        this.type = type;
        this.roof = roof;
        this.garage = garage;
        this.walls = walls;
        this.doors = doors;
        this.windows = windows;
    }

    @Override
    public String toString() {
        return "House{" +
                "type=" + type +
                ", roof=" + roof +
                ", garage=" + garage +
                ", walls=" + walls +
                ", doors=" + doors +
                ", windows=" + windows +
                '}';
    }

    @Override
    public void stay() {
        System.out.println("House stay!");
    }

    @Override
    public void protectPeople() {
        System.out.println("House protect people!");
    }

    @Override
    public void lookNice() {
        System.out.println("House look nice!");
    }
}
