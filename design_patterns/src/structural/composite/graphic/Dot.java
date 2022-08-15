package structural.composite.graphic;

public class Dot implements Graphic {
    int x, y;

    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void move(int x, int y) {
        System.out.printf("Moving dot, to x: %s, y: %s", x, y);
        this.x += x;
        this.y += y;
    }

    @Override
    public void draw() {
        System.out.println("Drawing dot!!!");
    }
}
