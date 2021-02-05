package com.hejx_javaCore.senior.generic;


import org.junit.Test;

import java.util.*;

/**
 * @Classname GenericTest
 * @Description TODO
 * @Date 18:15 2021/1/24
 * @Created by hejx
 *
 * 泛型的使用
 * 1. jdk 5.0新增的特性
 *
 * 2. 在集合中使用泛型
 * 总结：
 * 1.集合接口或集合类在jdk5.0时都修改为带泛型的结构
 * 2.在实例化集合类时，可以指明具体的泛型类型
 * 3.指明完以后，在集合类或接口中凡是定义或接口时，内部结构使用到类的泛型的位置，都指定为实例化的泛型类型
 * 4.注意点：泛型的类型必须是类，不能是基本数据类型，需要用到基本数据类型时用包装类转换
 * 5.如果实例化时，没有指明泛型的类型。默认类型为java.lang.Object类型
 *
 * 3. 如何自定义泛型结构：泛型类、泛型接口、泛型方法 见GenericTest.java
 *
 *
 *
 *
 */

public class GenericTest {


    //在集合中使用泛型之前的情况
    @Test
    public void test(){
        ArrayList list=new ArrayList();

        list.add(78);
        list.add(76);
        list.add(89);
        list.add(88);

        //1.类型不安全
        list.add("Tom");


        for(Object score : list){
            //2.强转时，出现ClassCastException
            int stuScore =(Integer) score;

            System.out.println(stuScore);

        }

    }


    //在集合中使用泛型之前的情况
    @Test
    public void test2(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(78);
        list.add(76);
        list.add(89);
        list.add(88);

        //编译时就会进行类型检查，保证数据的安全
       // list.add("Tom");
        //方式一：
//        for(Integer score : list){
//            System.out.println(score);
//
//        }

        //方式二
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }


    @Test
    public void test3(){
        Map<String, Integer> map = new HashMap<String, Integer>();

       map.put("Tom",90);

       //map.put(99,"Map");


        //泛型的嵌套
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();

        while(iterator.hasNext()){
            Map.Entry<String, Integer> e = iterator.next();
            String key = e.getKey();
            Integer value = e.getValue();
            System.out.println(key+":"+value);

        }


    }



}
