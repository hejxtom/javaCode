package com.hejx_javaCore.senior.commonclass.time;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * jdk8 之前的日期时间API测试
 * SimpleDateFormat
 * Calender
 *
 * @Classname DateTimeTest1
 * @Description TODO
 * @Date 2020/9/22 12:50
 * @Created by hejx
 *
 *
 */
public class DateTimeTest1 {
    /**
     * Calendar:日历类
     *
     */
    @Test
    public void test2(){
        /**
         * 1.实例化
         * 方式一： 创建其子类的对象
         * 方式二： 调用其静态方法getInstance()
         *
         *
         */
        Calendar calendar=Calendar.getInstance();
       // System.out.println(calendar.getClass());  //class java.util.GregorianCalendar
        //get()
        int i = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(i);
        //System.out.println(Calendar.DAY_OF_WEEK);

        //set()
        calendar.set(Calendar.DAY_OF_MONTH,22);
        i = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(i);
        //add()
        calendar.add(Calendar.DAY_OF_MONTH,3);
        i = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(i);
        //getTime()：日历类 --->Date
        Date date=calendar.getTime();
        System.out.println(date);
        //setTime()：Date --> 日历类
        Date date1=new Date();
        calendar.setTime(date1);
        i = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(i);

    }


    /**
     * SimpleDateFormat对日期Date类的格式化和解析
     *
     *
     *
     */
    @Test
     public void test1(){
         //实例化SimpleDateFormat:使用默认的构造器
        SimpleDateFormat sdf=new SimpleDateFormat();
        //格式化：日期-->字符串
        Date date=new Date();
        System.out.println(date);
        String format=sdf.format(date);
        System.out.println(format);


        //解析：格式化的逆过程，字符串 -->日期
        String str="20-9-22 下午1:16";
        Date date1= null;
        try {
            date1 = sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date1);

        //实例化SimpleDateFormat:调用
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 EEE aaa HH:mm:ss");
        String format1=simpleDateFormat.format(date);
        System.out.println(format1);

    }

}
