package com.hejx_javaCore.senior.commonclass.string;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @Classname StringTest1
 * @Description TODO
 * @Date 2020/9/16 13:15
 * @Created by hejx
 *
 * String与其他结构的转换
 *
 *
 */
public class StringTest1 {

    /**
     *  String 与byte[] 之间的转换
     *
     * 编码：字符串-->字节
     * 解码： 编码的逆过程，字节-->字符串
     *
     * 说明：解码是，要求解码使用的字符集必须与编码时使用的字符集一致，否则会出现乱码
     */

    @Test
    public void test3() throws UnsupportedEncodingException {
        /**
         * String --> byte[]
         *
         *
         *
         */
        String str1 = "abc123中国";
        byte[] bytes = str1.getBytes();

        for (int i = 0; i < str1.length(); i++) {
            System.out.println(bytes[i]);
        }
        System.out.println(Arrays.toString(bytes));

        byte[] gbks;
        gbks = str1.getBytes("gbk");
        System.out.println(Arrays.toString(gbks));

        /**
         *
         * byte[] ---> String
         *
         *
         *
         */
        String s2 = new String(bytes);
        String s4 = new String(gbks,"gbk"); //出现乱码，编码集和解码集不一致！
        System.out.println(s2);
        System.out.println(s4);
        String s3 = new String(gbks,"gbk");
        System.out.println(s3);




    }

    /**
     * 与char[] 数组之间的转换
     * String --> char[]: 调用String的toCharArray()
     *char[]  --> String
     *
     */
    @Test
    public void test2(){
        String str1="abc123";
        char[] chars=str1.toCharArray();
        for (int i = 0; i < str1.length(); i++) {
            System.out.print(chars[i]+" ");
        }
        System.out.println();
        String str2 = new String(chars);
        System.out.println(str2);

    }


    /**
     * 与基本数据类型、包装类之间的转换
     *  String --> 基本数据类型、包装类：调用包装类的静态方法：parseXxx(str)
     *  基本数据类型、包装类 --> String:调用String重载的valueof(xxx)
     *
     */
   @Test
    public void test1(){
   }


}
