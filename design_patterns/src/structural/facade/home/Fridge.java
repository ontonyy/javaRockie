package structural.facade.home;

public class Fridge extends BaseAppliance {
    public Fridge(String name) {
        super(name);
    }

    @Override
    public void act() {
        System.out.printf("[%s] act...", getName());
    }
}
