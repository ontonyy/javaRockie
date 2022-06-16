package creational.prototype.drinks;

public abstract class DrinkBottle {
    public int liters;

    public DrinkBottle() {
    }

    public DrinkBottle(DrinkBottle bottle) {
        if (bottle != null) {
            this.liters = bottle.liters;
        }
    }

    public abstract DrinkBottle clone();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DrinkBottle that = (DrinkBottle) o;
        return liters == that.liters;
    }
}
