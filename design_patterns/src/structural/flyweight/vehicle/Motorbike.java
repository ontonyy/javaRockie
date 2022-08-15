package structural.flyweight.vehicle;

public class Motorbike implements Vehicle {
    private String color, model;

    public Motorbike(String color, String model) {
        this.color = color;
        this.model = model;
    }

    @Override
    public void move() {
        System.out.printf("Motorbike(%s) with %s color is moving", model, color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getModel() {
        return model;
    }
}
