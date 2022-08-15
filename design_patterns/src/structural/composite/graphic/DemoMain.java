package structural.composite.graphic;

public class DemoMain {

    public static void load() {
        CompoundGraphic graphic = new CompoundGraphic();
        graphic.add(new Circle(5, 5, 10));
        graphic.add(new Dot(50, 50));
        graphic.draw();
    }

    public static void main(String[] args) {
        load();
    }
}
