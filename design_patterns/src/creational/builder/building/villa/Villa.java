package creational.builder.building.villa;

import creational.builder.building.Building;
import creational.builder.building.BuildingType;
import creational.builder.building.components.*;

import java.util.List;

public class Villa implements Building {
    private final BuildingType type;
    private final HouseRoof roof;
    private final HouseGarage garage;
    private final List<HouseWall> walls;
    private final List<HouseDoor> doors;
    private final List<HouseWindow> windows;

    public Villa(BuildingType type, HouseRoof roof, HouseGarage garage, List<HouseWall> walls, List<HouseDoor> doors, List<HouseWindow> windows) {
        this.type = type;
        this.roof = roof;
        this.garage = garage;
        this.walls = walls;
        this.doors = doors;
        this.windows = windows;
    }

    @Override
    public void stay() {
        System.out.println("Villa stay!");
    }

    @Override
    public void protectPeople() {
        System.out.println("Villa protect!");
    }

    @Override
    public void lookNice() {
        System.out.println("Villa look nice!");
    }
}
