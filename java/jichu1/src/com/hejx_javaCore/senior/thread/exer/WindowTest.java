package com.hejx_javaCore.senior.thread.exer;
/**
 *  例子：创建三个窗口卖票，总票数为100张,使用继承Thread类的方式
 *
 *
 */

class Window extends Thread{

    private static int ticket = 100;
    private static Object object=new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (Window.class){
                if (ticket > 0) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(getName() + ":买票，票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}

public class WindowTest {

    public static void main(String[] args) {
         Window w1=new Window();
         Window w2=new Window();
         Window w3=new Window();
         w1.setName("窗口一");
         w2.setName("窗口二");
         w3.setName("窗口三");

         w1.start();
         w2.start();
         w3.start();
    }
}

/**
 *  例子：创建三个窗口卖票，总票数为100张,使用实现Runnable接口的方式
 *  线程安全问题，出现的原因：1. 当某个线程操作共享数据(多个线程共同操作的变量)的过程中，尚未操作完成时，其他线程参与进来，也操作车共享数据
 *                   解决：通过同步机制：
 *                        1.同步代码块
 *                           synchronized(同步监视器){
 *                           //需要同步的代码(操作共享数据的代码，即为需要被同步的代码)
 *                           }
 *                           说明：同步监视器，俗称：锁。任何一个类的对象都可以充当锁
 *                                 要求：多个线程必须共用同一把锁。可以考虑this(慎用)\类.class\对象名 充当锁
 *                        2.同步方法
 *
 */

class Windows implements Runnable{
    private int ticket = 100;
    Object obj=new Object();
    @Override
    public void run() {
            while (true) {
                /**
                 *
                 * 同步方法的锁：静态方法（类名.class）、非静态方法（this）
                 *
                 */
                //同步代码块
                synchronized (this) {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + ":买票，票号为：" + ticket);
                    ticket--;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                  }
                }
            }
    }
}

class WindowTest2{
    public static void main(String[] args) {
         Windows windows=new Windows();
         Thread t1=new Thread(windows,"线程一");
         Thread t2=new Thread(windows,"线程二");
         Thread t3=new Thread(windows,"线程三");

         t1.start();
         t2.start();
         t3.start();
    }
}

/**
 * 实现Runnable接口:
 *   使用同步方法解决
 *
 *
 *
 *
 */
class Window3 implements Runnable{
    private int ticket = 100;
    private  boolean isFalse=true;
    @Override
    public void run() {
        while (isFalse) {
            show();
        }
    }

    private synchronized void show() {
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + ":买票，票号为：" + ticket);
            ticket--;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            isFalse=false;
        }
    }
}

class WindowTest3{
    public static void main(String[] args) {
        Window3 w3=new Window3();
        Thread t1=new Thread(w3);
        Thread t2=new Thread(w3);
        Thread t3=new Thread(w3);

        t1.setName("窗口1：");
        t2.setName("窗口2：");
        t3.setName("窗口3：");
        t1.start();
        t2.start();
        t3.start();
    }
}

/**
 * 继承Thread类:
 *   使用同步方法解决
 *
 *
 *
 *
 */
class Window4 extends Thread{
    private static int ticket = 100;
    private static boolean isFalse=true;
    @Override
    public void run() {
        while (isFalse) {
          show();
        }
    }

    private static synchronized void show(){
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + ":买票，票号为：" + ticket);
            ticket--;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            isFalse=false;
        }
    }

}

class WindowTest4 {
    public static void main(String[] args) {
        Window4 w1=new Window4();
        Window4 w2=new Window4();
        Window4 w3=new Window4();
        w1.setName("窗口一");
        w2.setName("窗口二");
        w3.setName("窗口三");

        w1.start();
        w2.start();
        w3.start();
    }
}