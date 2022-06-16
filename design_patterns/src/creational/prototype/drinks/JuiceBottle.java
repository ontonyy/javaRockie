package creational.prototype.drinks;

public class JuiceBottle extends DrinkBottle {
    public int sugarAmount;

    public JuiceBottle() {
    }

    public JuiceBottle(JuiceBottle bottle) {
        super(bottle);
        if (bottle != null) {
            this.sugarAmount = bottle.sugarAmount;
        }
    }

    @Override
    public DrinkBottle clone() {
        return new JuiceBottle(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        JuiceBottle that = (JuiceBottle) o;
        return sugarAmount == that.sugarAmount;
    }
}
