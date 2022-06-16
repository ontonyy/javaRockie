package creational.builder.computer;

import creational.builder.computer.components.Keyboard;
import creational.builder.computer.components.Mouse;
import creational.builder.computer.components.Screen;
import creational.builder.computer.windows.WindowsComputerBuilder;

public class DemoMain {
    public static void main(String[] args) {
        WindowsComputerBuilder builder = new WindowsComputerBuilder();
        Director director = new Director(builder);
        System.out.println(director.createGamingComputer());
        System.out.println(director.createSimpleComputer());
        System.out.println(director.createFamilyComputer());
        Computer computer = builder.setKeyboard(new Keyboard("RU")).setScreen(new Screen(60)).setMouse(new Mouse("HP")).build();
        System.out.println(computer);
    }
}
