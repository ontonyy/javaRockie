package structural.flyweight.pen;

public class DemoMain {
    public static void main(String[] args) {
        Pen yellow = PenFactory.getThickPen("yellow");
        yellow.draw();

        Pen yellow2 = PenFactory.getThickPen("yellow");

        Pen yellow3 = PenFactory.getThickPen("yellow");

        Pen red = PenFactory.getThinPen("red");
        red.draw();

        System.out.printf("%s == %s\n",yellow.hashCode(), yellow2.hashCode());
        System.out.println(red.hashCode());
        System.out.println(yellow3.hashCode());
        System.out.println(PenFactory.getPens());
    }
}
