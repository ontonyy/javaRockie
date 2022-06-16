package creational.prototype.drinks;

import java.util.Objects;

public class WaterBottle extends DrinkBottle {
    private String taste;

    public WaterBottle() {
    }

    public WaterBottle(WaterBottle bottle) {
        super(bottle);
        if (bottle != null) {
            this.taste = bottle.taste;
        }
    }

    @Override
    public DrinkBottle clone() {
        return new WaterBottle(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        WaterBottle that = (WaterBottle) o;
        return Objects.equals(taste, that.taste);
    }
}
