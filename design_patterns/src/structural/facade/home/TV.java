package structural.facade.home;

public class TV extends BaseAppliance {

    public TV(String name) {
        super(name);
    }

    @Override
    public void act() {
        System.out.printf("[%s] act...", getName());
    }
}
