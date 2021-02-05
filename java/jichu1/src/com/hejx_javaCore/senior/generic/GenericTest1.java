package com.hejx_javaCore.senior.generic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname GenericTest1
 * @Description TODO
 * @Date 13:57 2021/1/25
 * @Created by hejx
 *
 * 如何自定义泛型结构：泛型类、泛型接口、泛型方法
 *
 * 1.关于自定义泛型类、泛型接口
 *   异常类不能是泛型
 *
 */

public class GenericTest1 {

    @Test
    public void test(){
    //如果定义了泛型类，实例化没有指明类的泛型，则认为此泛型为Object类型
    //要求：如果大家定义了类是带泛型的，建议在实例化时要指明类的泛型。
        Order order = new Order();

        order.setOrderT(123);
        order.setOrderT("ABC");

        //建议：实例化时指明类的泛型
        Order<String> order2 = new Order<>();
        order2.setOrderT("ABC");

        System.out.println(order2.getOrderT());

    }

    public void test2(){
        //由于子类在继承带泛型的父类时，指明了泛型类型。则实例化子类对象时，不再需要声明泛型
        SubOrder SubOrder=new SubOrder();
        SubOrder.setOrderT(123);

        SubOrder1<String> stringSubOrder1 = new SubOrder1<>();
        stringSubOrder1.setOrderT("String");

    }


    void test3(){
        //泛型不同的引用不能相互赋值
        ArrayList<String> list1=null;
        ArrayList<Integer> list2=null;


    }


    @Test
    public void test4(){
    Order<String> order=new Order<>();
    Integer[] arr=new Integer[]{1,2,3,4,5};
    //泛型方法在调用时，指明泛型参数的类型
     List<Integer> integers = order.copyFromArryToList(arr);

     for (Integer e:integers){
         System.out.println(e);
     }
    }


}
