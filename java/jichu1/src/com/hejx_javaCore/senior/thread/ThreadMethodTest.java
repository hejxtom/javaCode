package com.hejx_javaCore.senior.thread;
/**
 * Thread中的常用方法：
 *   1.start():启动当前线程;调用当前线程的run()
 *   2.run():通常需要重写Thread类中的方法，将创建的线程要执行的操作声明在此方法中
 *   3.currentThread():静态方法，返回当前代码执行的线程
 *   4.getName():获取当前线程的名字
 *   5.setName():设置当前线程的名字(设置当前线程的名字另一种方法：利用构造器)
 *   6.yield():释放当前cpu的执行权
 *   7.join():在线程a中调用线程b的join(),此时线程a就进入阻塞状态，直到线程b完全执行以后，线程a才结束阻塞状态
 *   8.sleep(long millis):让当前线程"睡眠"指定的millis毫秒。在指定的millis毫秒时间内，当前线程是阻塞状态
 *   9.isAlive():判断当前线程是否存活
 */

class HelloThread extends Thread{
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                //  Thread.currentThread().setName(String.valueOf(i));
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
            if (i % 20 == 0) {
                // this.yield();
                yield();
                try {
                    sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public HelloThread(){}
    //利用构造器，设置当前线程的名字
    public HelloThread(String name){
        super(name);
    }

}

public class ThreadMethodTest {
    public static void main(String[] args) {
        HelloThread helloThread = new HelloThread();
        helloThread.start();
        helloThread.setName("线程一");

        HelloThread h1 = new HelloThread("线程二");
        h1.start();

        //给主线程设置名字
        Thread.currentThread().setName("主线程");
        //给主线程设置默认权限+1
        Thread.currentThread().setPriority(Thread.NORM_PRIORITY+1);
        for (int i = 1; i <= 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + "," + Thread.currentThread().getPriority() + ":" + i);
            }
            if (i == 3) {
                try {
                        h1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println(h1.isAlive());
    }
}
/**
 *  MIN_PRIORITY = 1
 *  NORM_PRIORITY = 5
 *  MAX_PRIORITY = 10
 *  setPriority(int p):设置当前线程的优先级
 *  getPriority():获取线程的优先级
 */