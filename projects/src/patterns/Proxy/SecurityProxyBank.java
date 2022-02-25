package patterns.Proxy;

import javax.naming.NameNotFoundException;

public class SecurityProxyBank implements Bank {
    private Bank bank;

    public SecurityProxyBank(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void setUserMoney(String user, double money) {
        System.out.println("User is authorized?");
        if (user.equals("")) {
            System.out.println("User is not authorized!");
        } else {
            System.out.println("All is good, money was set");
        }
    }

    @Override
    public double getUserMoney(String user) {
        if (user.equals("")) {
            System.out.println("User is not authorized!");
        } else {
            System.out.println("All is good, user have: user.money");
        }
        return 0;
    }
}
