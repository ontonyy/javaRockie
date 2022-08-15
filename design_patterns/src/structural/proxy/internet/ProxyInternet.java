package structural.proxy.internet;

import java.util.LinkedList;
import java.util.List;

public class ProxyInternet implements Internet {
    private Internet internet;
    private static List<String> bannedSites = new LinkedList<>();

    static {
        bannedSites.add("mail.ru");
        bannedSites.add("url.com");
        bannedSites.add("ru.com");
        bannedSites.add("facebook.com");
    }

    @Override
    public void connectTo(String link) {
        if (!bannedSites.contains(link)) {
            internet.connectTo(link);
        } else {
            System.out.println("This site is banned.");
        }
    }
}
