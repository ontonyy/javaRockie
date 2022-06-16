package structural.proxy.bank;

public class CitiBank implements Bank {
    @Override
    public void setUserMoney(String user, double money) {
        System.out.println("Set user money");
        System.out.println(user + " have a lot of money: " + money);
    }

    @Override
    public double getUserMoney(String user) {
        System.out.println("Get user money!");
        return 0;
    }
}
