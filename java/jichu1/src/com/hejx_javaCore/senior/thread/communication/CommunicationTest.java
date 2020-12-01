package com.hejx_javaCore.senior.thread.communication;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程的通信
 * 涉及的三个方法：
 *  wait():一旦执行此方法，当前线程就会进入阻塞状态，并释放同步监视器
 *  notify():一旦执行此方法，就会唤醒被wait的一个线程。如果有多个线程被wait,就唤醒优先级较高的线程
 *  notifyAll():一旦执行此方法，就会唤醒所有被wait的线程
 *
 * 说明：
 *  1.wait(),notify(),notifyAll()三个方法必须使用在同步代码块或同步方法中
 *  2.wait(),notify(),notifyAll()三个方法定义在Object类中
 *
 *
 * 面试题：
 *  sleep()和wait()异同：
 *  相同点：都可以让当前线程进入阻塞状态
 *  不同点：
 *       1.两个方法声明的位置不同：Thread类中声明sleep(),Object类中声明wait()
 *       2.调用的要求不同：sleep()可以在任何需要的场景下调用。wait()必须使用在同步代码或同步方法中
 *       3.关于是否释放同步监视器：如果两个方法都使用同步代码块或同步方法中，sleep()不会释放锁(同步监视器)，wait()会释放锁(同步监视器)
 *
 */

class Number implements Runnable{

    private int number=1;
    private ReentrantLock lock=new ReentrantLock();

    @Override
    public void run() {
        while (true){
            synchronized (Number.class) {
                //默认this.notify()
                Number.class.notify();
                if (number <= 100) {
                    System.out.println(Thread.currentThread().getName() + ":" + number);
                        number++;
                        try {
                            /**
                             * 默认this.wait(),由于Thread.currentThread()会替代Number.class,会报IllegalMonitorStateException异常
                             * 所以当锁为Number.class，必须写全Number.class.wait();
                             *
                             *
                             * wait()方法只能用在同步方法或者同步代码块里面
                             */
                            Number.class.wait();
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



public class CommunicationTest {
    public static void main(String[] args) {
        Number number=new Number();
        Thread t1=new Thread(number);
        Thread t2=new Thread(number);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();

    }
}
