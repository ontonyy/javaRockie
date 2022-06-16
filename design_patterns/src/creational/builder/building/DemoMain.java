package creational.builder.building;

import creational.builder.building.house.HouseBuilder;

public class DemoMain {
    public static void main(String[] args) {
        HouseBuilder builder = new HouseBuilder();
        Director director = new Director(builder);
        System.out.println(director.createSimpleBuilding());
        System.out.println(director.createHotelBuilding());
        System.out.println(director.createFamilyBuilding());
    }
}
