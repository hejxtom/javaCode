package com.hejx_javaCore.senior.commonclass.time;

import org.junit.Test;

import java.util.Date;

/**
 * jdk8 之前日期和时间的API测试
 * System类的currentTimeMillis()
 * java.sql.Date与java.util.Date
 *
 *
 * @Classname DateTimeTest
 * @Description TODO
 * @Date 2020/9/18 15:20
 * @Created by hejx
 */
public class DateTimeTest {
    /**
     * java.util.Date类
     *        |--java.sql.Date类
     *
     * 1.两个构造器的使用
     * 2.两个方法的使用
     */
    @Test
    public void test2(){
        Date date = new Date();
        System.out.println(date);

        //getTime():返回自1970年1月1日以来，由此 Date对象表示的00:00:00 GMT的毫秒 数 。
        long time = date.getTime();
        System.out.println(time);

        Date date1 = new Date(1600414795370L);
        System.out.println(date1);
        //如何将java.sql.Date对象转换成java.util.Date对象
        java.sql.Date date2=new java.sql.Date(1600414816532L);
        System.out.println(date2);
        Date date3=(Date)date2;
        System.out.println(date3);
        //如何将java.util.Date对象转换成java.sql.Date对象
        Date date4=new Date();
        java.sql.Date date5=new java.sql.Date(date4.getTime());
    }

    @Test
    public void test1(){
        long l = System.currentTimeMillis();
        /**
         * 返回当前时间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差
         *称为时间戳
         *
         */
        System.out.println(l);

    }

}
