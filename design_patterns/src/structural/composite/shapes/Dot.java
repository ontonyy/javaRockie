package structural.composite.shapes;

public class Dot extends BaseShape {
    private int radius;

    public Dot(int x, int y, int radius) {
        super(x, y);
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing dot...");
    }
}
