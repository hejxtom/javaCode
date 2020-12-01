package com.hejx_javaCore.senior.thread;
/**
 * 创建多线程的方式二：实现Runnable接口
 *  1.创建一个实现Runnable接口的类
 *  2.实现类实现Runnable中的抽象方法：run()
 *  3.创建实现类对象
 *  4.将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
 *  5.通过Thread类的对象调用start():1.启动线程 2.调用当前线程的run()方法
 *
 *
 *
 */
class MThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++)
            if (i % 2 == 0)
                System.out.println(Thread.currentThread().getName() + ":" + i);
    }

}

public class ThreadTest1 {

    public static void main(String[] args) {
        MThread mThread=new MThread();
        Thread thread=new Thread(mThread);
        thread.start();

        //再启动一个线程，遍历100以内的偶数
        Thread t2=new Thread(mThread);
        t2.start();

    }

}
