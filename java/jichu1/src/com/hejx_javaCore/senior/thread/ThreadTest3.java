package com.hejx_javaCore.senior.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Classname ThreadTest3
 * @Description TODO
 * @Date 2020/9/12 16:40
 * @Created by hejx
 *
 * 创建线程三：实现Callable接口
 *
 * 如何理解实现Callable接口的方式创建多线程比实现Runable接口多线程方式强大？
 * 1.call()方法可以有返回值
 * 2.call()可以抛出异常，被外面的操作捕捉，获取异常信息
 * 3.Callable支持泛型的
 *
 *
 */

//1.创建一个实现Callable的实现类
class NumThread implements Callable<Integer>{
    private int sum;
    //2.实现call方法，将此线程的执行方法放到call()方法中
    @Override
    public Integer call() throws Exception {
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
                sum += i;
            }
        }
        //返回值类型要为Object的子类
        return sum;
    }
}


public class ThreadTest3 {
    public static void main(String[] args) {
        //3.创建Callable接口实现类的对象
        NumThread numThread = new NumThread();
        //4.将此Callable接口实现类的对象传递到FutureTask构造器中，创建FutureTask对象
        FutureTask futureTask = new FutureTask(numThread);
        //6.启动线程
        new Thread(futureTask).start();
        try {
            //5.获取call()返回值
            Integer sum = (Integer) futureTask.get();
            System.out.println("sum=" + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
