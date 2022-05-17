package patterns.Factory.OsFactory;

public class OSShop {
    private final OSFactory osFactory;

    public OSShop(OSFactory osFactory) {
        this.osFactory = osFactory;
    }

    public OS buyOS(OSType type) {
        OS os = osFactory.createOS(type);

        if (os != null) {
            os.startOS();
            os.actInOS();
            os.endOS();
        }

        System.out.println("Your OS succesfully work!");
        return os;
    }

}
