package tries;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;

public class Attempts {
    public static void main(String[] args) {
        Set<String> cars = new TreeSet<String>();
        cars.add("Audi");
        cars.add("MB");
        cars.add("BMW");
        cars.add("Audi");
        cars.add("Tesla");
        System.out.print(cars);
        System.out.println();
    }
}