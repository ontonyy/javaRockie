package structural.decorator.notifier;

public class SmsNotifier implements Notifier {
    @Override
    public void start() {
        System.out.println("SMS notifier starts work.");
    }

    @Override
    public String send(String message) {
        System.out.printf("Sending message: %s\n", message);
        return message;
    }
}
