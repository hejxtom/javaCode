package com.hejx_javaCore.senior.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义泛型类
 *
 * @Classname Order
 * @Description TODO
 * @Date 13:51 2021/1/25
 * @Created by hejx
 */

public class Order<T> {

    String orderName;
    int  orderId;

    //类的内部结构就可以使用泛型
    T orderT;

    public Order(){
        //编译不通过
        //T[] arr=new T[];

        T[] arr=(T[])new Object[10];

    }

    public Order(String orderName,int orderId,T orderT){
        this.orderName=orderName;
        this.orderId=orderId;
        this.orderT=orderT;

    }

    //泛型方法：在方法中出现泛型结构，泛型参数与类的泛型参数没有任何关系
    //换句话说，泛型方法所属的类是不是泛型类都没有关系
    //泛型方法，可以声明为静态的。原因：泛型参数是在调用方法时确定的。并非在实例化类时确定。
    public <E> List<E> copyFromArryToList(E[] arr){

        ArrayList<E>list =new ArrayList<>();
        for(E e:arr){
            list.add(e);
        }

      return list;
    }



    //如下方法不是泛型方法
    public T getOrderT() {
        return orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }


    //静态方法(静态结构)中不能使用类的泛型
   /* public static void show(T OrderT){
        System.out.println(OrderT);
    }*/

}
