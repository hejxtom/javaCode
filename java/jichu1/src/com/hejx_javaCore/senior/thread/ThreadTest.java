package com.hejx_javaCore.senior.thread;

/**
 * 多线程的创建，方式一：继承Thread类
 *   1.创建一个继承于Thread类的子类
 *   2.重写Thread类的run()
 *   3.创建Thread类的子类的对象
 *   4.通过此对象调用start()
 *
 * 比较创建线程的两种方式：
 *   开发中：优先选择实现Runnable接口的方式
 *   原因：1.实现的方式没有类的单继承的局限性
 *        2.实现的方式更适合来处理多个线程共享数据的情况
 *   相同点：两种方式都需要重写run(),将线程要执行的逻辑声明在run()中
 */

class MyThread extends Thread{

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++)
            if (i % 2 == 0)
                System.out.println(Thread.currentThread().getName() + ":" + i);
    }

}


public class ThreadTest {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        //通过此对象调用start():1.启动当前线程;2.调用当前线程的run()
        //不可以让已经start的线程再去执行start()方法，否则会报错
        myThread.start();
        System.out.println("hello");

        //创建Thread类的匿名子类匿名对象的方式
        new Thread() {
            @Override
            public void run() {
                for (int i = 1; i <= 100; i++) {
                    if (i % 2 != 0) System.out.println(Thread.currentThread().getName() + ":" + i);
                }
            }
        }.start();

    }
}
