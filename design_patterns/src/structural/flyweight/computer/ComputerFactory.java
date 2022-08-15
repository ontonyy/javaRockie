package structural.flyweight.computer;

import java.util.LinkedHashMap;
import java.util.Map;

public class ComputerFactory {
    private static Map<String, Desktop> desktops = new LinkedHashMap<>();
    private static Map<String, Laptop> laptops = new LinkedHashMap<>();

    public static Desktop getDesktop(String model, String graphics, Screen screen, int cores, String keyboard) {
        Desktop result = desktops.get(model);
        if (result == null) {
            result = new Desktop(model, graphics, screen, cores, keyboard);
            desktops.put(model, result);
        }
        return result;
    }

    public static Laptop getLaptop(String model, String graphics, Screen screen, int workHours) {
        Laptop result = laptops.get(model);
        if (result == null) {
            result = new Laptop(model, graphics, screen, workHours);
            laptops.put(model, result);
        }
        return result;
    }

    public static Map<String, Desktop> getDesktops() {
        return desktops;
    }

    public static Map<String, Laptop> getLaptops() {
        return laptops;
    }
}
