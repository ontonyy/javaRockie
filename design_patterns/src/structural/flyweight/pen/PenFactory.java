package structural.flyweight.pen;

import java.util.LinkedHashMap;
import java.util.Map;

public class PenFactory {
    private static Map<String, Pen> pens = new LinkedHashMap<>();

    public static ThickPen getThickPen(String color) {
        String key = color + " - Thick";
        Pen pen = pens.get(color);
        if (pen == null) {
            pen = new ThickPen(color);
            pens.put(key, new ThickPen(color));
        }
        return (ThickPen) pen;
    }

    public static ThinPen getThinPen(String color) {
        String key = color + " - Thin";
        Pen pen = pens.get(color);
        if (pen == null) {
            pen = new ThinPen(color);
            pens.put(key, new ThinPen(color));
        }
        return (ThinPen) pen;
    }

    public static Map<String, Pen> getPens() {
        return pens;
    }
}
