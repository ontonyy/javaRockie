package structural.facade.home;

public class Hoover extends BaseAppliance {
    private boolean work = false;

    public Hoover(String name) {
        super(name);
    }

    @Override
    public void act() {
        System.out.printf("[%s] act...", getName());
    }
}
