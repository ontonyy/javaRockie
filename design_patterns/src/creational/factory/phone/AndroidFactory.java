package creational.factory.phone;

public class AndroidFactory extends PhoneFactory {
    @Override
    public Phone createPhone() {
        return new Android();
    }
}
