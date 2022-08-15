package structural.flyweight.pen;

public class ThinPen implements Pen {
    private String color;

    public ThinPen(String color) {
        this.color = color;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public void draw() {
        System.out.printf("Thin pen with color - %s\n", color);
    }
}
