package structural.flyweight.computer;

import java.util.LinkedList;
import java.util.List;

public class ComputerShop {
    private List<Computer> computers = new LinkedList<>();
    private List<Screen> screens = new LinkedList<>();

    public void addDesktop(String model, String graphics, int cores, String keyboard, String type, int hz) {
        Screen screen = ScreenFactory.getScreen(type, hz);
        Desktop desktop = ComputerFactory.getDesktop(model, graphics, screen, cores, keyboard);
        computers.add(desktop);
    }

    public void addLaptop(String model, String graphics, int workHours, String type, int hz) {
        Screen screen = ScreenFactory.getScreen(type, hz);
        Laptop laptop = ComputerFactory.getLaptop(model, graphics, screen, workHours);
        computers.add(laptop);
    }
}
