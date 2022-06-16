package creational.builder.computer;

import creational.builder.computer.components.*;

public interface ComputerBuilder {
    void reset();
    ComputerBuilder setKeyboard(Keyboard keyboard);
    ComputerBuilder setScreen(Screen screen);
    ComputerBuilder setMouse(Mouse mouse);
    ComputerBuilder setGraphicCard(GraphicCard card);
    ComputerBuilder setMemory(Memory memory);
    ComputerBuilder setMotherboard(Motherboard motherboard);
    ComputerBuilder setProcessor(Processor processor);
    ComputerBuilder setUsbAmount(int amount);
    Computer build();
}
