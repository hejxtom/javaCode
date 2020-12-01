package com.hejx_javaCore.jichu.mxdxOop.wrap;

import org.junit.Test;

/**
 * 包装类
 *
 *
 */
public class mxdx_oop_wrap {
    @Test
    public void test(){
        int num=10;
        System.out.println("****基本数据类型--->包装类****");
        //基本数据类型--->包装类：调用包装类的构造器
        Integer integer=new Integer(num);
        System.out.println(integer.toString()+1);
        System.out.println(integer+1);

        System.out.println("****包装类--->基本数据类型****");
        //包装类--->基本数据类型:调用包装类的xxxValue()方法
        System.out.println(integer.intValue()+1);


        Integer integer1=new Integer("123");
        System.out.println(integer1.intValue());
        System.out.println(integer1);
    }

    /**
     * 自动装箱与自动拆箱（jdk1.5新特性）
     *
     *
     *
     */
    @Test
    public void test1() {
        int n = 10;
        boolean boo = false;
        //自动装箱：省略了 基本数据类型-->包装类 的过程
        method(n);
        Integer n1 = n;

        //自动拆箱:省略了 包装类-->基本数据类型 的过程
        int n2 = n1;

    }

    public static void method(Object obj) {
        //自动拆箱:省略了 包装类-->基本数据类型 的过程
        System.out.println(obj);
    }

    /**
     * 基本数据类型、包装类与String类型之间转换
     *
     *
     */

    @Test
    public void test2() {
        //基本数据类型、包装类--->String类型:调用String重载的valueOf(Xxx)方法
        int num = 10;
        Integer num1 = num;
        String str = String.valueOf(num);
        System.out.println(str);
        String str1 = String.valueOf(num1);
        System.out.println(str1);

        //String类型--->基本数据类型、包装类:调用包装类.parseInt(String)
         String str2="456";
         int num3=Integer.parseInt(str2);
         Integer num4=new Integer(str2);
         System.out.println("num3:"+num3+" num4:"+num4);

    }


    /**
     *关于包装类的面试题
     *
     *
     */
    @Test
    public void test3() {
        Object ob1 = true ? new Integer(1) : new Double(2.0);
        System.out.println(ob1);

        Object ob2;
        if (true)
            ob2 = new Integer(1);
        else
            ob2 = new Double(2.0);
        System.out.println(ob2);

       Integer i=new Integer(1);
       Integer j=new Integer(1);
       System.out.println(i==j);  //包装类，比较的是地址值，结果：false

       Integer m=1;
       Integer n=1;
       System.out.println(m==n); //自动拆箱变成基本数据类型，比较的是值，结果：true

       Integer x=128;
       Integer y=128;
       System.out.println(x==y);//由于128>IntegerCache.cache[(high - low)],所以会new Integer(128),结果：false
    }




}
