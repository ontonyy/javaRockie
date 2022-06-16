package creational.builder.building;

import creational.builder.building.components.HouseGarage;
import creational.builder.building.components.HouseRoof;

public interface BuildingBuilder {
    void setType(BuildingType type);
    void setDoors(int doors);
    void setWindows(int windows);
    void setRoof(HouseRoof roof);
    void setWalls(int walls);
    void setGarage(HouseGarage garage);
    Building build();
}
