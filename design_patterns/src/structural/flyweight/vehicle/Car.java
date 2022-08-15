package structural.flyweight.vehicle;

public class Car implements Vehicle {
    private String color, model;

    public Car(String color, String model) {
        this.color = color;
        this.model = model;
    }

    @Override
    public void move() {
        System.out.printf("Car(%s) with %s color is moving", model, color);
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
