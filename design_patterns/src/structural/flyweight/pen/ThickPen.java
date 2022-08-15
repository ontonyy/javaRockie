package structural.flyweight.pen;

public class ThickPen implements Pen {
    private String color;

    public ThickPen(String color) {
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
        System.out.printf("Thick pen with color - %s\n", color);
    }
}
