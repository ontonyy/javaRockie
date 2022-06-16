package creational.builder.computer.ios;

import creational.builder.computer.Computer;
import creational.builder.computer.ComputerBuilder;
import creational.builder.computer.components.*;

public class IosComputerBuilder implements ComputerBuilder {
    private IosComputer computer = new IosComputer();

    @Override
    public void reset() {
        computer = new IosComputer();
    }

    @Override
    public IosComputerBuilder setKeyboard(Keyboard keyboard) {
        computer.setKeyboard(keyboard);
        return this;
    }

    @Override
    public IosComputerBuilder setScreen(Screen screen) {
        computer.setScreen(screen);
        return this;
    }

    @Override
    public IosComputerBuilder setMouse(Mouse mouse) {
        computer.setMouse(mouse);
        return this;
    }

    @Override
    public IosComputerBuilder setGraphicCard(GraphicCard card) {
        computer.setGraphicCard(card);
        return this;
    }

    @Override
    public IosComputerBuilder setMemory(Memory memory) {
        computer.setMemory(memory);
        return this;
    }

    @Override
    public IosComputerBuilder setMotherboard(Motherboard motherboard) {
        computer.setMotherboard(motherboard);
        return this;
    }

    @Override
    public IosComputerBuilder setProcessor(Processor processor) {
        computer.setProcessor(processor);
        return this;
    }

    @Override
    public IosComputerBuilder setUsbAmount(int amount) {
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
