package com.hejx_javaCore.senior.commonclass.time;

import org.junit.Test;

import java.time.*;
import java.util.Date;

/**
 * JDK8 新增日期API
 *
 *
 * @Classname DateTimeTest2
 * @Description TODO
 * @Date 2020/9/24 8:31
 * @Created by hejx
 */
public class DateTimeTest2 {

 /**
  *  Instant的使用
  *
  *
  *
  */
    @Test
    public void test2(){
        //now():获取本初子午线对应的标准时间
        Instant instant=Instant.now();
        System.out.println(instant);  //2020-09-24T01:51:31.432Z

        //添加时间的偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        //toEpochMilli(): 获取自1970年1月1日0时0分0秒开始的毫秒数
        long l = instant.toEpochMilli();
        System.out.println(l);
        
        //ofEpochMilli():解析
        Instant instant1 = Instant.ofEpochMilli(1600912868524L);
        System.out.println(instant1);
    }


    /**
     *  LocalDate\LocalDateTime\LocalTime 的使用
     *  说明：
     *   LocalDateTime 相较于LocalDate、LocalTime，使用频率要高
     *
     */
    @Test
    public void test1(){
        LocalDate date=LocalDate.now();
        System.out.println(date);    //2020-09-24
        LocalTime time= LocalTime.now();
        System.out.println(time);  //08:56:41.250

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);  //2020-09-24T08:57:35.454

        //of():设置指定的年月日时分秒。没有偏移量
        LocalDateTime of = LocalDateTime.of(2020, 10, 6, 13, 23, 23);
        System.out.println(of);

        System.out.println("........getXxx....");
        //getXxx()
        System.out.println(now.getDayOfYear());
        System.out.println(now.getDayOfMonth());
        System.out.println(now.getDayOfWeek());
        System.out.println(now.getYear());
        System.out.println(now.getMonth());
        System.out.println(now.getHour());
        System.out.println(now.getMinute());

        System.out.println("withXxxOfXxx...");
        //体现不可变性
        //相当于设置相关的属性
        LocalDateTime localDateTime = now.withDayOfMonth(25);
        System.out.println(localDateTime);

        System.out.println("plusXxx...");
        //相当于加
        LocalDateTime localDateTime1 = localDateTime.plusDays(3);
        System.out.println(localDateTime1);


        System.out.println("minusXxx...");
        //相当于减
        LocalDateTime localDateTime2 = localDateTime.minusDays(3);
        System.out.println(localDateTime);
        System.out.println(localDateTime2);

    }

    @Test
    public void testDateTime(){
        //偏移量问题
        Date date=new Date(2020-1900,9-1,8);
        System.out.println(date);
    }

}
