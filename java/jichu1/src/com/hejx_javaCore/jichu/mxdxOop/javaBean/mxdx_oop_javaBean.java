package com.hejx_javaCore.jichu.mxdxOop.javaBean;
/**
 * javaBean
 *  是指符合如下标准的java类：
 *     1.类是公共的
 *     2.有一个无参构造器
 *     3.有属性，且有对应的get\set方法
 *
 *
 *
 *
 */
public class mxdx_oop_javaBean {
}


class Customer{
    private int id;
    private String name;

    public Customer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}