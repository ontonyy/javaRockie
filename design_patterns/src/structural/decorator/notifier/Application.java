package structural.decorator.notifier;

public class Application {
    public static void main(String[] args) {
        FacebookNotifier facebookNotifier = new FacebookNotifier();
        BaseDecorator decorator = new BaseDecorator(facebookNotifier);
        decorator.send("Halo!!!");

    }
}
