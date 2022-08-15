package structural.flyweight.computer;

import java.util.LinkedHashMap;
import java.util.Map;

public class ScreenFactory {
    private static Map<String, Screen> screens = new LinkedHashMap<>();

    public static Screen getScreen(String type, int hz) {
        Screen result = screens.get(type);
        if (result == null) {
            result = new Screen(type, hz);
            screens.put(type, result);
        }
        return result;
    }
}
