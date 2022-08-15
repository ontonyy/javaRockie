package structural.flyweight.vehicle;

import java.util.LinkedHashMap;
import java.util.Map;

public class VehicleFactory {
    private static Map<String, Vehicle> vehicles = new LinkedHashMap<>();

    public static Car getCar(String model, String color) {
        String key = "Car - " + model;
        Car car = (Car) vehicles.get(key);
        if (car == null) {
            car = new Car(color, model);
            vehicles.put(key, car);
        }
        return car;
    }

    public static Motorbike getMoto(String model, String color) {
        String key = "Motorbike - " + model;
        Motorbike car = (Motorbike) vehicles.get(key);
        if (car == null) {
            car = new Motorbike(color, model);
            vehicles.put(key, car);
        }
        return car;
    }
}
