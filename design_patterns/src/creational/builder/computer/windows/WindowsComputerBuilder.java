package creational.builder.computer.windows;

import creational.builder.computer.Computer;
import creational.builder.computer.ComputerBuilder;
import creational.builder.computer.components.*;

public class WindowsComputerBuilder implements ComputerBuilder {
    private WindowsComputer computer = new WindowsComputer();

    @Override
    public void reset() {
        computer = new WindowsComputer();
    }

    @Override
    public WindowsComputerBuilder setKeyboard(Keyboard keyboard) {
        computer.setKeyboard(keyboard);
        return this;
    }

    @Override
    public WindowsComputerBuilder setScreen(Screen screen) {
        computer.setScreen(screen);
        return this;
    }

    @Override
    public WindowsComputerBuilder setMouse(Mouse mouse) {
        computer.setMouse(mouse);
        return this;
    }

    @Override
    public WindowsComputerBuilder setGraphicCard(GraphicCard card) {
        computer.setGraphicCard(card);
        return this;
    }

    @Override
    public WindowsComputerBuilder setMemory(Memory memory) {
        computer.setMemory(memory);
        return this;
    }

    @Override
    public WindowsComputerBuilder setMotherboard(Motherboard motherboard) {
        computer.setMotherboard(motherboard);
        return this;
    }

    @Override
    public WindowsComputerBuilder setProcessor(Processor processor) {
        computer.setProcessor(processor);
        return this;
    }

    @Override
    public WindowsComputerBuilder setUsbAmount(int amount) {
        computer.setUsbAmount(amount);
        return this;
    }

    @Override
    public Computer build() {
        Computer comp = computer;
        reset();
        return comp;
    }
}
