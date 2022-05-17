package patterns.Bridge;

public class Main {
    public static void main(String[] args) {
        Color RedColor = new RedColor();
        Rectangle rectangle = new Rectangle(RedColor);
        rectangle.draw();

        Color GreenColor = new GreenColor();
        Triangle triangle = new Triangle(GreenColor);
        triangle.draw();
    }
}
