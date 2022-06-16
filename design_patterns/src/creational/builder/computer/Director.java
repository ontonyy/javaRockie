package creational.builder.computer;

import creational.builder.computer.components.*;

public class Director {
    private final ComputerBuilder builder;

    public Director(ComputerBuilder builder) {
        this.builder = builder;
    }

    public Computer createGamingComputer() {
        return builder.setUsbAmount(4)
                .setKeyboard(new Keyboard("EN"))
                .setMemory(new Memory(1000))
                .setMotherboard(new Motherboard())
                .setMouse(new Mouse("Logitech"))
                .setProcessor(new Processor())
                .setScreen(new Screen(180))
                .setGraphicCard(new GraphicCard("AMD"))
                .build();
    }

    public Computer createFamilyComputer() {
        return builder.setUsbAmount(2)
                .setKeyboard(new Keyboard("EN"))
                .setMemory(new Memory(300))
                .setMotherboard(new Motherboard())
                .setMouse(new Mouse("HP"))
                .setProcessor(new Processor())
                .setScreen(new Screen(45))
                .setGraphicCard(new GraphicCard("Intel"))
                .build();
    }

    public Computer createSimpleComputer() {
        return builder.setUsbAmount(3)
                .setKeyboard(new Keyboard("EN"))
                .setMemory(new Memory(480))
                .setMotherboard(new Motherboard())
                .setMouse(new Mouse("HP"))
                .setProcessor(new Processor())
                .setScreen(new Screen(60))
                .setGraphicCard(new GraphicCard("Intel"))
                .build();
    }
}
