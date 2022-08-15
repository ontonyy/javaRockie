package structural.flyweight.tree;

import java.util.LinkedHashMap;
import java.util.Map;

public class TreeFactory {
    private static Map<String, TreeType> typeMap = new LinkedHashMap<>();

    public static TreeType getTreeType(String name, String otherData, String color) {
        TreeType type = typeMap.get(name);
        if (type == null) {
            type = new TreeType(name, otherData, color);
            typeMap.put(name, type);
        }
        return type;

    }
}
