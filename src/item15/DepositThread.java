package item15;

public class DepositThread implements Runnable{

    Account account;

    DepositThread(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            account.deposit(1000);
        }
        account.inquiry();
    }
}