package creational.builder.computer.ios;

import creational.builder.computer.Computer;
import creational.builder.computer.components.*;

public class IosComputer implements Computer {
    private Keyboard keyboard;
    private Screen screen;
    private Mouse mouse;
    private GraphicCard graphicCard;
    private Memory memory;
    private Motherboard motherboard;
    private Processor processor;
    private int usbAmount;

    public IosComputer() {
    }

    public IosComputer(Keyboard keyboard, Screen screen, Mouse mouse, GraphicCard graphicCard, Memory memory, Motherboard motherboard, Processor processor, int usbAmount) {
        this.keyboard = keyboard;
        this.screen = screen;
        this.mouse = mouse;
        this.graphicCard = graphicCard;
        this.memory = memory;
        this.motherboard = motherboard;
        this.processor = processor;
        this.usbAmount = usbAmount;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }

    public void setGraphicCard(GraphicCard graphicCard) {
        this.graphicCard = graphicCard;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    public void setMotherboard(Motherboard motherboard) {
        this.motherboard = motherboard;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public void setUsbAmount(int usbAmount) {
        this.usbAmount = usbAmount;
    }

    @Override
    public String toString() {
        return "WindowsComputer{" +
                "keyboard=" + keyboard +
                ", screen=" + screen +
                ", mouse=" + mouse +
                ", graphicCard=" + graphicCard +
                ", memory=" + memory +
                ", motherboard=" + motherboard +
                ", processor=" + processor +
                ", usbAmount=" + usbAmount +
                '}';
    }

    @Override
    public void display() {
        System.out.println(screen.toString() + " display some views");
    }

    @Override
    public void run() {
        System.out.println(processor.toString() + " start work.");
    }

    @Override
    public void playGames() {
        System.out.println("Bad, bad, bad, cannot play on it...");
    }
}
