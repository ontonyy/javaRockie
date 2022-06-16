package creational.factory.phone;

public class PhoneMain {
    public static void main(String[] args) {
        AndroidFactory androidFactory = new AndroidFactory();
        Android android = (Android) androidFactory.createPhone();
        androidFactory.disposePhone();
        android.call();

        IphoneFactory iphoneFactory = new IphoneFactory();
        Iphone iphone = (Iphone) iphoneFactory.createPhone();
        iphoneFactory.disposePhone();
        iphone.call();
    }
}
