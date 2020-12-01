package com.hejx_javaCore.senior.commonclass.time;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

/**
 * DateTimeFormatter:格式化或解析日期、时间
 * @Classname DateTimeTest3
 * @Description TODO
 * @Date 2020/9/28 21:45
 * @Created by hejx
 */
public class DateTimeTest3 {
  /**
   * 方式一： 预定义的标准格式
   *
   * 方式二： 本地化相关的格式
   *
   * 方法三： 自定义的格式。
   *
   */
  @Test
  public void test1(){
      //方式一： 预定义的标准格式
      DateTimeFormatter  formatter=DateTimeFormatter.ISO_LOCAL_DATE_TIME;
      //格式化：日期 --> 字符串
      LocalDateTime localDateTime=LocalDateTime.now();
      String format = formatter.format(localDateTime);
      System.out.println(localDateTime);
      System.out.println(format);

      //解析： 字符串 -->日期
      TemporalAccessor parse = formatter.parse("2020-09-28T21:57:58.613");
      System.out.println(parse);


      //
      DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
      //格式化
      String format1 = formatter1.format(localDateTime);
      System.out.println(format1);

      DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
      String format2 = formatter2.format(LocalDate.now());
      System.out.println(format2);


      //
      DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
      //格式化
      String format3 = formatter3.format(LocalDateTime.now());
      System.out.println(format3);
      //解析
      TemporalAccessor parse1 = formatter3.parse("2020-09-28 10:16:42");
      System.out.println(parse1);


  }
}
