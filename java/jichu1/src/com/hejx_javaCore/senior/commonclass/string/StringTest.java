package com.hejx_javaCore.senior.commonclass.string;

import org.junit.Test;

/**
 * @Classname StringTest
 * @Description TODO
 * @Date 2020/9/13 15:00
 * @Created by hejx
 *
 * 面试题：
 *       String s=new String("abc");方式创建对象，在内存中创建了几个对象？
 *       两个：一个是堆空间中的new结构，另一个是char[]对应的常量池中的数据："abc"
 *
 *
 *
 *
 */


class StrTest{
    /**
     * 面试题
     *
     *
     */
    String str=new String("good");
    char[] ch={'t','e','s','t'};
    public void change(String str,char ch[]){
        str="test ok";
        ch[0]='b';
    }

    public static void main(String[] args) {
        StrTest ex=new StrTest();
        ex.change(ex.str,ex.ch);
        System.out.println(ex.str+" and ");
        System.out.println(ex.ch);
    }

}

public class StringTest {




    /**
     * 结论：
     * 常量与常量的拼接结果在常量池中。且常量池中不会存在相同内容的常量。
     * 只要其中有一个是变量，结果就在堆中。
     * 如果拼接结果调用intern()方法，返回值就在常量池中
     */
    @Test
    public void test3(){
        String s1="hello";
        String s2="world";

        String s7="helloworld";
        String s3 ="hello"+"world";
        String s4=s1+"world";
        String s5="hello"+s2;
        String s6=s1+s2;

        System.out.println(s7==s3);  //true
        System.out.println(s7==s4);  //false


        String s8=s5.intern(); //返回值得到的s8使用的常量池中已经存在的"helloworld"
        System.out.println(s3==s8);//true

    }


    /**
     * String的实例方法：
     *   方式一：通过字面量定义的方式
     *   方式二：通过new +构造器的方式
     *
     */
    @Test
    public void test2(){
     //通过字面量定义的方式：此时的s1和s2的数据javaEE声明在方法区中的字符串常量池中
        String s1="javaEE";
        String s2="javaEE";
     //通过new +构造器的方式：此时的s3和s4保存的地址值，是数据在堆空间中开辟空间以后对应的地址值
        String s3=new String("javaEE");
        String s4=new String("javaEE");

    }

    /**
     * String:字符串，使用一对""引起来表示
     *        1.String 声明为final的，不可被继承
     *        2.String实现了Serializable接口：表示字符串是支持序列化的。
     *                实现了Comparable接口：表示String可以比较大小
     *        3.String内部定义了final char[] value用于存储字符串数据
     *        4.String:代表不可变的字符序列。简称：不可变性
     *            体现：1.当对字符串重新赋值时，需要重写指定内存区域，不能使用原有的value进行赋值
     *                  2.当对现有的字符串进行连接操作时，也需要重新指定内存赋值，不能再原有的value进行赋值
     *                  3.当调用String的replace()方法修改字符串时，需要重新指定内存赋值，不能再原有的value进行赋值
     *        5.通过字面量的方式(区别new)给一个字符串赋值，此时的字符串值声明在字符串常量池中。
     *        6.字符串常量池中是不会存储相同的内容的字符串的
     *
     *
     */
    @Test
    public void test(){

    }


}
