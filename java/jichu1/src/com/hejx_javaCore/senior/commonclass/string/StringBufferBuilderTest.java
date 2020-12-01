package com.hejx_javaCore.senior.commonclass.string;

import org.junit.Test;

/**
 * @Classname StringBufferBuilderTest
 * @Description TODO
 * @Date 2020/9/17 8:23
 * @Created by hejx
 *
 * 扩容情况：如果添加的数据底层数组，盛装不下，那就需要扩容底层的数组.
 *          默认情况下,扩容为原来的两倍+2,同时将原有数组中的元素赋值到新的数组中
 *
 * 开发中建议大家使用:StringBuffer(int capacity)
 *
 *总结：
 *  多关注增、删、改、查、插、长度、遍历
 *
 */
public class StringBufferBuilderTest {
/**
 *  StringBuffer append(xxx):提供了很多的append()方法,用于进行字符串拼接
 *  StringBuffer delete(int start ,int end):删除指定位置的内容
 *
 *
 */
    @Test
    public void test2(){
     StringBuffer s1=new StringBuffer("abc");
     s1.append("tom");
     System.out.println(s1);
     s1.delete(3,5); //[3,5)
     System.out.println(s1);
    }



    /**
     * String、StringBuffer、StringBuilder三者的异同？
     * String: 不可变的字符序列；使用char[] 数组进行存储，
     * StringBuffer: 可变的字符序列，线程安全的，效率偏低；使用char[] 数组进行存储
     * StringBuilder: 可变的字符序列，线程不安全的，效率高；使用char[] 数组进行存储
     *
     *
     * 对比String、StringBuffer、StringBuilder三者的效率：
     *  从高到低：StringBuilder>StringBuffer>String
     */

    @Test
    public void test1(){
        StringBuffer buffer=new StringBuffer("abc");
        System.out.println(buffer.length()); //3 length():return count;
    }
}
