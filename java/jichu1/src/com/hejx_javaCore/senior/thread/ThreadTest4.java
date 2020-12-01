package com.hejx_javaCore.senior.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Classname ThreadTest4
 * @Description TODO
 * @Date 2020/9/13 9:59
 * @Created by hejx
 *
 *
 * 创建多线程的方式四：使用线程池
 * 好处：
 * 1.提高响应速度(减少了创建线程的时间)
 * 2.降低资源消耗(重复利用线程池中的线程，不需要每次都创建)
 * 3.便于管理
 *
 *
 *
 *面试题：创建多线程有几种方式？ 四种
 */

class NumberThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName()+": "+i);
            }
        }
    }
}

class NumberThread1 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName()+": "+i);
            }
        }
    }
}

public class ThreadTest4 {
    public static void main(String[] args) {
        //1.提供指定线程数量的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);
       //2.执行指定的线程的操作。需要提供实现Runable接口或Callable接口实现类的对象
        executorService.execute(new NumberThread());
        executorService.execute(new NumberThread1());
    //executorService.submit(numThread)
    //3.关闭连接池
      executorService.shutdown();
}


}
