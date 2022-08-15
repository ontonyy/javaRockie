package structural.proxy.bank;

public class SecurityProxyBank implements Bank {
    private Bank bank;

    public SecurityProxyBank(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void setUserMoney(String user, double money) {
        if (user.equals("")) {
            System.out.println("User is not authorized!");
        } else {
            bank.setUserMoney(user, money);
        }
    }

    @Override
    public double getUserMoney(String user) {
        if (user.equals("")) {
            System.out.println("User is not authorized!");
        } else {
            return bank.getUserMoney(user);
        }
        return 0;
    }
}
