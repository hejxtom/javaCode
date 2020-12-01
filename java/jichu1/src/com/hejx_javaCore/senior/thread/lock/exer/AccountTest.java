package com.hejx_javaCore.senior.thread.lock.exer;
/**
 * 银行有一个账户。两个储户分别向同一账户存3000元,每此存1000，分别存三次.每次存完打印账户余额
 *
 *
 *
 *
 */

class Account{
    public double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public synchronized void deposit(double amt) {
        if (amt > 0) {
            balance += amt;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":存钱成功。余额为：" + balance);
        }
    }
}

class Customer extends Thread{

    private Account account;

    public Customer(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            account.deposit(1000);
        }
    }
}

public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account(0);
        Customer c1 = new Customer(account);
        Customer c2 = new Customer(account);

        c1.setName("甲");
        c2.setName("乙");

        c1.start();
        c2.start();

    }

}
