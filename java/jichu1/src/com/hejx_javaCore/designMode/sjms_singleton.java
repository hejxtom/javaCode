package com.hejx_javaCore.designMode;

/**
 * 单例设计模式：
 *      就是采用一定的方法保证在整个软件系统中，对某个类只会存在一个对象实例
 *      优点：减少系统的开销
 * 如何实现？
 *     1.饿汉式：
 *           好处：饿汉式是线程安全的
 *           坏处：对象加载时间长
 *     2.懒汉式:
 *           好处：延迟对象的创建
 *
 *应用场景：(需要同步,连接第三方程序或软件)
 *   读取配置、产生其他依赖对象
 *   网站的计数器
 *   应用程序的日志应用
 *   数据库连接池
 *
 */
public class sjms_singleton {

    public static void main(String[] args) {
        System.out.println("******饿汉式******");
        Bank bank = Bank.getBank();
        Bank bank_1 = Bank.getBank();

        System.out.println(bank == bank_1);

        bank.setAccount("Tom");
        bank.setAmount(200);
        System.out.println(bank.getAccount() + "," + bank.getAmount());

        System.out.println("******懒汉式******");
        Bank1 bank1 = Bank1.getBank();
        Bank1 bank11 = Bank1.getBank();
        System.out.println(bank1 == bank11);

    }

}

//饿汉式
class Bank {

    private String account;
    private int amount;
    //2.内部创建私有化类的对象，要求此对象也必须声明为静态的
    private static Bank bank = new Bank();

    //1.私有化类的构造器
    private Bank() {

    }

    //3.创建返回类对象的方法
    public static Bank getBank() {

        return bank;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}

//懒汉式(线程不安全)
class Bank1 {
    //1.私有化类的构造器
    private Bank1() {

    }

    //2.内部创建私有化类的对象，要求此对象也必须声明为静态的
    private static Bank1 bank1;

    //3.创建返回类对象的方法
    public static Bank1 getBank() {
        if (bank1 == null)
            bank1 = new Bank1();
        return bank1;
    }

}

//懒汉式2 (线程安全)
class Bank12 {
    //1.私有化类的构造器
    private Bank12() {

    }

    //2.内部创建私有化类的对象，要求此对象也必须声明为静态的
    private static Bank12 bank12;

    //3.创建返回类对象的方法
   /* public static synchronized Bank12 getBank() {
        if (bank12 == null)
            bank12 = new Bank12();
        return bank12;
    }*/
    public static Bank12 getBank() {
        synchronized (Bank12.class) {
            if (bank12 == null)
                bank12 = new Bank12();
            return bank12;
        }
    }
}