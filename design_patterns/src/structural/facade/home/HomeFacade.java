package structural.facade.home;

public class HomeFacade {
    private Hoover hoover;
    private TV tv;
    private Fridge fridge;

    public HomeFacade(Hoover hoover, TV tv, Fridge fridge) {
        this.hoover = hoover;
        this.tv = tv;
        this.fridge = fridge;
    }

    public void stopAppliance(String name) {
        BaseAppliance appliance = switch (name) {
            case "tv" -> tv;
            case "hoover" -> hoover;
            default -> fridge;
        };
        appliance.stop();
    }

    public void startAppliance(String name) {
        BaseAppliance appliance = switch (name) {
            case "tv" -> tv;
            case "hoover" -> hoover;
            default -> fridge;
        };
        appliance.start();
        appliance.act();
    }

    public void showTV() {
        tv.start();
        tv.act();
    }

    public void stopTV() {
        tv.stop();
    }

    public void openFridge() {
        fridge.start();
        fridge.act();
    }

    public void closeFridge() {
        fridge.stop();
    }

    public void actHoover() {
        hoover.start();
        hoover.act();
    }

    public void stopHoover() {
        hoover.stop();
    }
}
