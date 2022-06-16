package creational.builder.building;

import creational.builder.building.components.HouseGarage;
import creational.builder.building.components.HouseRoof;
import creational.builder.building.components.MaterialType;

public class Director {
    private BuildingBuilder builder;

    public Director(BuildingBuilder builder) {
        this.builder = builder;
    }

    public Building createSimpleBuilding() {
        builder.setType(BuildingType.SIMPLE);
        builder.setDoors(1);
        builder.setWindows(3);
        builder.setGarage(new HouseGarage(1));
        builder.setRoof(new HouseRoof(MaterialType.BRICK));
        builder.setWalls(4);
        return builder.build();
    }

    public Building createFamilyBuilding() {
        builder.setType(BuildingType.FAMILY);
        builder.setDoors(2);
        builder.setWindows(5);
        builder.setGarage(new HouseGarage(2));
        builder.setRoof(new HouseRoof(MaterialType.BRICK));
        builder.setWalls(7);
        return builder.build();
    }

    public Building createHotelBuilding() {
        builder.setType(BuildingType.HOTEL);
        builder.setDoors(8);
        builder.setWindows(20);
        builder.setGarage(new HouseGarage(30));
        builder.setRoof(new HouseRoof(MaterialType.IRON));
        builder.setWalls(20);
        return builder.build();
    }

}
