package creational.factory.phone;

public abstract class PhoneFactory {
    public void disposePhone() {
        Phone phone = createPhone();
        phone.dispose();
    }

    public abstract Phone createPhone();
}
