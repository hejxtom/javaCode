package com.hejx_javaCore.senior.thread.communication.exer;
/**
 *
 *
 *
 *
 * @author hejx
 * @create 2020-9-12 15：46
 */

class Clerk {

    private int productCount=0;
    //生产产品
    public synchronized void produceProduct() {
        if (productCount < 20) {
            productCount++;
            System.out.println(Thread.currentThread().getName() + ":开始生产第" + productCount + "个产品");
            notify();
        }else{
            //等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
    //消费产品
    public synchronized void consumerProduct() {
        if(productCount>0){
            System.out.println(Thread.currentThread().getName()+":开始消费第"+productCount+"个产品");
            productCount--;
            notify();
        }else {
            //等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer extends Thread {

    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
         System.out.println(getName()+":开始生产产品.....");
         while(true){
             try {
                 Thread.sleep(20);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
             clerk.produceProduct();

         }
    }
}

class Consumer extends Thread {
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName()+":开始消费产品.....");
        while(true){
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consumerProduct();

        }
    }
}

public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer p1 = new Producer(clerk);
        Consumer c1=new Consumer(clerk);
        Consumer c2=new Consumer(clerk);
        c1.setName("消费者线程1");
        c2.setName("消费者线程2");
        p1.setName("生产者线程1");
        c1.start();
        c2.start();
        p1.start();

    }


}
