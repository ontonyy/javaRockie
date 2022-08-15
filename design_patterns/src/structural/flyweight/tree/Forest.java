package structural.flyweight.tree;

import java.util.LinkedList;
import java.util.List;

public class Forest {
    private List<Tree> trees = new LinkedList<>();

    public void addTree(int x, int y, String name, String color, String otherData) {
        TreeType type = TreeFactory.getTreeType(name, color, otherData);
        Tree tree = new Tree(x, y, type);
        trees.add(tree);
    }

    public void draw() {
        for (Tree tree : trees) {
            tree.draw();
        }
    }
}
