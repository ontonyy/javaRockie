package structural.composite.shapes;

import java.util.LinkedList;
import java.util.List;

public class CompoundShape extends BaseShape {
    private List<Shape> shapes = new LinkedList<>();

    public CompoundShape(Shape... shapes) {
        super(0, 0);
        add(shapes);
    }

    public void add(Shape shape) {
        shapes.add(shape);
    }

    private void add(Shape... shapes) {
        this.shapes.addAll(List.of(shapes));
    }

    public void remove(Shape shape) {
        this.shapes.remove(shape);
    }

    public void remove(Shape... shapes) {
        this.shapes.removeAll(List.of(shapes));
    }

    public void clear() {
        shapes.clear();
    }

    @Override
    public void draw() {
        for (Shape shape : shapes) {
            shape.draw();
        }
    }

    @Override
    public int getX() {
        int x = 0;
        for (Shape shape : shapes) {
            x += shape.getX();
        }
        return x;
    }

    @Override
    public int getY() {
        int y = 0;
        for (Shape shape : shapes) {
            y += shape.getY();
        }
        return y;
    }
}
