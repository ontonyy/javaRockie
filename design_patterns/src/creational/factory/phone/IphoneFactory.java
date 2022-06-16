package creational.factory.phone;

public class IphoneFactory extends PhoneFactory {
    @Override
    public Phone createPhone() {
        return new Iphone();
    }
}
