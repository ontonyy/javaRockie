package structural.flyweight.tree;

import java.awt.*;

public class Tree {
    private int x, y;
    private TreeType type;

    public Tree(int x, int y, TreeType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void draw() {
        System.out.println("Draw in pos: " + x + " - " + y);
        type.draw();
    }
}
