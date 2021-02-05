package com.hejx_javaCore.senior.generic.shiyong;

/**
 * @Classname DAO
 * @Description TODO
 * @Date 14:14 2021/1/26
 * @Created by hejx
 */

//数据库中每张表对应一个java类叫ORM

public class DAO<T> { //表的共性操作的DAO

    public void add(T t) {

    }

    public boolean remove(int id) {
        return false;
    }

    //泛型方法
    //举例：获取表中一共有多少条记录？获取最大的员工入职时间
    public <E> E getValue(){


        return null;
    }

}
