package structural.composite.shapes;

public class BaseShape implements Shape {
    private int x, y;

    public BaseShape(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int getX() {
        return x;
    }


    @Override
    public int getY() {
        return y;
    }

    @Override
    public void draw() {
        System.out.printf("Shape with x: %s, y: %s", x, y);
    }
}
