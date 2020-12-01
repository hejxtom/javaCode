package com.hejx_javaCore.senior.collectionpakage;

import org.junit.Test;

import java.util.*;

/**
 * @Classname CollectionTest
 * @Description TODO
 * @Date 2020/10/15 16:17
 * @Created by hejx
 *
 * 集合框架的概述：
 * 1.集合、数组都是对多个数据进行存储操作的结构，简称Java容器
 *    说明：此时的存储。主要是指内存层面的存储，不涉及到持久化的存储
 * 2.1 数组在存储多个数据方面的特点：
 *     > 一旦初始化以后，其长度就确定了
 *     > 数组定义好以后，其元素类型也确定了
 * 2.2数组在存储多个数据方面的缺点 ：
 *    > 一旦初始化以后，其长度就不可修改
 *    > 数组中提供的方法非常有限，对于添加、删除、插入数据等操作，非常不便。
 *    > 获取数组中实际的个数的需求，数组并没有现成的属性和方法可用
 *    > 数组存储数据的特点：有序
 *
 * 二、集合框架
 *     |----Collection接口: 单列集合，用来存储一个一个对象
 *        |----List接口:存储有序的、可重复的数据   -->"动态数组"
 *            |---ArrayList\LInkedList\Vector
 *        |----Set接口：存储无序的，不可重复的数据  -->""
 *           |---- HashSet\LinkedSet\TreeSet
 *
 *    |-----Map：双列集合，用来存储一对一对的数据(key-value)
 *          |-----HashMap\LinkedHashMap\ThreeMap\Hashtable\Properties
 *
 *
 *
 *
 * 三、Collection接口中的API:
 *     向Collection接口的实现类的对象中添加数据obj（对象）时，要求obj所在类要重写equals().
 */
public class CollectionTest {

    @Test
    public  void test5(){
        Collection coll=new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);

        //iterator():返回Iterator接口的实例，用于遍历集合元素（在IteratorTest.java中）


    }


    @Test
    public void test4(){
        Collection coll=new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);

        //retainAll(Collection coll1):交集。获取当前集合和coll1集合的交集，并返回给当前集合(仅保留此集合中包含在指定集合中的元素)
      /*  Collection coll1=Arrays.asList(123,456,789);
        coll.retainAll(coll1);
        System.out.println(coll);*/

        //equals(Object obj):里面实际参数为集合
        Collection coll2=new ArrayList();
        coll2.add(456);
        coll2.add(123);
        coll2.add(new Person("Jerry",20));
        coll2.add(new String("Tom"));
        coll2.add(false);

        System.out.println(coll.equals(new String("Tom")));
        System.out.println(coll.equals(coll2));

        //hashCode()
        System.out.println("hashCode:"+coll.hashCode());

        //集合 --->数组：Object[] toArray()
        Object[] objects = coll.toArray();
        for(Object obj :objects){
            System.out.print(obj+"  ");
        }
        System.out.println();

        //数组 -->集合:调用Arrays类的静态方法asList

        Collection<Object> objects1 = Arrays.asList(123, 456, "abc", 'a', new Person("Tome", 22),true);
        System.out.println(objects1);


    }

    @Test
    public void test3(){
        //remove(Object obj):从当前集合中移除obj元素
        Collection coll=new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);
        coll.remove(123);
        System.out.println(coll);

        coll.remove(new Person("Jerry",20));
        System.out.println(coll);


      /*  Collection coll1=new ArrayList();
        coll1.add(456);*/
         Collection coll1=Arrays.asList(456,false,789);
        //removeAll(Collection coll1):从当前集合中移除coll1中所有元素
         coll.removeAll(coll1);
         System.out.println(coll);
    }


   @Test
    public void test2(){
       Collection coll = new ArrayList();
       coll.add(new Person("Jerry", 20));
       coll.add(123);
       coll.add(456);
       coll.add(new String("Tom"));
       coll.add(false);

       Person p=new Person("Jerry",20);
       coll.add(p);

       //1.contains(Object obj)调用equals()
       boolean contains = coll.contains(123);
       System.out.println(contains);
       System.out.println(coll.contains(new String("Tom")));
       System.out.println(coll.contains(p));
       System.out.println(coll.contains(new Person("Jerry", 20)));

       System.out.println("containsAll()...");
       //containsAll(Collection coll):判断形参coll1中所有元素是否都存在于当前集合中
       Collection coll1= Arrays.asList(123,456);
       System.out.println( coll.containsAll(coll1));

   }



    @Test
    public  void test1(){
        Collection coll = new ArrayList();

        //add(Object e):
        coll.add("AA");
        coll.add(123);
        coll.add(new Date());

        //size():
        System.out.println(coll.size());

        //addAll(Collection coll1):将coll1集合中的元素添加到当前的集合中
        Collection coll1=new ArrayList();
        coll1.add(456);
        coll1.add("CC");
        coll.addAll(coll1);
        System.out.println(coll.size());
        System.out.println(coll);


        coll.clear();

        //isEmpty():判断当前集合是否为空（是否有元素）
        System.out.println(coll.isEmpty());

    }

}
