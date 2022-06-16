package creational.builder.building.components;

public class HouseGarage {
    private int amountOfCars;
    private boolean open = false;

    public HouseGarage(int amountOfCars) {
        this.amountOfCars = amountOfCars;
    }

    public void openOrLock() {
        if (open) {
            System.out.println("Garage locking...");
            open = false;
        } else {
            System.out.println("Garage opening...");
            open = true;
        }
    }

    @Override
    public String toString() {
        return "HouseGarage{" +
                "amountOfCars=" + amountOfCars +
                ", open=" + open +
                '}';
    }
}
