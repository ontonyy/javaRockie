package structural.flyweight.tree;

import java.awt.*;

public class TreeType {
    private String name, otherData, color;

    public TreeType(String name, String otherData, String color) {
        this.name = name;
        this.otherData = otherData;
        this.color = color;
    }

    public void draw() {
        System.out.println("Tree type drawing...");
    }
}
