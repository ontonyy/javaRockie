package patterns.Proxy;

public interface Bank {
    void setUserMoney(String user, double money);
    double getUserMoney(String user);
}
