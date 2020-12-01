package com.hejx_javaCore.senior.thread.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 利用Lock锁解决线程安全
 *
 * 面试题：
 *      synchronized 与 Lock 的异同：
 * 相同点：二者都可以解决线程安全的问题
 *
 * 不同点：synchronized机制在执行完相应的同步代码后，自动的释放同步监视器
 *       Lock需要手动去启动同步与释放同步
 *
 *      如何解决线程安全，有几种方式？
 *      三种：synchronized代码块、synchronized方法、lock锁
 *
 *
 */

class Window implements Runnable{
    private int tick =30;
    //1.实例化ReentrantLock
    private  ReentrantLock lock=new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                //2.调用锁定的方法lock()
                lock.lock();
                if (tick > 0) {
                    System.out.println(Thread.currentThread().getName() + ": 售票,票号：" + tick);
                    tick--;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    break;
                }
            }finally{
                //3.调用解锁方法ulock()
                lock.unlock();
            }

        }
    }

}

public class LockTest {

    public static void main(String[] args) {
        Window w=new Window();
        Thread t1=new Thread(w);
        Thread t2=new Thread(w);
        Thread t3=new Thread(w);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}
