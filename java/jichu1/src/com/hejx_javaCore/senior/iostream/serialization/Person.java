package com.hejx_javaCore.senior.iostream.serialization;


import java.io.Serializable;

/**
 * @Classname Person
 * @Description TODO
 * @Date 14:05 2021/1/27
 * @Created by hejx
 *
 * Person需要满足以下条件，方可序列化
 * 1.需要实现接口：Serializable
 * 2.当前类需要提供一个全局常量：serialVersionUID
 * 3.除了当前Personl类需要实现Serializable接口之外，还必须保证其内部所有属性可序列化。(默认基本数据类型可序列化)
 *
 *
 * 补充：不能序列化static和transient修饰的成员变量
 *
 */

public class Person  implements Serializable {

    //序列化的版本号
   private static final long serialVersionUID = 473434665880896L;

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
