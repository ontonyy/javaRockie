package patterns.Factory.OsFactory;

public class OSFactory {

    public OS createOS(OSType type) {
        OS os = null;

        switch (type) {
            case LINUX -> os = new Linux();
            case MACOS ->  os = new MacOS();
            case WINDOWS ->  os = new Windows();
        }

        return os;
    }
}
