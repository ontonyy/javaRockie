package patterns.Singleton;

public class Singleton {
    public static void main(String[] args) {

    }
}

class SimpleSingleton {
    private static final SimpleSingleton INSTANCE = new SimpleSingleton();

    private SimpleSingleton() {
    }

    public static SimpleSingleton getInstance() {
        return INSTANCE;
    }
}

class LazySingleton {
    private static LazySingleton INSTANCE;

    private LazySingleton() {
    }

    public static LazySingleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LazySingleton();
        }
        return INSTANCE;
    }
}

class SyncronizedSingleton {
    private static SyncronizedSingleton INSTANCE;

    private SyncronizedSingleton() {
    }

    public static synchronized SyncronizedSingleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SyncronizedSingleton();
        }
        return INSTANCE;
    }
}

class DoubleCheckedSingleton {
    private static DoubleCheckedSingleton INSTANCE;

    public DoubleCheckedSingleton() {
    }

    public static DoubleCheckedSingleton getInstance() {
        if (INSTANCE == null) {
            synchronized (DoubleCheckedSingleton.class) {
                if (INSTANCE == null);
                INSTANCE = new DoubleCheckedSingleton();
            }
        }
        return INSTANCE;
    }
}

class ClassHolderSingleton {

    public ClassHolderSingleton() {
    }

    private static class SingletonHolder {
        public static final ClassHolderSingleton HOLDER_INSTANCE = new ClassHolderSingleton();
    }

    public static ClassHolderSingleton getInstance() {
        return SingletonHolder.HOLDER_INSTANCE;
    }
}
