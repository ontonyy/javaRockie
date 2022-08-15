package structural.decorator.notifier;

public class FacebookNotifier implements Notifier {
    @Override
    public void start() {
        System.out.println("Facebook notifier starts work");
    }

    @Override
    public String send(String message) {
        System.out.printf("Sending message: %s\n", message);;
        return message;
    }
}
