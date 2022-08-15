package structural.facade.home;

public abstract class BaseAppliance implements Appliance {
    private boolean work = false;
    private String name;

    public BaseAppliance(String name) {
        this.name = name;
    }

    @Override
    public void start() {
        if (work) {
            System.out.printf("[%s] - Already work...\n", name);
        } else {
            work = true;
            System.out.printf("[%s] start work\n", name);
        }
    }

    @Override
    public void stop() {
        if (!work) {
            System.out.printf("[%s] - Already stop working...\n", name);
        } else {
            work = false;
            System.out.printf("[%s] stop work\n", name);
        }

    }

    public String getName() {
        return name;
    }

    public abstract void act();
}
