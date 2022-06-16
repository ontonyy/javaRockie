package structural.proxy.bank;

public interface Bank {
    void setUserMoney(String user, double money);
    double getUserMoney(String user);
}
