package com.hejx_javaCore.senior.enum1;

import java.util.ArrayList;

/**
 * @Classname AnnotationTest
 * @Description TODO
 * @Date 2020/10/9 13:07
 * @Created by hejx
 *
 * 1.理解Annotation:
 *   ①.jdk5.0新增功能
 *   ②\③ 看ppt
 *
 * 2.Annotation的使用举例
 *  示例一： 生成文档相关的注解
 *  示例二： 在编译时进行格式检查(JDK内置的三个基本注解)
 *        @Override: 限定重写父类方法，该注解只能用于方法
 *        @Deprecated: 用于表示所修饰的元素已过时
 *        @SuppressWarnings: 抑制编译器警告
 *
 *
 * 3.如何自定义注解
 *     参照SuppressWarnings去定义
 *     1).注解声明为@interface
 *     2).内部定义成员，通常使用value表示
 *     3).可与指定成员的默认值，使用default定义
 *     4). 如果自定义注解没有成员，表明是一个标志
 *
 * 4.jdk提供4种元注解
 *    元注解用于修饰其他注解
 *  @Retention: 指定所修饰的注解的生命周期： SOURCE/CLASS(默认行为)/RUNTIME  只有声明为RUNTIME生命周期的注解，才能通过反射获取。
 *  @Target: 用于指定修饰的注解能用于修饰哪些程序元素
 *  @Documented: 表示所修饰的注解被javadoc解析时，保留下来。
 *  @Inherited: 被它修饰的注解将具有继承性
 *
 * 5.通过反射获取注解信息 ---到反射内容时系统讲解
 *
 * 6.jdk8中注解的新特性：可重复注解、类型注解
 *    6.1可重复注解：MyAnnotation中@Repeatable注解
 *                  1.在MyAnnotation上声明@Repeatable,成员值为MyAnnotations.class
 *                  2.MyAnnotation的Inherited、Target、Retention注解要一致
 *    6.2类型注解：
 *
 *
 *
 */
public class AnnotationTest {
    public static void main(String[] args) {

    }
}
//使用MyAnnotation注解
//@MyAnnotation("word")
//jdk8之前的重复注解
//@MyAnnotations({@MyAnnotation("word"),@MyAnnotation("word")})
@MyAnnotation
@MyAnnotation
class Person{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void walk(){
        System.out.println("人走路");
    }

    public void eat(){
        System.out.println("人吃饭");
    }
}


//TYPE_PARAMETER
class Deneric<@MyAnnotation T>{

     //TYPE_USE
    public void show() throws @MyAnnotation RuntimeException{
        ArrayList<@MyAnnotation String> list=new ArrayList<>();

        int n= (@MyAnnotation int) 10L;

  }
}